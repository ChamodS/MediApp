package com.example.mediapp.Stock;

import com.example.mediapp.Medi.Medicine;
import org.hibernate.validator.internal.constraintvalidators.bv.money.PositiveOrZeroValidatorForMonetaryAmount;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;

class StockDTO {
    Integer availableQTY;
    Date expDate;
    String type;
    Integer strength;
    String unit;
    String genericName;
    String brandName;
    String supplierName;
    Integer reOrderingLevel;
    Integer usedAmount;
    long id;
    long stockID;

    public void setId(long id) {
        this.id = id;
    }

    public long getStockID() {
        return stockID;
    }

    public void setStockID(long stockID) {
        this.stockID = stockID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(Integer usedAmount) {
        this.usedAmount = usedAmount;
    }

    public StockDTO() {
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getAvailableQTY() {
        return availableQTY;
    }

    public void setAvailableQTY(Integer availableQTY) {
        this.availableQTY = availableQTY;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }
}
