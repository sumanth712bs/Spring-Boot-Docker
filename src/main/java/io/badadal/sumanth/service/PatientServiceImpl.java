package io.badadal.sumanth.service;

import io.badadal.sumanth.model.Patient;
import io.badadal.sumanth.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author sbadadal
 */

@Service("patientService")
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient getPatientById(long patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);
        return patient.get();
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patients::add);
        return patients;
    }

    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void updatePatient(Patient patient) {
        savePatient(patient);
    }

    @Override
    public void deletePatientById(long patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public void deleteAllPatients() {
        patientRepository.deleteAll();
    }
}
