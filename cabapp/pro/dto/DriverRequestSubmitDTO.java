package com.cabapp.pro.dto;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class DriverRequestSubmitDTO {
	@NotNull(message = "username cannot be null")

	private String username;
	@NotNull(message = "mobile cannot be null")

	private String mobileNumber;
	@NotNull(message = "password cannot be null")

	private String password;
	private String address;
	private int driverId;
	private String licenseNo; 
	private String email;
	 
	public DriverRequestSubmitDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	public DriverRequestSubmitDTO(String username, String mobileNumber, String password, String address, int driverId,
			String licenseNo, String email) {
		super();
		this.username = username;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.address = address;
		this.driverId = driverId;
		this.licenseNo = licenseNo;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 
	 
	
}