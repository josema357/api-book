package com.josema.book.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;

import com.josema.book.client.DiscountApiClient;
import com.josema.book.dto.BookRequest;
import com.josema.book.dto.BookResponse;
import com.josema.book.dto.DiscountRequest;
import com.josema.book.dto.DiscountResponse;
import com.josema.book.exception.InvalidDiscountException;
import com.josema.book.model.Booking;
import com.josema.book.repository.BookingRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookingService {
  private final BookingRepository bookingRepository;
  private final DiscountApiClient discountApiClient;

  public BookingService(BookingRepository bookingRepository, DiscountApiClient discountApiClient){
    this.bookingRepository = bookingRepository;
    this.discountApiClient = discountApiClient;
  }

  @Transactional
  public BookResponse registerBook(BookRequest bookRequest){
    log.debug("Inside BookingService registerBook method");
    if(bookRequest.discountCode() != null){
      DiscountResponse discountResponse = validateDiscount(bookRequest);
      if(discountResponse.status() == false){
        log.error("Invalid discount code : {}", bookRequest.discountCode());
        throw new InvalidDiscountException("Invalid discount");
      }
    }
    Booking booking = new Booking(bookRequest);
    try {
      bookingRepository.save(booking);
      log.info("Successfully saved booking : bookId : {}", bookRequest.id());
      log.debug("Existing method : registerBooking");
    } catch (Exception e) {
      log.error("Error saving booking");
      throw e;
    }
    return new BookResponse(200, "Book Accepted");
  }

  private DiscountResponse validateDiscount(BookRequest bookRequest){
    DiscountRequest discountRequest = new DiscountRequest(
          bookRequest.id(), 
          bookRequest.houseId(), 
          bookRequest.discountCode());
      try {
        DiscountResponse discountResponse = discountApiClient.validateDiscount(discountRequest);
        return discountResponse;
      } catch (RestClientException e) {
        log.error("I/O error on POST request for API discount");
        throw e;
      }
  }
}
