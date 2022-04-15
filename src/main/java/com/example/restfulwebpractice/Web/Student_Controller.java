package com.example.restfulwebpractice.Web;

import com.example.restfulwebpractice.Domain.Student;
import com.example.restfulwebpractice.Exception.UserNotFoundException;
import com.example.restfulwebpractice.Services.Student_Interface_Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class Student_Controller {

    @Autowired
    private Student_Interface_Impl student;

    @GetMapping("/Students")
    public List<Student> RetriveAllStudents(){

        List<Student> stu = student.RetrieveAllStudents();

        if (stu.isEmpty()){
            throw new UserNotFoundException("No Student Record is Found.");
        }
        return student.RetrieveAllStudents();
    }

    @PostMapping("/Students")
    public ResponseEntity<Object> createStudent (@RequestBody Student std){
        Student std1 = student.Add_Student(std);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(std1.getStudent_id())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/Student/{id}")
    public Student RetrieveStudent(@PathVariable int id){
        Student std = student.RetrieveOneStudent(id);

        if (std==null){
            throw new UserNotFoundException("Student with id: "+id+" not Found.");
        }

        return std;
    }

    @DeleteMapping("/Student/{id}")
    public void DeleteUser(@PathVariable int id){
        Student std = student.DeleteOneById(id);

        if (std==null) {
            throw new UserNotFoundException("Student with id: "+id+" not Found.");
        }
    }
}
