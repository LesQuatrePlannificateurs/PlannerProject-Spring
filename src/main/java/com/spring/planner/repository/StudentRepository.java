package com.spring.planner.repository;

import com.spring.planner.entities.Professor;
import com.spring.planner.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository <Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.studentClass.studentClassId=:param")
    Iterable<Student> findAllStudentByStudentClassId(@Param("param")Long id);

    @Query("SELECT s FROM Student s WHERE s.login=:param")
    Student findByLogin(@Param("param")String login);
}
