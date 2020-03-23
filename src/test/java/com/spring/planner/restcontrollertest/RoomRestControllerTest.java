//package com.spring.planner.restcontrollertest;
//
//
//import com.spring.planner.entities.Classroom;
//import com.spring.planner.entities.Professor;
//import com.spring.planner.entities.Unavailability;
//import com.spring.planner.restcontroller.RoomRestController;
//import com.spring.planner.service.ClassroomService;
//import com.spring.planner.service.UnavailabilityService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.StreamSupport;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class RoomRestControllerTest {
//
//    @InjectMocks
//    RoomRestController roomRestController;
//
//    @Mock
//    ClassroomService classroomService;
//
//    @Mock
//    UnavailabilityService unavailabilityService;
//
//    @Test
//    /**
//     * unit test of addClassroom() from class RoomRestController
//     */
//    public void addClassroomTest(){
//        Classroom classroom = new Classroom("5ème");
//        when(classroomService.addClassroom(any(Classroom.class))).thenReturn(classroom);
//        Classroom result = roomRestController.addClassroom(classroom);
//        assertEquals(result,classroom,"addClassroomTest RestController not passed");
//    }
//
//    @Test
//    /**
//     * unit test of getAllClassroom() from class RoomRestController
//     */
//    public void getAllClassroomTest(){
//        Classroom classroom= new Classroom();
//        Classroom classroom1 = new Classroom();
//        List<Classroom>classroomList= Arrays.asList(classroom,classroom1);
//        Mockito.when(classroomService.getAllClassroom()).thenReturn(classroomList);
//        List<Classroom> listExpected=roomRestController.getAllClassrooms();
//        assertEquals(classroomList.size(),listExpected.size(),"getAllClassroomTest not passed");
//    }
//
//    @Test
//    /**
//     * unit test of deleteClassroom() from class RoomRestController
//     */
//    public void deleteClassroomTest() {
//        Long idExpected = 3L;
//        roomRestController.deleteClassroom(idExpected);
//        verify(classroomService).deleteClassroom(eq(idExpected));
//    }
//
//    @Test
//    /**
//     * unit test of findClassroomById() from class RoomRestController
//     */
//    public void findClassroomByIdTest(){
//        Classroom classroom = new Classroom("4 ème A");
//        classroom.setId(2L);
//        Mockito.when(classroomService.findClassroombyId(classroom.getId())).thenReturn(classroom);
//        Classroom found = roomRestController.findClassroomById(classroom.getId());
//        assertEquals(classroom,found,"findClassroomByIdTest not passed");
//    }
//
//    @Test
//    /**
//     * unit test of getPlanningClassroom() from class RoomRestController
//     */
//    public void getPlanningClassroomTest(){
//        Classroom classroom = new Classroom("6ème");
//        classroom.setId(1L);
//        Classroom classroom2 = new Classroom("5ème");
//        classroom2.setId(2L);
//        Professor professor = new Professor("login","psw","firstname","lastname");
//        professor.setProfessorId(1L);
//        Unavailability unavailability = new Unavailability("name indispo1","start 1","end 1", professor, classroom,2L);
//        Unavailability unavailability1 = new Unavailability("name indispo2","start 2","end 2",professor,classroom2,2L);
//        Unavailability unavailability2 = new Unavailability("name indispo3","start 3","end 3",professor,classroom,2L);
//        List<Unavailability>unavailabilities=Arrays.asList(unavailability,unavailability2);
//        Mockito.when(unavailabilityService.findUnavailibilityByClassroomId(unavailability.getClassroom().getId())).thenReturn(unavailabilities);
//        assertEquals(roomRestController.getPlanningClassroom(unavailability.getClassroom().getId()).size(),2L,"getPlanningClassroomTest RestController not passed");
//    }
//
//}
