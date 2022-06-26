package com.max.safetyalerts.repository;

import com.max.safetyalerts.model.MedicalRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface MedicalRecordRepository extends CrudRepository<MedicalRecord,Integer> {

    MedicalRecord findFirstMedicalRecordByPersonId(int personId);
}
