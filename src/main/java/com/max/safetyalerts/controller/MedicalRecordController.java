package com.max.safetyalerts.controller;

import com.max.safetyalerts.model.MedicalRecord;
import com.max.safetyalerts.repository.MedicalRecordRepository;
import com.max.safetyalerts.service.MedicalRecordServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MedicalRecordController {

    /**
     * Logger
     */
    private static final Logger logger = LogManager.getLogger("PersonServiceImpl");

    private MedicalRecordServiceImpl medicalRecordServiceImpl;

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordController(MedicalRecordServiceImpl medicalRecordServiceImpl) {
        this.medicalRecordServiceImpl = medicalRecordServiceImpl;
    }

    //liste de toutes les medical records
    @GetMapping("/listmedicalrecords")
    public Iterable<MedicalRecord> list() {
        return medicalRecordServiceImpl.listAllMedicalRecords();
    }

    // add a medical record
    @PostMapping("/medicalrecord")
    public void addMedicalRecord(@RequestBody MedicalRecord medicalRecordDetails,@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        medicalRecordServiceImpl.save(firstName,lastName,medicalRecordDetails);
    }

    //delete a medical record
    @DeleteMapping("/medicalrecord")
    public void removeMedicalRecord(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        medicalRecordServiceImpl.deleteMedicalRecord(firstName, lastName);
        logger.info("Remove medical records succeeded");
    }

    //update a medical record
    @PutMapping("/medicalRecord")
    public void updateMedicalRecord(@RequestBody MedicalRecord medicalRecordDetails, @RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        medicalRecordServiceImpl.updateMedicalRecord(firstName,lastName,medicalRecordDetails);
    }

}
