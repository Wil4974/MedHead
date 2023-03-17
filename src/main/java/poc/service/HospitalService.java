package poc.service;

import poc.model.Hospital;
import poc.repository.HospitalRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    private HospitalRepository hospitalRepository;

    public Hospital addHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    public Iterable<Hospital> getHospitals() {
        return hospitalRepository.findAll();
    }
}
