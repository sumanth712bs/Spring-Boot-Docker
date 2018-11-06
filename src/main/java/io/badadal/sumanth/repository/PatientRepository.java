package io.badadal.sumanth.repository;

import io.badadal.sumanth.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author sbadadal
 */
@RepositoryRestResource(collectionResourceRel = "patient", path = "patient")
public interface PatientRepository extends CrudRepository<Patient, Long> {
}
