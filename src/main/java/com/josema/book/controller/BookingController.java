package com.josema.book.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josema.book.dto.BookRequest;
import com.josema.book.dto.BookResponse;
import com.josema.book.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookingController {
  private final BookingService bookingService;
  private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

  public BookingController(BookingService bookingService){
    this.bookingService = bookingService;
  }

  @PostMapping
  public ResponseEntity<BookResponse> registerBooking(@RequestBody @Valid BookRequest bookRequest){
    logger.info("Received request to endpoint");
    try {
      BookResponse response = bookingService.registerBooking(bookRequest);
      logger.info("Completed request to endpoint", response.message());
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      logger.error("Exception occurred while processing request to endpoint");
      throw e;
    }
    
  }
}
