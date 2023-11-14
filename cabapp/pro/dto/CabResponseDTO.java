package com.cabapp.pro.dto;

public class CabResponseDTO {
	
	
	private int cabId;
	private String carType;
	private float perKmRate;
	private String status;
	public CabResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	public CabResponseDTO(int cabId, String carType, float perKmRate, String status) {
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
		this.status = status;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCabId() {
		return cabId;
	}
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public float getPerKmRate() {
		return perKmRate;
	}
	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}
	
	

}
