package poc.service;

import poc.model.Hospital;
import poc.model.Speciality;
import poc.repository.HospitalRepository;
import org.springframework.stereotype.Service;
import poc.util.FindClosestHospitalWithSpecialityAndAvailableBeds;

import java.util.List;

@Service
public class HospitalService {
    private HospitalRepository hospitalRepository;

    public Hospital addHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    public List<Hospital> getHospitals() {
        return hospitalRepository.findAll();
    }

    public String getClosestHospitalsWithRightSpecialityAndAvailableBeds(double latitude, double longitude, String specialityName) {
        return FindClosestHospitalWithSpecialityAndAvailableBeds.name(latitude, longitude, specialityName);
    }
}
