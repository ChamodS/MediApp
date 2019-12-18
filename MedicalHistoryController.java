package com.example.mediapp.MedicalHistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*")
public class MedicalHistoryController {
    @Autowired
    MedicalHistoryService medicalHistoryService;

    @PostMapping("/addNewMedicalRecord")
    public String addNewMedicalRecord(@RequestBody MedicalHistoryDTO newMedicalHistory){
        System.out.println(newMedicalHistory.toString());
        return medicalHistoryService.addNewMedicalHistory(newMedicalHistory);
    }

}
