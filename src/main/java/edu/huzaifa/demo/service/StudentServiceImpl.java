package edu.huzaifa.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.huzaifa.demo.entity.StudentEntity;
import edu.huzaifa.demo.model.Student;
import edu.huzaifa.demo.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository repository;
    @Autowired
    ObjectMapper mapper;

    public Student createStudent(Student student){
        StudentEntity studentEntity = mapper.convertValue(student, StudentEntity.class);

        StudentEntity existingStudent = repository.findByFirstNameAndLastName(student.getFirstName(), student.getLastName());
        if (existingStudent != null) {
            log.warn("Student with the same first name and last name already exists in the database. Cannot add the student again.");
            throw new IllegalArgumentException("Student with the same first name and last name already exists.");
        }
        StudentEntity savedStudent = repository.save(studentEntity);

        return mapper.convertValue(savedStudent, Student.class);
    }
}
