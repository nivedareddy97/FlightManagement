package com.cg.fms.service;

import java.util.List;

import com.cg.fms.dto.Booking;
import com.cg.fms.dto.Users;

public interface IBooking {

	Users loginCheck(String username, String password);

	Users registerDetails(Users user);

	List<Booking> getBookingList();
	
	

}
