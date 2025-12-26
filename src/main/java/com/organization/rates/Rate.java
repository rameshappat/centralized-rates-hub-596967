package com.organization.rates;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents a financial rate for deposits or indices.
 */
public class Rate {
    private Long id;
    private String type;
    private BigDecimal value;
    private LocalDateTime effectiveDate;
    private LocalDateTime expirationDate;

    public Rate(Long id, String type, BigDecimal value, LocalDateTime effectiveDate, LocalDateTime expirationDate) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.effectiveDate = effectiveDate;
        this.expirationDate = expirationDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
}