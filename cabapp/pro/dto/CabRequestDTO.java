package com.cabapp.pro.dto;

import org.springframework.stereotype.Component;

@Component
public class CabRequestDTO {
	
	private int cabId;
	private String carType;
	private float perKmRate;
	 
	public CabRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 

	public CabRequestDTO(int cabId, String carType, float perKmRate) {
		super();
		this.cabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
		 
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
