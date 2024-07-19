package com.josema.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class BookApplication {

	public static void main(String[] args) {
		log.info("Starting Booking application");
		SpringApplication.run(BookApplication.class, args);
		log.info("Started successfully");
	}

}
