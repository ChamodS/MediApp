package com.example.mediapp.Medi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*")
public class MedicineController {

    @Autowired
    MedicineService medicineService;
    @Autowired
    MedicineRepo medicineRepo;

    @PostMapping("/addMedicine")
    public Response addMedicine(@RequestBody Medicine medicine ){
        return medicineService.getMedicneByGenericName(medicine);
    }
    @PostMapping("/getMedicineID")
    public long getMedicineID(@RequestBody MedicineNames medicineNames ){

        return medicineService.gedMedicineID(medicineNames.genericName,medicineNames.brandName);
    }
    @PostMapping("/getGenericNameByBrandName")
    public List<String> getGenericNameByBrandName(@RequestBody Medicine medicine){
        System.out.println(medicine.brandName);
        return medicineService.getGenericNameByBrandName(medicine.brandName);
    }
    @PostMapping("/getAllGenericNames")
    public List<String> getAllGenericNames() {
        return medicineRepo.getAllGenericNames();
    }

}
class MedicineNames{
    String genericName;
    String brandName;

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
