package com.example.mediapp.clinicalEvent;


import java.time.LocalDate;
import java.util.Date;
//import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ClinicalEventRepository extends CrudRepository<ClinicalEvent, Long>{
		
	Iterable<ClinicalEvent> findAll();
	public List<ClinicalEvent> findByDate(LocalDate date);
	@Query(value="select * from clinical_event where date =:weekDate",nativeQuery = true)
	List<ClinicalEvent> getAllByDate(@Param("weekDate")LocalDate weekDate);
}

