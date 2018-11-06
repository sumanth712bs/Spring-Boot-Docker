package io.badadal.sumanth.service;

import io.badadal.sumanth.model.Patient;

import java.util.List;

/**
 * @author sbadadal
 */
public interface PatientService {

    Patient getPatientById(long patientId);

    List<Patient> getAllPatients();

    void savePatient(Patient patient);

    void updatePatient(Patient patient);

    void deletePatientById(long patientId);

    void deleteAllPatients();


}
