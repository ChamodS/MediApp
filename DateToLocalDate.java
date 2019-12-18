package com.example.mediapp;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateToLocalDate {
    public LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
