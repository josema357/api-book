package com.josema.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josema.book.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
  
}
