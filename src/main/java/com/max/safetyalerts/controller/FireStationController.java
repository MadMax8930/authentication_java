package com.max.safetyalerts.controller;

import com.max.safetyalerts.model.*;
import com.max.safetyalerts.repository.FireStationRepository;
import com.max.safetyalerts.service.FireStationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FireStationController {

    @Autowired
    private FireStationServiceImpl fireStationServiceImpl;

    @Autowired
    private FireStationRepository fireStationRepository;

    private FireStationController() {

    }

    /**
     * Logger
     */
    private static final Logger logger = LogManager.getLogger("PersonServiceImpl");


    @GetMapping("/listfirestations")
    public Iterable<FireStation> list() {
        return fireStationServiceImpl.listAllFireStations();
    }

    @GetMapping("/firestation")
    public FireStationCoverage listOfFireStationCoverage(@RequestParam(required = false) int stationNumber) {
        return fireStationServiceImpl.getFireStationCoverage(stationNumber);
    }

    @GetMapping("/phone")
    public List<PhoneCoverage> listofPhones(@RequestParam(required = false) int stationNumber)  {
        return fireStationServiceImpl.getPhoneNumbersByStation(stationNumber);
    }

    @GetMapping("/flood/stations")
    public List<FireStationsFlood> listofFlood(@RequestParam(required = false) String stations)  {
        return fireStationServiceImpl.getCoverageFireStationForSeveralFireStations(stations);
    }

    // add a fire station
    @PostMapping("/firestation")
    public void addFireStation(@RequestBody FireStation fireStation) {
        fireStationRepository.save(fireStation);
    }

    //delete a fire station by station number
    @DeleteMapping("/firestationnumber")
    public void removeFireStationByStationNumber(@RequestParam(required = false) int station) {
        fireStationServiceImpl.deleteFireStationByStationNumber(station);
        logger.info("Remove fire station succeeded");
    }

    //delete a fire station by address
    @DeleteMapping("/firestation")
    public void removeFireStationByAddress(@RequestParam(required = false) String address) {
        fireStationServiceImpl.deleteFireStationByAddress(address);
        logger.info("Remove fire station succeeded");
    }

    // update à fire station by address
    @PutMapping("/firestation")
    public void updateFireStation(@RequestBody FireStation fireStationDetails, @RequestParam(required = false) String address) {
        fireStationServiceImpl.updateFireStation(address,fireStationDetails);
    }
}
