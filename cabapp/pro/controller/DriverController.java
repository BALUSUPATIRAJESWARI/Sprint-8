package com.cabapp.pro.controller;

import com.cabapp.pro.service.IComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabapp.pro.dto.DriverRequestSubmitDTO;
import com.cabapp.pro.dto.DriverResponseDTO;
import com.cabapp.pro.entity.Driver;
import com.cabapp.pro.entity.TripBooking;
import com.cabapp.pro.service.IDriverService;
import com.cabapp.pro.util.DriverDTOMapper;

@RestController
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	IDriverService driverService;
	@Autowired
	IComplaintService complaintService;
	
	@PostMapping("/reg/dri")
	public DriverResponseDTO saveDriverInfo(@RequestBody DriverRequestSubmitDTO dto) {
		
		if(dto!=null) {
			DriverDTOMapper converter=new DriverDTOMapper();
			Driver driver= converter.getDriverFromDriverDTO(dto);
			
			return converter.getDriverDTOFromDriver( driverService.InsertDriver(driver));
		}
		
		
		return null;
	}
	
	
	@GetMapping("/get/booking/{userId}")//doubton triggering once the booking has happened
	public TripBooking getTripBookinginfo(@PathVariable int userId) {
		TripBooking trip=driverService.getTripBookingByCustomer(userId);
		return trip;
	}

	@GetMapping("/complaintOnDriver/{id}")
	public ResponseEntity<Object> findComplaintsonDriver(@PathVariable("id") int driverId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(complaintService.complaintOnDriver(driverId));
		} catch(Exception exception) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);

		}
	}
	
	
	
	

}
