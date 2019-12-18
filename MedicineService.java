package com.example.mediapp.Medi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MedicineService {
    @Autowired
    MedicineRepo medicineRepo;

    //Response response;
    public Response getMedicneByGenericName(Medicine medi) {
        // TODO Auto-generated method stub
        Medicine medicine = medicineRepo.findMedicineByGenericNameAndBrandName(medi.genericName,medi.brandName);
        //System.out.println("a meka wada bn");
        System.out.println(medi.toString());
        if (medicine == null){
            medicineRepo.save(medi);
            return new Response("success", "medicine added sucesessfully", null);
        }
        else
            return new Response("failed", "medicine is allready in list", medicine);

    }
    public Long gedMedicineID(String genericName, String brandName){
        Medicine medicine=medicineRepo.findMedicineByGenericNameAndBrandName(genericName,brandName);
        return medicine.mid;
    }
    public List<String> getGenericNameByBrandName(String brandName){
        Iterable<Medicine> medicineList=medicineRepo.getMedicinesByBrandName(brandName);//Iterable is kind a list
        List<String> genericNames= new ArrayList<>();//null or empty list makes null pointer exceptions
        for (Medicine medicine:medicineList) {
            String genericName=medicine.genericName;
            System.out.println(genericName);
            genericNames.add(genericName);
            System.out.println(genericNames);
        }
        return genericNames;
    }

}
