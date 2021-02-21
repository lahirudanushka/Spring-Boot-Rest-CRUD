package com.springboot.rest.crud.demo.repository;

import com.springboot.rest.crud.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
