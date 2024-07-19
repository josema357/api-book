package com.josema.book.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.josema.book.controller.BookingController;
import com.josema.book.dto.BookRequest;
import com.josema.book.dto.BookResponse;
import com.josema.book.model.Booking;
import com.josema.book.repository.BookingRepository;

@Service
public class BookingService {
  private final BookingRepository bookingRepository;
  private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

  public BookingService(BookingRepository bookingRepository){
    this.bookingRepository = bookingRepository;
  }

  @Transactional
  public BookResponse registerBooking(BookRequest bookRequest){
    logger.debug("Entering method : registerBooking");
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
      logger.info("Successfully saved booking", bookRequest.id());
      logger.debug("Existing method : registerBooking");
    } catch (Exception e) {
      logger.error("Error saving booking");
      throw e;
    }
    

    return new BookResponse(200, "Book Accepted");
  }
}
