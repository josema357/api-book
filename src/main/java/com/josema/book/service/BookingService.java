package com.josema.book.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.josema.book.dto.BookRequest;
import com.josema.book.dto.BookResponse;
import com.josema.book.model.Booking;
import com.josema.book.repository.BookingRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookingService {
  private final BookingRepository bookingRepository;

  public BookingService(BookingRepository bookingRepository){
    this.bookingRepository = bookingRepository;
  }

  @Transactional
  public BookResponse registerBooking(BookRequest bookRequest){
    log.debug("Entering method : registerBooking");
    Booking booking = new Booking(
      bookRequest.id(),
      bookRequest.name(),
      bookRequest.lastname(),
      bookRequest.age(),
      bookRequest.phoneNumber(),
      bookRequest.startDate(),
      bookRequest.endDate(),
      bookRequest.houseId(),
      bookRequest.discountCode()
    );
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
}
