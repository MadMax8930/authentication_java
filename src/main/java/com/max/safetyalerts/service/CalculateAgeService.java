package com.max.safetyalerts.service;

import com.max.safetyalerts.model.MedicalRecord;

import java.time.LocalDate;

public interface CalculateAgeService {
    public int calculateAge(LocalDate date);
    public boolean isChild(int age);
    public boolean isChild(MedicalRecord medicalRecord);
    public boolean isAdult(MedicalRecord medicalRecord);
    public boolean isAdult(int age);

}
