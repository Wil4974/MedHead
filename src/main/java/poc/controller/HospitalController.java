package poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poc.apiError.BadRequestException;
import poc.apiError.ErrorMessage;
import poc.model.Hospital;
import poc.service.HospitalService;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorMessage> handleBadRequestException(BadRequestException ex) {
        ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
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
