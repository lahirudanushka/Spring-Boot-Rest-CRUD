package com.springboot.rest.crud.demo.service;

import com.springboot.rest.crud.demo.entity.Student;

import java.util.List;

public interface StudentService {
    //Create
    public Student createStudent(Student student);
    //Read
    public List<Student> getStudents();
    public Student getStudentById(long id);
    //Update
    public Student updateStudent(Student student);
    //Delete
    public String deleteStudent(long id);
}
