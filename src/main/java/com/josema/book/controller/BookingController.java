package com.josema.book.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josema.book.dto.BookRequest;
import com.josema.book.dto.BookResponse;
import com.josema.book.dto.ErrorResponse;
import com.josema.book.service.BookingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookingController {
  private final BookingService bookingService;

  public BookingController(BookingService bookingService){
    this.bookingService = bookingService;
  }

  @PostMapping
  @Operation(summary = "Reserva casa")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Reserva Casa",
      content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookResponse.class))}),
    @ApiResponse(responseCode = "400", description = "Request invalido",
    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
  })
  public ResponseEntity<BookResponse> registerBooking(@RequestBody @Valid BookRequest bookRequest){
    log.debug("Inside BookingController registerBooking method");
    try {
      log.info("Registering a new reservation");
      BookResponse response = bookingService.registerBook(bookRequest);
      log.info("Completed request to endpoint : message : {}", response.message());
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      throw e;
    }
    
  }
}
