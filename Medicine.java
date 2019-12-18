package com.example.mediapp.Medi;

import com.example.mediapp.MedicalHistory.MedicalHistory;
import com.example.mediapp.Stock.Stock;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Medicine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    long mid;

    String brandName;
    String genericName;
    String supplierName;
    Integer reOrderingLevel;


    @JsonIgnore
    @OneToMany(mappedBy = "medicine",cascade = CascadeType.ALL)
    List<Stock> stocks;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(
            name = "medicine_taken",
            joinColumns = @JoinColumn(name = "medicine_id"),
            inverseJoinColumns = @JoinColumn(name = "medical_history_id")
    )
    List<MedicalHistory> medicalHistories;

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        mid = mid;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getReOrderingLevel() {
        return reOrderingLevel;
    }

    public void setReOrderingLevel(Integer reOrderingLevel) {
        this.reOrderingLevel = reOrderingLevel;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public List<MedicalHistory> getMedicalHistories() {
        return medicalHistories;
    }

    public void setMedicalHistories(List<MedicalHistory> medicalHistories) {
        this.medicalHistories = medicalHistories;
    }

    @Override
    public String toString() {
        return ("Mid "+mid+"brandName "+brandName+"genericName "+genericName+"supplierName "+supplierName+"reOrderingLevel "+reOrderingLevel);
    }
}
