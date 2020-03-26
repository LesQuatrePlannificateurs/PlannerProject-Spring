package com.spring.planner.restcontrollertest;

import com.spring.planner.entities.*;
import com.spring.planner.entities.Equipment;
import com.spring.planner.restcontroller.EquipmentRestController;
import com.spring.planner.service.EquipmentService;
import com.spring.planner.service.UnavailabilityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EquipmentRestControllerTest {

    @InjectMocks
    EquipmentRestController equipmentRestController;

    @Mock
    EquipmentService equipmentService;

    @Mock
    UnavailabilityService unavailabilityService;

    @Test
    public void addEquipmentTest(){
        Equipment equipment = new Equipment("name");
        when(equipmentService.addEquipment(any(Equipment.class))).thenReturn(equipment);
        Equipment result = equipmentRestController.addEquipment(equipment);
        assertEquals(result,equipment,"addEquipmentTest RestController not passed");
    }

    @Test
    public void deleteEquipmentByIdTest(){
        Long idExpected = 3L;
        equipmentRestController.deleteEquipmentById(idExpected);
        verify(equipmentService).deleteEquipmentById(eq(idExpected));
    }

    @Test
    public void findEquipmentByIdTest(){
        Equipment equipment= new Equipment();
        equipment.setEquipmentId(1L);
        Mockito.when(equipmentService.findEquipmentById(equipment.getEquipmentId())).thenReturn(equipment);
        Equipment found = equipmentRestController.findEquipmentById(equipment.getEquipmentId());
        assertEquals(equipment,found,"findEquipmentByIdTest not passed");
    }

    @Test
    public void findUnavailabilitiesByEquipmentId(){
        Equipment equipment = new Equipment("6ème");
        equipment.setEquipmentId(1L);
        Equipment equipment2 = new Equipment("5ème");
        equipment2.setEquipmentId(2L);
        Professor professor = new Professor("login","psw","firstname","lastname");
        professor.setProfessorId(1L);
        Classroom classroom = new Classroom();
        equipment.setEquipmentId(1L);
        StudentClass studentClass = new StudentClass();
        studentClass.setStudentClassId(1L);
        Unavailability unavailability = new Unavailability("name indispo1","start 1","end 1", professor, classroom,studentClass,equipment);
        Unavailability unavailability1 = new Unavailability("name indispo2","start 2","end 2",professor,classroom,studentClass,equipment2);
        Unavailability unavailability2 = new Unavailability("name indispo3","start 3","end 3",professor,classroom,studentClass,equipment);
        List<Unavailability> unavailabilities= Arrays.asList(unavailability,unavailability2);
        Mockito.when(unavailabilityService.findUnavailabilityByEquipmentId(unavailability.getEquipment().getEquipmentId())).thenReturn(unavailabilities);
        assertEquals(equipmentRestController.findUnavailabilitiesByEquipmentId(unavailability.getEquipment().getEquipmentId()).size(),2L,"getPlanningEquipmentTest RestController not passed");
    }
}
