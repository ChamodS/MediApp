package com.example.mediapp.Disease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DiseaseController {

    @Autowired
    DiseaseRepo diseaseRepo;

    @PostMapping("/getAllDiseaseNames")
    public List<String> getAllDiseaseNames() {
        return diseaseRepo.getAllDiseaseNames();
    }
}
