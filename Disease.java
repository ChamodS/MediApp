package com.example.mediapp.Disease;

import com.example.mediapp.MedicalHistory.MedicalHistory;

import javax.persistence.*;
import java.util.List;

@Entity
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    long disease_id;
    String name;
    @OneToMany(mappedBy = "disease",cascade = CascadeType.ALL)
    List<MedicalHistory> medicalHistories;

    public List<MedicalHistory> getMedicalHistories() {
        return medicalHistories;
    }

    public void setMedicalHistories(List<MedicalHistory> medicalHistories) {
        this.medicalHistories = medicalHistories;
    }

    public long getDisease_id() {
        return disease_id;
    }

    public void setDisease_id(long disease_id) {
        this.disease_id = disease_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
