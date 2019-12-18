package com.example.mediapp.MedicalHistory;

import com.example.mediapp.Disease.Disease;
import com.example.mediapp.Medi.Medicine;
import com.example.mediapp.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    long medical_history_id;
    String occurred_date;
    String special_notes;

    public String getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(String occurredAt) {
        this.occurredAt = occurredAt;
    }

    String occurredAt;//home, school/ before enter to the school

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(nullable = false,name = "student_id")
    User student;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(nullable = false,name = "disease_id")
    Disease disease;

    @JsonIgnore
    @ManyToMany(mappedBy = "medicalHistories",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    List<Medicine> medicines;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    @JoinColumn(nullable = false,name ="updated_by_uid")
    User user;

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public long getMedical_history_id() {
        return medical_history_id;
    }

    public void setMedical_history_id(long medical_history_id) {
        this.medical_history_id = medical_history_id;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public String getOccurred_date() {
        return occurred_date;
    }

    public void setOccurred_date(String occurred_date) {
        this.occurred_date = occurred_date;
    }

    public String getSpecial_notes() {
        return special_notes;
    }

    public void setSpecial_notes(String special_notes) {
        this.special_notes = special_notes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
