package io.badadal.sumanth.controllers;

import io.badadal.sumanth.model.Patient;
import io.badadal.sumanth.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * @author sbadadal
 */

@Slf4j
@RestController
@RequestMapping("/springbootdocker")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patient")
    public ResponseEntity<List<Patient>> findAllPatients() {
        log.info("label= SpringBootDocker Finding All patients");
        List<Patient> patients = patientService.getAllPatients();

        if (patients.isEmpty()) {
            log.error("label= SpringBootDocker No Patients added yet");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<?> findpatientById(@PathVariable long id) {
        log.info("label= SpringBootDocker Fetching Patient With Id {}", id);
        Patient patient = patientService.getPatientById(id);
        if (patient == null) {
            log.error("label= SpringBootDocker patient with id {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PostMapping("/patient")
    public ResponseEntity<?> createPatient(@RequestBody Patient patient, UriComponentsBuilder ucBuilder) {
        log.info("label= SpringBootDocker Creating patient : {}", patient);

        patientService.savePatient(patient);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(
                ucBuilder.path("/springbootdocker/patient/{id}").buildAndExpand(patient.getPatientId()).toUri());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);

    }
}
