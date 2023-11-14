package com.cabapp.pro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cabapp.pro.entity.Driver;
import com.cabapp.pro.entity.TripBooking;


public interface IDriverService {
	
	
	public Driver InsertDriver(Driver driver);
	public List<Driver> getDriverByStatus(String status);
	public Driver updateDriverByStatus(int driverId,String status,String newStatus);
	public TripBooking getTripBookingByCustomer(int userId);
	
	
	
	

}
