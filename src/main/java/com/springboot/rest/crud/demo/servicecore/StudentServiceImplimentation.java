package com.springboot.rest.crud.demo.servicecore;

import com.springboot.rest.crud.demo.entity.Student;
import com.springboot.rest.crud.demo.repository.StudentRepository;
import com.springboot.rest.crud.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImplimentation implements StudentService {

    StudentRepository repository = null;

    public StudentServiceImplimentation(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Student student) {
        if(repository.existsById(student.getId())){
            return repository.save(student);
        }
        else {

            return null;
        }
    }

    @Override
    public String deleteStudent(long id) {
        if(repository.existsById(id)){
            try {
                repository.deleteById(id);
                return "Deleted";

            }catch (Exception e){
                return  e.toString();
            }
        }else {
            return "Not Found";
        }

    }
}
