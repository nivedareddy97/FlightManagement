package com.cg.fms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	@Column(name = "flight_no")
	String flightNo;
	@Column(name = "carrier_name")
	String carrierName;
	@Column(name = "seat_capacity")
	int seatCapacity;

	public Flight() {
	}

	public Flight(String flightNo, String carrierName, int seatCapacity) {
		this.flightNo = flightNo;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

}