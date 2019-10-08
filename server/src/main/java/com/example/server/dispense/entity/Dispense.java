package com.example.server.dispense.entity;

import com.example.server.pharmacist.entity.Pharmacist;
import com.example.server.prescription.entity.Patient;
import com.example.server.prescription.entity.Prescription;
import lombok.*;

import java.util.Date;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Dispense")
public class Dispense {
    @Id
    @SequenceGenerator(name="Dispense_seq",sequenceName="Dispense_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Dispense_seq")
    @Column(name = "Dispense_ID", unique = true, nullable = true)

    private @NonNull Long dispenseid;
    private @NonNull String named;
    private @NonNull Date paydate;
    private @NonNull String dosing;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Patient.class)
    @JoinColumn(name = "Patient_ID", insertable = true)
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Pharmacist.class)
    @JoinColumn(name = "Pharmacist_ID", insertable = true)
    private Pharmacist pharmacist;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Prescription.class)
    @JoinColumn(name = "Prescription_ID", insertable = true)
    private Prescription prescription;

    public Long getDispenseid() {
        return dispenseid;
    }

    public void setDispenseid(Long dispenseid) {
        this.dispenseid = dispenseid;
    }

    public String getNamed() {
        return named;
    }

    public void setNamed(String named) {
        this.named = named;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public String getDosing() {
        return dosing;
    }

    public void setDosing(String dosing) {
        this.dosing = dosing;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }


}