package com.organization.rates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Service for managing rates.
 */
@Service
public class RateService {
    private static final Logger logger = LoggerFactory.getLogger(RateService.class);
    private final RateRepository rateRepository;

    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public Rate createRate(Rate rate) {
        logger.info("Creating a new rate: {}", rate);
        return rateRepository.save(rate);
    }

    public Optional<Rate> getRate(Long id) {
        logger.info("Retrieving rate with id: {}", id);
        return rateRepository.findById(id);
    }

    public List<Rate> getAllRates() {
        logger.info("Retrieving all rates");
        return rateRepository.findAll();
    }
}