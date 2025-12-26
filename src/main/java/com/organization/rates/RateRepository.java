package com.organization.rates;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Rate entity.
 */
public interface RateRepository extends JpaRepository<Rate, Long> {
}