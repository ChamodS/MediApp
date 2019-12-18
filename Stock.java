package com.example.mediapp.Stock;

import com.example.mediapp.Medi.Medicine;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Stock implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    long stockID;

    Integer availableQTY;
    Date expDate;
    String type;
    Integer strength;
    String unit;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(nullable = false)
    @Fetch(FetchMode.JOIN)
    Medicine medicine;


    public long getStockID() {
        return stockID;
    }

    public Integer getAvailableQTY() {
        return availableQTY;
    }

    public Date getExpDate() {
        return expDate;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public String getType() {
        return type;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public String getUnit() {
        return unit;
    }

    public void setStockID(long stockID) {
        this.stockID = stockID;
    }

    public void setAvailableQTY(Integer availableQTY) {
        this.availableQTY = availableQTY;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
