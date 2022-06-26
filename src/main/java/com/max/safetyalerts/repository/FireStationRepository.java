package com.max.safetyalerts.repository;

import com.max.safetyalerts.model.FireStation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface FireStationRepository extends CrudRepository<FireStation,Integer> {
    List<FireStation> findStationByAddress(String address);
    @Query(value ="SELECT id,address,station FROM fire_station WHERE address=:addressparam", nativeQuery = true)
    FireStation findStationByAddressForFireStation(@Param("addressparam") String address);
    List<FireStation> findStationByStation(int Number);

}
