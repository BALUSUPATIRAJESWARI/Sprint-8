package com.cabapp.pro.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@Component
public class TripBookingRequestSubmitDTO {
	
	private int customerId;
	@NotNull(message = "from location cannot be null")

	private String fromLocation;
	@NotNull(message = "to location cannot be null")

	private String toLocation;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	 
	private float distanceInKm;
	private float bill;
	public TripBookingRequestSubmitDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TripBookingRequestSubmitDTO(int customerId, String fromLocation, String toLocation,
			LocalDateTime fromDateTime, LocalDateTime toDateTime,  float distanceInKm, float bill) {
		super();
		this.customerId = customerId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		 
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}
	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	public LocalDateTime getToDateTime() {
		return toDateTime;
	}
	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}
	 
	public float getDistanceInKm() {
		return distanceInKm;
	}
	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}
	
	

}
