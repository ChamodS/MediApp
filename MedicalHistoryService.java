package com.example.mediapp.MedicalHistory;

import com.example.mediapp.Disease.Disease;
import com.example.mediapp.Disease.DiseaseRepo;
import com.example.mediapp.Medi.Medicine;
import com.example.mediapp.Medi.MedicineRepo;
import com.example.mediapp.user.User;
import com.example.mediapp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalHistoryService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DiseaseRepo diseaseRepo;
    @Autowired
    MedicineRepo medicineRepo;
    @Autowired
    MedicalHistoryRepo medicalHistoryRepo;



    public String addNewMedicalHistory(MedicalHistoryDTO newRecord ){
    	System.out.println("hi");
        List<Medicine> medicineList = new ArrayList<>();
        newRecord.toString();
        MedicalHistory medicalHistory=new MedicalHistory();
        System.out.println("hi2");
        if(newRecord.medicineIds!=null) {
            for(MedicineId medicineId:newRecord.medicineIds){
                System.out.println("hi3");
                Medicine medicine = new Medicine();
                medicineRepo.getMedicineByMid(medicineId.mid);
                medicineList.add(medicine);
                System.out.println("hi4");
            }
        }
        User updatedBy=userRepository.findByUid(newRecord.updatedByUid);
        medicalHistory.user=updatedBy;

		
        medicalHistory.student= userRepository.findByIndexNo(newRecord.studentIndexNumber);
        System.out.println(medicalHistory.student);
        medicalHistory.disease=diseaseRepo.findDiseaseByName(newRecord.diseaseName);
        if (medicalHistory.disease==null){
            Disease disease=new Disease();
            disease.setName(newRecord.diseaseName);
                diseaseRepo.save(disease);
        }
		
        System.out.println(medicalHistory.disease);
        medicalHistory.occurred_date=newRecord.occurredDate;
        medicalHistory.occurredAt=newRecord.occurredAt;
        medicalHistory.medicines=medicineList;
        medicalHistory.special_notes=newRecord.specialNotes;

        medicalHistory.toString();
        System.out.println("ok it works ");
        medicalHistoryRepo.save(medicalHistory);
        return "Wade Hari oi";
    }
}
