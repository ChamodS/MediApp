package com.example.mediapp.MedicalHistory;

import org.springframework.data.repository.CrudRepository;

public interface MedicalHistoryRepo extends CrudRepository<MedicalHistory,Long> {
	//public MedicalHistory findByStudentId(long student_id);

}
