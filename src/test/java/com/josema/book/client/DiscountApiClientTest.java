package com.josema.book.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.springframework.core.env.Environment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.josema.book.dto.DiscountRequest;
import com.josema.book.dto.DiscountResponse;

@ExtendWith(MockitoExtension.class)
public class DiscountApiClientTest {
  @Mock
  private RestTemplate restTemplate;
  @Mock
  private Environment environment;
  @InjectMocks
  private DiscountApiClient discountApiClient;

  @Test
  void validateDiscountThrowsRestClientException() {
    DiscountRequest discountRequest = new DiscountRequest("14564088-4", "213132", "D0542A23");
    String discountUrl = "http://mock-url";
    when(environment.getProperty("DISCOUNT_URL")).thenReturn(discountUrl);
    when(restTemplate.postForObject(
        discountUrl, discountRequest, DiscountResponse.class))
        .thenThrow(RestClientException.class);

    assertThrows(RestClientException.class, () -> discountApiClient.validateDiscount(discountRequest));
    verify(environment).getProperty("DISCOUNT_URL");
  }

  @Test
  void validateDiscountAndReturnDiscountResponse(){
    DiscountRequest discountRequest = new DiscountRequest("14564088-4", "213132", "D0542A23");
    DiscountResponse discountResponse = new DiscountResponse("2342", "D0542A23", 516, "2345678-3", true);
    String discountUrl = environment.getProperty("DISCOUNT_URL");
    when(restTemplate.postForObject(discountUrl, discountRequest, DiscountResponse.class))
      .thenReturn(discountResponse);
    DiscountResponse response = discountApiClient.validateDiscount(discountRequest);
    
    assertNotNull(response);
    assertEquals(discountResponse, response);
  }
}
