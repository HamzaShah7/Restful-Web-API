package com.example.restfulwebpractice.Web;

import com.example.restfulwebpractice.Domain.Course;
import com.example.restfulwebpractice.Exception.UserNotFoundException;
import com.example.restfulwebpractice.Services.Course_Interface_Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class Course_Controller {
    @Autowired
    private Course_Interface_Impl course;

    @GetMapping("/Courses")
    public List<Course> RetriveAllCourses(){

        List<Course> crs = course.RetrieveAllCourse();

        if (crs.isEmpty()){
            throw new UserNotFoundException("Course record not found.");
        }
        return crs;
    }

    @PostMapping("/Courses")
    public ResponseEntity<Object> createUser(@RequestBody Course Cour){
        Course cour1 = course.Add_Course(Cour);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(cour1.getCourse_ID())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @GetMapping("/Course/{id}")
    public Course RetrieveUser(@PathVariable int id){
        Course crs = course.RetrieveOneCourse(id);
        if (crs==null){
            throw new UserNotFoundException("Course with id: "+id+" not Found.");
        }

        return crs;
    }

    @DeleteMapping("/Course/{id}")
    public void DeleteUser(@PathVariable int id){
        Course user = course.DeleteOneById(id);

        if (user==null) {
            throw new UserNotFoundException("Course with id: "+id+" not Found.");
        }
    }

}
