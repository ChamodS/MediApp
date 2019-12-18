package com.example.mediapp.Stock;

import com.example.mediapp.DateToLocalDate;
import com.example.mediapp.Medi.Medicine;
import com.example.mediapp.Medi.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StockService {
    @Autowired
    StockRepo stockRepo;
    @Autowired
    MedicineRepo medicineRepo;

    DateToLocalDate dateToLocalData=new DateToLocalDate();

    public Response addNewStock(Stock stock){

        stockRepo.save(stock);
        return new Response("success","New Stock Details Added Successfully",null);
    }

    public List<StockDTO> getAllStockDetails(){
        List<StockDTO> stockDTOList=new ArrayList<>();
        List<Stock> stockList=stockRepo.getStocks();

        for(Stock stock:stockList){
            StockDTO stockDTO=new StockDTO();
            Long mid=stock.medicine.getMid();
            System.out.println(mid);
            Medicine medicine=medicineRepo.getMedicineByMid(mid);
            System.out.println(medicine.getMid());
            System.out.println(medicine.getBrandName());
            stockDTO.availableQTY=(stock.availableQTY);
            stockDTO.expDate=(stock.expDate);
            stockDTO.strength=(stock.strength);
            stockDTO.unit=(stock.unit);
            stockDTO.type=(stock.type);
            stockDTO.supplierName=(medicine.getSupplierName());
            stockDTO.brandName=(medicine.getBrandName());
            stockDTO.genericName=(medicine.getGenericName());
            stockDTO.reOrderingLevel=(medicine.getReOrderingLevel());
            stockDTOList.add(stockDTO);


        }
        return stockDTOList;
    }

    public Response updateStock(StockDTO stockDTO){

        /*System.out.println("Check Point 01");
        Medicine medicine= medicineRepo.findMedicineByGenericNameAndBrandName(stockDTO.getGenericName(),stockDTO.getBrandName());
        System.out.println(medicine);
        System.out.println("Check Point 02");
        Stock stock= stockRepo.findByMedicineAndExpDateAndType(medicine,stockDTO.getExpDate(),stockDTO.getUnit());
        System.out.println("Check Point 03");
        System.out.println(stock);
        stock.setAvailableQTY(stock.getAvailableQTY()-stockDTO.getUsedAmount());
        System.out.println("Check Point 04");*/
        Stock stock= stockRepo.findByStockID(stockDTO.stockID);
        Medicine medicine=stockRepo.getByStockID(stockDTO.stockID);
        stock.setAvailableQTY(stock.getAvailableQTY()-stockDTO.getUsedAmount());
        System.out.println("Check Point 04");
        System.out.println(stock.toString());
        try{
            stockRepo.save(stock);
            if (stock.availableQTY<medicine.getReOrderingLevel()){
                return new Response("success","Stock reached to re ordering level!",null);
            }

            return new Response("success","New Stock Details Updated",null);
        }
        catch (Exception e){
            System.out.println(e);
            return new Response("Failed","New Stock Details does not Updated, server  error",null);
        }
    }

    public List<Stock> getStocks(StockDTO stockDTO) {

        Medicine medicine=medicineRepo.findMedicineByGenericNameAndBrandName(stockDTO.genericName,stockDTO.brandName);
        return stockRepo.findByMedicine(medicine);
    }
}
