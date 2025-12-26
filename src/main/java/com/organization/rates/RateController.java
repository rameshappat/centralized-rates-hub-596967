package com.organization.rates;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller for managing rates.
 */
@RestController
@RequestMapping("/api/rates")
public class RateController {
    private final RateService rateService;

    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @PostMapping
    public ResponseEntity<Rate> createRate(@RequestBody Rate rate) {
        Rate createdRate = rateService.createRate(rate);
        return new ResponseEntity<>(createdRate, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rate> getRate(@PathVariable Long id) {
        return rateService.getRate(id)
                .map(rate -> new ResponseEntity<>(rate, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Rate>> getAllRates() {
        List<Rate> rates = rateService.getAllRates();
        return new ResponseEntity<>(rates, HttpStatus.OK);
    }
}