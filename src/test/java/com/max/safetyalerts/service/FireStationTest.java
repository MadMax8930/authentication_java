package com.max.safetyalerts.service;

import com.max.safetyalerts.model.FireStation;
import com.max.safetyalerts.repository.FireStationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class FireStationTest {

    @InjectMocks
    FireStationServiceImpl fireStationService;
    @Mock
    FireStationRepository fireStationRepository;

    @Test
    public void deleteFireStationByStationNumber() {
        int id = 1;
        List<FireStation> listFire = new ArrayList<>();
        listFire.add(new FireStation("testAddress",id));

        Mockito.when(fireStationRepository.findStationByStation(id)).thenReturn(listFire);
        doNothing().when(fireStationRepository).delete(listFire.get(0));

        fireStationService.deleteFireStationByStationNumber(id);

        Mockito.verify(fireStationRepository, Mockito.times(id)).findStationByStation(id);
        Mockito.verify(fireStationRepository, Mockito.times(id)).delete(Mockito.any());
    }
}
