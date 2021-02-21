package com.springboot.rest.crud.demo.controllers;

import com.springboot.rest.crud.demo.entity.Student;
import com.springboot.rest.crud.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    StudentService service;

    //Get all students
    @GetMapping("/")
    public ResponseEntity getStudents(){
        List<Student> res = service.getStudents();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    //Get student by id
    @GetMapping("/{id}")
    public ResponseEntity getStudentById(@PathVariable long id){
        Student res = service.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    //Create Student
    @PostMapping("/")
    public ResponseEntity createStudent(@RequestBody Student student){
        Student res = service.createStudent(student);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
    }

    //Update Student
    @PutMapping("/")
    public ResponseEntity updateStudent(@RequestBody Student student){
        Student res = service.updateStudent(student);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
    }

    //Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable long id){
        try {
            String res = service.deleteStudent(id);
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(e);
        }


    }


}
