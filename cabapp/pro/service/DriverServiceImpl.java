package com.cabapp.pro.service;

import java.util.List;
import java.util.stream.Collectors;

import com.cabapp.pro.exception.AdminException;
import com.cabapp.pro.exception.DriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabapp.pro.entity.Cab;
import com.cabapp.pro.entity.Customer;
import com.cabapp.pro.entity.Driver;
import com.cabapp.pro.entity.TripBooking;
import com.cabapp.pro.repository.ICabRepository;
import com.cabapp.pro.repository.ICustomerRepository;
import com.cabapp.pro.repository.IDriverRepository;
import com.cabapp.pro.repository.ITripBookingRepository;

@Service
public class DriverServiceImpl implements IDriverService {

	@Autowired
	IDriverRepository driverRepository;
	
	@Autowired
	ICabRepository cabRepository;
	
	@Autowired
	ITripBookingRepository tripBooking;
	
	@Autowired
	ICustomerRepository customerRepository;

	@Autowired
	IComplaintService complaintService;

	@Override
	public Driver InsertDriver(Driver driver) {

		if (driver != null) {
			driver.setStatus("Pending");
			Driver savedDriverInfo = driverRepository.save(driver);

			return savedDriverInfo;
		}else {
			throw new DriverException(500,"Driver request details are null");
		}
	}

	@Override
	public List<Driver> getDriverByStatus(String status) {

		if (status != null) {
			List<Driver> finalList = driverRepository.getDriverByStatus(status);
			return finalList;
		} else {
			throw new DriverException(404,"Driver details details not found");
		}

	}

	@Override
	public Driver updateDriverByStatus(int driverId, String status, String newstatus) {

		List<Driver> driversListByStatus = driverRepository.getDriverByStatus(status);
		List<Cab> allCabs = cabRepository.findAll();
		List<Cab> newCabByStatus = allCabs.stream().filter(e -> e.getStatus().equals("unassigned"))
				.collect(Collectors.toList());

		for (Driver d : driversListByStatus) {

			if (d.getDriverId() == driverId) {
				d.setStatus(newstatus);
				driverRepository.save(d);
				if (d.getStatus().equals("ok")) {
					System.out.println("inside the cab to assign");
					d.setCab(newCabByStatus.get(0));
					newCabByStatus.get(0).setStatus("assigned");
					cabRepository.save(newCabByStatus.get(0));
					d.setAvailable(true);

					return driverRepository.save(d);
				}
			}

		}
		return null;
	}

	@Override//use separate dto to get the dtooutput....
	public TripBooking getTripBookingByCustomer(int userId) {
		//Driver driver=driverRepository.findById(userId).get();
		 Driver driver=driverRepository.findById(userId).get();
		
		List<TripBooking> alltrips=driver.getTripbookings();
		
		
		 //has to be list...
		for(TripBooking t: alltrips) {
			if(t.isStatus()) {
				 
				 return t;
			}
		}
		 
		return null;
	}

}
