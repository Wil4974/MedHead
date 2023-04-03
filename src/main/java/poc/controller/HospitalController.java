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
    public ResponseEntity<List<Hospital>> getAllHospitals(){
        return new ResponseEntity<>(hospitalService.getHospitals(), HttpStatus.OK);
    }

    @GetMapping("/{latitude}/{longitude}/{specialityName}")
    public ResponseEntity<String> findClosestHospitalsWithSpecialityAndAvailableBeds(@PathVariable Double latitude, @PathVariable Double longitude, @PathVariable String specialityName){
        if (latitude == null || longitude == null || specialityName == null) {
            return new ResponseEntity<>("Missing parameters", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(hospitalService.getClosestHospitalsWithRightSpecialityAndAvailableBeds(latitude, longitude, specialityName), HttpStatus.OK);
    }
}
