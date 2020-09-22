package com.cg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.BookingDao;
import com.cg.fms.dao.UserDao;
import com.cg.fms.dto.Booking;
import com.cg.fms.dto.Users;

@Service
@Transactional
public class BookingService implements IBooking {

	@Autowired
	 BookingDao bookingdao;
	
	@Autowired
	 UserDao userdao;

	@Override
	public Users loginCheck(String username, String password) {
		return userdao.loginCheck(username, password);
		
	}


	// User Registration in serviceclass
	@Override
	public Users registerDetails(Users user)
	{
	return userdao.save(user);
	}


	@Override
	public List<Booking> getBookingList() {
		return bookingdao.findAll(Sort.by(Sort.Direction.DESC, "bookingId"));
	}
	
	

}
