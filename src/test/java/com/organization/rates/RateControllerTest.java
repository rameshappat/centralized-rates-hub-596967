package com.organization.rates;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for RateController.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class RateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private RateService rateService;

    @BeforeEach
    public void setUp() {
        rateService = Mockito.mock(RateService.class);
    }

    @Test
    public void testCreateRate() throws Exception {
        Rate rate = new Rate(1L, "Deposit", BigDecimal.valueOf(1.5), LocalDateTime.now(), LocalDateTime.now().plusDays(30));
        Mockito.when(rateService.createRate(Mockito.any(Rate.class))).thenReturn(rate);

        mockMvc.perform(post("/api/rates")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(rate)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    public void testGetRate() throws Exception {
        Rate rate = new Rate(1L, "Deposit", BigDecimal.valueOf(1.5), LocalDateTime.now(), LocalDateTime.now().plusDays(30));
        Mockito.when(rateService.getRate(1L)).thenReturn(Optional.of(rate));

        mockMvc.perform(get("/api/rates/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value("Deposit"));
    }
}