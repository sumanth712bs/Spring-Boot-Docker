package io.badadal.sumanth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author sbadadal
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue
    @Column(name = "PATIENT_ID")
    private long patientId;

    @Column(name = "PATIENT_NAME")
    private String patientName;

    @Column(name = "CITY")
    private String city;

    public Patient(String patientName, String city) {
        this.patientName = patientName;
        this.city = city;
    }
}
