package com.example.mediapp.Medi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MedicineRepo extends CrudRepository< Medicine, Long> {

    Medicine findMedicineByGenericNameAndBrandName(String genericName, String brandName );

    @Query("select distinct m.brandName from Medicine m ")
    List<String> getAllBrandNames();

    List<Medicine> getAllByMidIn(List<Long> mid);
    Iterable<Medicine > getMedicinesByBrandName(String brandName);
    Medicine getMedicineByMid(Long mid);
    //@Query("select distinct m.brandName from  Medicine m")
    //List<String> getByU
    @Query("select distinct m.genericName from Medicine m ")
    List<String> getAllGenericNames();
    List<Medicine> getMedicinesByGenericName(String genericName);

}
