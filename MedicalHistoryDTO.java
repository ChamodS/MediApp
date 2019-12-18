package com.example.mediapp.MedicalHistory;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class MedicalHistoryDTO {
    String studentIndexNumber;
    String diseaseName;
    String occurredDate;
    List<MedicineId> medicineIds;
    String specialNotes;
    Long updatedByUid;
    String occurredAt;

    @Override
    public String toString() {

        return (" student_index_number: " +studentIndexNumber+
        " /n disease_name: " +diseaseName+
        "/n  occurred_date: "+occurredDate+
        "/n  medicine_ids: "+medicineIds+
        " /n special_notes: "+specialNotes+
        "/n  updated_by_uid: "+updatedByUid+
        "/n  occurredAt: "+occurredAt);
    }

    public String getOccurredAt() {
		return occurredAt;
	}

	public void setOccurredAt(String occurredAt) {
		this.occurredAt = occurredAt;
	}

	public String getStudentIndexNumber() {
        return studentIndexNumber;
    }

    public void setStudentIndexNumber(String studentIndexNumber) {
        this.studentIndexNumber = studentIndexNumber;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getOccurredDate() {
        return occurredDate;
    }

    public void setOccurredDate(String occurredDate) {
        this.occurredDate = occurredDate;
    }

    public List<MedicineId> getMedicineIds() {
        return medicineIds;
    }

    public void setMedicineIds(List<MedicineId> medicineIds) {
        this.medicineIds = medicineIds;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    public Long getUpdatedByUid() {
        return updatedByUid;
    }

    public void setUpdatedByUid(Long updatedByUid) {
        this.updatedByUid = updatedByUid;
    }
}
class MedicineId{
    Long mid;

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }
}
