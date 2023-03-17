package poc.controller;

import poc.model.Speciality;
import poc.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {
    @Autowired
    private SpecialityService specialityService;

    @GetMapping("/all")
    public List<Speciality> getAllspecialities(){
        return specialityService.getSpecialities();
    }

    @PostMapping("/add:{name}")
    public ResponseEntity<Speciality> createSpeciality(@RequestBody Speciality speciality){
        Speciality newSpeciality = specialityService.addSpeciality(speciality);
        return ResponseEntity.ok(newSpeciality);
    }
}
