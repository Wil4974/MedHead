package poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import poc.model.Speciality;
import poc.repository.SpecialityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityService {
    private SpecialityRepository specialityRepository;

    public SpecialityService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }
    public List<Speciality> getSpecialities(){
        return specialityRepository.findAll();
    }

    public Speciality addSpeciality(Speciality speciality) {
        return specialityRepository.save(speciality);
    }
}