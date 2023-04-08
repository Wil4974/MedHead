package poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poc.apiError.BadRequestException;
import poc.apiError.ErrorMessage;
import poc.apiError.NotFoundException;
import poc.model.Hospital;
import poc.service.HospitalService;
import poc.util.DatabaseUtils;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    public String hospitalName;

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity handleBadRequestException(BadRequestException ex) {
        ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity handleBadRequestException(NotFoundException notFoundException) {
        return new ResponseEntity<>("La page demandées est introuvable.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InternalError.class)
    public ResponseEntity<ErrorMessage> handleBadRequestException(InternalError ex) {
        ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
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
            return new ResponseEntity<>("Paramètres manquants", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(hospitalService.getClosestHospitalsWithRightSpecialityAndAvailableBeds(latitude, longitude, specialityName), HttpStatus.OK);
    }

    @PostMapping("/reservation/{name}")
    public ResponseEntity<String> sentReservation(@PathVariable String name) {

        hospitalName = name;

        if (hospitalName == null) {
            return new ResponseEntity<>("Nom de l'hôpital manquant", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(DatabaseUtils.AddReservation(hospitalName), HttpStatus.OK);
    }
}
