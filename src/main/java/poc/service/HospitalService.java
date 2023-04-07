package poc.service;

import poc.model.Hospital;
import poc.repository.HospitalRepository;
import org.springframework.stereotype.Service;
import poc.util.ClosestHospitalWithSpecialityAndAvailableBeds;
import poc.util.SentReservation;

import java.util.List;

@Service
public class HospitalService {
    private HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }
    public List<Hospital> getHospitals() {
        return hospitalRepository.findAll();
    }

    public String getClosestHospitalsWithRightSpecialityAndAvailableBeds(double latitude, double longitude, String specialityName) {

        String hospitalName = ClosestHospitalWithSpecialityAndAvailableBeds.name(latitude, longitude, specialityName);
        SentReservation.ToHospital(hospitalName);

        return hospitalName;
    }
}
