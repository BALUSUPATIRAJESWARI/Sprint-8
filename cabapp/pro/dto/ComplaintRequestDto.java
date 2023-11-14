package com.cabapp.pro.dto;

import com.cabapp.pro.entity.Customer;
import com.cabapp.pro.entity.Driver;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToOne;

@Data
public class ComplaintRequestDto {
    private Integer complaintId;
    private String dateOnRegister;
    private String comment;
    private String status;
    private String email;
    private Customer customerId;
    private Driver driverId;
}
