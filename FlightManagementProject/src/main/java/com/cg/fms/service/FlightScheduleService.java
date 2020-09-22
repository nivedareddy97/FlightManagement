package com.cg.fms.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.FlightScheduleDao;
import com.cg.fms.dto.FlightSchedule;

@Service
@Transactional
public class FlightScheduleService implements IFlightSchedule {

	@Autowired
	FlightScheduleDao flightSchedule;

	
}
