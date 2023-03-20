package poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poc.model.Hospital;
import poc.service.HospitalService;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/all")
    public List<Hospital> getAllHospitals(){
        return hospitalService.getHospitals();
    }

    @GetMapping("/{latitude}/{longitude}/{specialityName}")
    public String findClosestHospitalsWithSpecialityAndAvailableBeds(@PathVariable double latitude, @PathVariable double longitude, @PathVariable String specialityName){
        return hospitalService.getClosestHospitalsWithRightSpecialityAndAvailableBeds(latitude, longitude, specialityName);
    }
}
