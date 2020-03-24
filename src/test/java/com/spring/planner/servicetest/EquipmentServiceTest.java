package com.spring.planner.servicetest;

import com.spring.planner.entities.Director;
import com.spring.planner.entities.Equipment;
import com.spring.planner.repository.DirectorRepository;
import com.spring.planner.repository.EquipmentRepository;
import com.spring.planner.service.DirectorService;
import com.spring.planner.service.EquipmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EquipmentServiceTest {

    @InjectMocks
    EquipmentService equipmentService;

    @Mock
    EquipmentRepository equipmentRepository;

    @Test
    public void addEquipmentTest(){
        Mockito.when(equipmentRepository.save(any(Equipment.class))).then(returnsFirstArg());
        Equipment expectedEquipment = new Equipment("name");
        expectedEquipment.setEquipmentId(1L);
        Equipment found = equipmentService.addEquipment(expectedEquipment);
        assertEquals(expectedEquipment,found,"addEquipmentTest not passed");
    }

    @Test
    public void deleteEquipmentByIdTest(){
        Long idExpected = 3L;
        equipmentService.deleteEquipmentById(idExpected);
        verify(equipmentRepository).deleteById(eq(idExpected));
    }

    @Test
    public void findEquipmentByIdTest(){
        Equipment equipment= new Equipment();
        equipment.setEquipmentId(1L);
        Mockito.when(equipmentRepository.findById(equipment.getEquipmentId())).thenReturn(Optional.of(equipment));
        Equipment found = equipmentService.findEquipmentById(equipment.getEquipmentId());
        assertEquals(equipment,found,"findDirectorByIdTest not passed");
    }

}
