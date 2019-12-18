package com.example.mediapp.Stock;

import com.example.mediapp.Medi.Medicine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface StockRepo extends CrudRepository<Stock,Long> {
   // availableQTY,expDate,type, strength, unit, genericName, brandName,supplierName, reOrderingLevel

    //here you need to code to find stock (genaricname,unit, c,exp) for update stock

    @Query(value = "select  s from Stock s ")
    List<Stock> getStocks();

    Stock findByMedicineAndExpDateAndType(Medicine med, Date exp, String ty);
    Stock findByStockID(Long stID);

    @Query("select s.medicine from Stock s where s.stockID=:id")
    Medicine getByStockID(@Param("id") Long id);

    List<Stock> findByMedicine(Medicine medicine);

}
