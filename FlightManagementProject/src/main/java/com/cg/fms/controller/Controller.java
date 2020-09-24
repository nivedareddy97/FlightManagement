package com.cg.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.Exception.BookedListNotFoundException;
import com.cg.fms.Exception.UserNotFoundException;
import com.cg.fms.dto.Booking;
import com.cg.fms.dto.Users;
import com.cg.fms.service.IBooking;

@RestController
@RequestMapping("/Flights")
@CrossOrigin("http://localhost:4200")
public class Controller {

	@Autowired
	IBooking bookingService;

	// User Registration
	@PostMapping(value = "/UserRegistration")
	public ResponseEntity<String> addBookingDetails(@RequestBody() Users user) {

		Users u = bookingService.registerDetails(user);
		if (u != null)
			return new ResponseEntity<String>("User Registered succesfully", HttpStatus.OK);
		else
			return new ResponseEntity<String>("booking unsuccesful", HttpStatus.OK);
	}

	// For login check
		@PostMapping("/CheckLogin/{username}/{password}")
		public ResponseEntity<String> loginVerification(@PathVariable String username, @PathVariable String password) throws UserNotFoundException {
			Users user = bookingService.loginCheck(username, password);
			if (user != null) {
				return new ResponseEntity<String>("Login Succesful", HttpStatus.OK);
			} else
				throw new UserNotFoundException("Login unsuccessful");

		}
		@ExceptionHandler(UserNotFoundException.class)
		public ResponseEntity<String> userNotFoundException(UserNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}

		//gets booking list
		@GetMapping("GetBookingslist")
		public ResponseEntity<List<Booking>> loginVerification() throws BookedListNotFoundException{
			List<Booking> bookingList = bookingService.getBookingList();
			if (!bookingList.isEmpty()) {
				return new ResponseEntity<List<Booking>>(bookingList, HttpStatus.OK);
			} else
				throw new BookedListNotFoundException("booking list not found");

		}
		@ExceptionHandler(UserNotFoundException.class)
		public ResponseEntity<String> bookedListNotFoundException(BookedListNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}

}
