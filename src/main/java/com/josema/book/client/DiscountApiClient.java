package com.josema.book.client;

import org.springframework.core.env.Environment;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.josema.book.dto.DiscountRequest;
import com.josema.book.dto.DiscountResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DiscountApiClient {
  private RestTemplate restTemplate;
  private Environment environment;

  public DiscountApiClient(RestTemplate restTemplate, Environment environment) {
    this.restTemplate = restTemplate;
    this.environment = environment;
  }

  @Retryable(
    value = { RestClientException.class }, 
    maxAttempts = 3,
    backoff = @Backoff(delay = 2000)
  )
  public DiscountResponse validateDiscount(DiscountRequest discountRequest) {
    log.info("Validating discount code");
    String DISCOUNT_URL = environment.getProperty("DISCOUNT_URL");

    try {
      DiscountResponse discountResponse = restTemplate.postForObject(
        DISCOUNT_URL, 
        discountRequest, 
        DiscountResponse.class);
      log.info("Validation completed : {}", discountResponse);
      return discountResponse;
    } catch (RestClientException e) {
      log.error("Error during discount validation");
      throw e;
    }
  }
}
