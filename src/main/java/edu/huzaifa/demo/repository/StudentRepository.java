package edu.huzaifa.demo.repository;

import edu.huzaifa.demo.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity,Integer> {
    public StudentEntity findByFirstNameAndLastName(String fName, String lName);
}
