package com.spring.planner.servicetest;
import com.spring.planner.entities.Classroom;
import com.spring.planner.repository.ClassroomRepository;
import com.spring.planner.service.ClassroomService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClassroomServiceTest {

    @InjectMocks
    ClassroomService classroomService;

    @Mock
    ClassroomRepository classroomRepository;


    @Test
    /**
     * unit test of findClassroomById() from class ClassroomService
     */
    public void findClassroomByIdTest(){
        Classroom classroom = new Classroom("5 ème B");
        classroom.setId(1L);
        Mockito.when(classroomRepository.findById(classroom.getId())).thenReturn(Optional.of(classroom));
        Classroom found = classroomService.findClassroombyId(classroom.getId());
        assertEquals(classroom,found,"findClassroomByIdTest not passed");
    }

    @Test
    /**
     * unit test of addClassroom() from class ClassroomService
     */
    public void addClassroomTest(){
        Mockito.when(classroomRepository.save(any(Classroom.class))).then(returnsFirstArg());
        Classroom expectedClassroom = new Classroom("5");
        expectedClassroom.setId(1L);
        Classroom found = classroomService.addClassroom(expectedClassroom);
        assertEquals(expectedClassroom,found,"addClassroomTest not passed");
    }

    @Test
    /**
     * unit test of getAllClassroom() from class ClassroomService
     */
    public void getAllClassroomTest(){
        Classroom classroom= new Classroom();
        Classroom classroom1 = new Classroom();
        Iterable<Classroom>classroomIterable= Arrays.asList(classroom,classroom1);
        Mockito.when(classroomRepository.findAll()).thenReturn(classroomIterable);
        List<Classroom>listExpected=classroomService.getAllClassroom();
        assertEquals(StreamSupport.stream(classroomIterable.spliterator(),false).count(),listExpected.size(),"getAllClassroomTest not passed");
    }

    @Test
    /**
     * unit test of deleteClassroomById() from class ClassroomService
     */
    public void deleteClassroomByIdTest() {
        Long idExpected = 3L;
        classroomService.deleteClassroom(idExpected);
        verify(classroomRepository).deleteById(eq(idExpected));
    }
}
