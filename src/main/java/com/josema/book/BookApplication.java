package com.josema.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableRetry
public class BookApplication {

	public static void main(String[] args) {
		log.info("Starting Booking application");
		SpringApplication.run(BookApplication.class, args);
		log.info("Started successfully");
	}

}
