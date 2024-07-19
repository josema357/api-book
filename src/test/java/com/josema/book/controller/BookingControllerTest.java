package com.josema.book.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.josema.book.dto.BookRequest;
import com.josema.book.dto.BookResponse;
import com.josema.book.service.BookingService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BookingController.class)
public class BookingControllerTest {
  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private BookingService bookingService;

  @Test
  public void saveBooking() throws Exception{
    BookResponse bookResponse = new BookResponse(200, "Book Accepted");
    when(bookingService.registerBooking(Mockito.any(BookRequest.class))).thenReturn(bookResponse);
    mockMvc.perform(post("/book")
      .contentType(MediaType.APPLICATION_JSON)
      .content("{\n" +
            "  \"id\": \"14564088-4\",\n" +
            "  \"name\": \"Gonzalo\",\n" +
            "  \"lastname\": \"Pérez\",\n" +
            "  \"age\": 33,\n" +
            "  \"phoneNumber\": \"56988123222\",\n" +
            "  \"startDate\": \"2024-07-19\",\n" +
            "  \"endDate\": \"2024-07-19\",\n" +
            "  \"houseId\": \"213132\",\n" +
            "  \"discountCode\": \"D0542A23\"\n" +
            "}"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.code").value(200))
      .andExpect(jsonPath("$.message").value("Book Accepted"));
  }
  @Test
  public void saveBookingWithInvalidRequest() throws Exception {
    mockMvc.perform(post("/book")
    .contentType(MediaType.APPLICATION_JSON)
    .content("{\n" +
            "  \"id\": \"14564088-4\",\n" +
            "  \"age\": 33,\n" +
            "  \"phoneNumber\": \"56988123222\",\n" +
            "  \"startDate\": \"2024-07-19\",\n" +
            "  \"endDate\": \"2024-07-19\",\n" +
            "  \"houseId\": \"213132\",\n" +
            "  \"discountCode\": \"D0542A23\"\n" +
            "}"))
    .andExpect(status().isBadRequest())
    .andExpect(jsonPath("$.statusCode").value(400))
    .andExpect(jsonPath("$.error").value("Bad Request"));
  }
}
