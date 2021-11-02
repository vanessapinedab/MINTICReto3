package com.usa.ciclo3.reto3.web;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo3.reto3.model.Doctor;
import com.usa.ciclo3.reto3.services.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Doctor")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class DoctorControllerWeb {

    @Autowired
    private DoctorServices doctorServices;

    @GetMapping("/all")
    public List<Doctor> getDoctor(){

        return doctorServices.getAll();
    }

    @GetMapping("/{idDoctor}")
    public Optional<Doctor> getDoctor (@PathVariable("id") int id) {

        return doctorServices.getDoctor(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save(@RequestBody Doctor doctor) {

        return doctorServices.save(doctor);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)

    public Doctor update(@RequestBody Doctor doctor) {

        return doctorServices.update(doctor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return doctorServices.deleteDoctor(id);
    }


}
