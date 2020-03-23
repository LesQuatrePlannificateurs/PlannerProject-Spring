//package com.spring.planner.restcontrollertest;
//
//import com.spring.planner.entities.Classroom;
//import com.spring.planner.entities.Professor;
//import com.spring.planner.entities.Unavailability;
//import com.spring.planner.restcontroller.UnavailabilityRestController;
//import com.spring.planner.service.UnavailabilityService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.AdditionalAnswers.returnsFirstArg;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)
//public class UnavailabilityRestControllerTest {
//
//    @InjectMocks
//    UnavailabilityRestController unavailabilityRestController;
//
//    @Mock
//    UnavailabilityService unavailabilityService;
//
//    @Test
//    /**
//     * unit test of addUnavailability() from class UnavailabilityRestController
//     */
//    public void addUnavailabilityTest(){
//        Mockito.when(unavailabilityService.addUnavailability(any(Unavailability.class))).then(returnsFirstArg());
//        Unavailability unavailability = new Unavailability();
//        Unavailability found = unavailabilityRestController.addUnavailability(unavailability);
//        assertEquals(found,unavailability,"addUnaivailabilityTest not passed");
//    }
//
//    @Test
//    /**
//     * unit test of deleteUnavailabilityById() from class UnavailabilityRestController
//     */
//    public void deleteUnavailabilityByIdTest(){
//        Long idExpected = 3L;
//        unavailabilityRestController.deleteUnavailabilityById(idExpected);
//        verify(unavailabilityService).deleteUnavailabilityById(eq(idExpected));
//    }
//
//    @Test
//    /**
//     * unit test of updateUnavailability() from class UnavailabilityRestController
//     */
//    public void updateUnavailabilityTest(){
//        Professor professor = new Professor("1","1","1","1");
//        professor.setProfessorId(1L);
//        Professor professor2 = new Professor("2","2","2","2");
//        professor2.setProfessorId(2L);
//        Classroom classroom = new Classroom("6ème");
//        classroom.setId(1L);
//        Classroom classroom2 = new Classroom("5ème");
//        classroom2.setId(2L);
//        Unavailability unavailabilityToUpdate= new Unavailability("name indispo","start","end",professor,classroom,1L,1L);
//        unavailabilityToUpdate.setId(1L);
//        Unavailability expected = new Unavailability("name indispo2","start2","end2",professor2,classroom2,2L,2L);
//        expected.setId(1L);
//        Mockito.when(unavailabilityService.updateUnavailability(expected,unavailabilityToUpdate.getId())).thenReturn(expected);
//        Unavailability unavailabilityUpdated = unavailabilityRestController.updateUnavailability(expected, unavailabilityToUpdate.getId());
//        assertEquals(unavailabilityUpdated.getId(),expected.getId());
//        assertEquals(unavailabilityUpdated.getClassroom().getId(),expected.getClassroom().getId());
//        assertEquals(unavailabilityUpdated.getProfessor().getProfessorId(),expected.getProfessor().getProfessorId());
//        assertEquals(unavailabilityUpdated.getEquipmentId(),expected.getEquipmentId());
//        assertEquals(unavailabilityUpdated.getStart(),expected.getStart());
//        assertEquals(unavailabilityUpdated.getNameIndispo(),expected.getNameIndispo());
//        assertEquals(unavailabilityUpdated.getStart(),expected.getStart());
//        assertEquals(unavailabilityUpdated.getEnd(),expected.getEnd(),"updateUnavailabilityTest RestController not passed");
//    }
//}
