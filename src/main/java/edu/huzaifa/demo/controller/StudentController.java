package edu.huzaifa.demo.controller;


import edu.huzaifa.demo.model.Student;
import edu.huzaifa.demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create-student")
    Student createStudent(@RequestBody Student student){
        log.info(student.toString());
        return studentService.createStudent(student);
    }
}
