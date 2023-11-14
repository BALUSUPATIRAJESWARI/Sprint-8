package com.cabapp.pro.service;


import com.cabapp.pro.entity.Cab;
import com.cabapp.pro.repository.ICabRepository;
import com.cabapp.pro.repository.ITripBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CabServiceImpl implements ICabService {

    @Autowired
    ICabRepository cabRepo;

    @Autowired
    ITripBookingRepository tripBooking;

    @Override
    public Cab insertCab(Cab cab) {
        cab.setStatus("unassigned");
        return cabRepo.save(cab);
    }

    @Override
    public Cab updateCab(Cab cab) {

        int id = (int) cab.getCabId();
        Cab cabById = cabRepo.findById(id).get();
        if (cabById != null) {
            if (cab.getCarType() != null) {
                cabById.setCarType(cab.getCarType());
            }
            if (cab.getPerKmRate() != 0) {
                cabById.setPerKmRate(cab.getPerKmRate());
            }
            if (cab.getStatus() != null) {
                cabById.setStatus(cab.getStatus());
            }

            return cabRepo.save(cabById);
        }

        return null;
    }

    @Override
    public String deleteCab(int cabId) {
        cabRepo.deleteById(cabId);
        return "deleted";

    }

    @Override
    public List<Cab> viewCabsOfType(String carType) {
        return cabRepo.getCabByCarType(carType);

    }

    @Override
    public Integer countCabsOfType(String carType) {
        List<Cab> CabsByType = cabRepo.getCabByCarType(carType);
        return CabsByType.size();
    }
}
