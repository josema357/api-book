package com.josema.book.client;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.josema.book.dto.DiscountRequest;

@SpringBootTest
@ActiveProfiles("test")
public class DiscountApiClientTest {
  @Mock
  private RestTemplate restTemplate;
  @Mock
  private Environment environment;
  @InjectMocks
  private DiscountApiClient discountApiClient;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void validateDiscountThrowsRestClientException() {
    DiscountRequest discountRequest = new DiscountRequest("123", "456", "D0542A23");
    String discountUrl = "http://mock-url";
    when(environment.getProperty("DISCOUNT_URL")).thenReturn(discountUrl);
    when(restTemplate.postForObject(
        anyString(),
        any(DiscountRequest.class),
        any()))
        .thenThrow(RestClientException.class);

    assertThrows(RestClientException.class, () -> discountApiClient.validateDiscount(discountRequest));
    verify(environment).getProperty("DISCOUNT_URL");
  }
}
