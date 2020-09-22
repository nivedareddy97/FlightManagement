package com.cg.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<String> loginVerification(@PathVariable String username, @PathVariable String password) {
		Users user = bookingService.loginCheck(username, password);
		if (user != null) {
			return new ResponseEntity<String>("Login Succesful", HttpStatus.OK);
		} else
			return new ResponseEntity<String>("Login unsuccessful", HttpStatus.OK);

	}

	@GetMapping("GetBookingslist")
	public ResponseEntity<List<Booking>> loginVerification() {
		List<Booking> bookingList = bookingService.getBookingList();
		if (!bookingList.isEmpty()) {
			return new ResponseEntity<List<Booking>>(bookingList, HttpStatus.OK);
		} else
			return new ResponseEntity<List<Booking>>(bookingList, HttpStatus.NOT_FOUND);

	}

}
