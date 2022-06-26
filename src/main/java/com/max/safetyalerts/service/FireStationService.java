package com.max.safetyalerts.service;

import com.max.safetyalerts.model.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FireStationService {

    public Iterable<com.max.safetyalerts.model.FireStation> listAllFireStations();

    public com.max.safetyalerts.model.FireStation save(com.max.safetyalerts.model.FireStation fireStation);

    public Iterable<com.max.safetyalerts.model.FireStation> save(List<com.max.safetyalerts.model.FireStation> fireStations);

    public FireStationCoverage getFireStationCoverage(int station);

    public List<PhoneCoverage> getPhoneNumbersByStation(int station);

    public List<FireStationsFlood> getCoverageFireStationForSeveralFireStations(String stations);

    public void deleteFireStationByStationNumber(int station);

    public ResponseEntity deleteFireStationByAddress(String address);

    public ResponseEntity updateFireStation(String station, FireStation fireStationDetails);




}