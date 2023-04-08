package poc.controller;

import org.springframework.http.HttpStatus;
import poc.apiError.BadRequestException;
import poc.apiError.ErrorMessage;
import poc.apiError.NotFoundException;
import poc.model.Speciality;
import poc.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleBadRequestException(BadRequestException ex) {
        ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleBadRequestException(NotFoundException ex) {
        ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InternalError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleBadRequestException(InternalError ex) {
        ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Autowired
    private SpecialityService specialityService;

    @GetMapping("/all")
    public ResponseEntity<List<Speciality>> getAllspecialities(){
        return new ResponseEntity<List<Speciality>>(specialityService.getSpecialities(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Speciality> createSpeciality(@RequestBody Speciality speciality){
        Speciality newSpeciality = specialityService.addSpeciality(speciality);
        return new ResponseEntity<Speciality>(newSpeciality, HttpStatus.OK);
    }
}
