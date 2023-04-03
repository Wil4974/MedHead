package poc.service;

import poc.model.Hospital;
import poc.repository.HospitalRepository;
import org.springframework.stereotype.Service;
import poc.util.ClosestHospitalWithSpecialityAndAvailableBeds;

import java.util.List;

@Service
public class HospitalService {
    private HospitalRepository hospitalRepository;

    public List<Hospital> getHospitals() {
        return hospitalRepository.findAll();
    }

    public String getClosestHospitalsWithRightSpecialityAndAvailableBeds(double latitude, double longitude, String specialityName) {
        return ClosestHospitalWithSpecialityAndAvailableBeds.name(latitude, longitude, specialityName);
    }
}