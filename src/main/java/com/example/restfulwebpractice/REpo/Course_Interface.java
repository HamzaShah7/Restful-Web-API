package com.example.restfulwebpractice.REpo;

import com.example.restfulwebpractice.Domain.Course;
import com.example.restfulwebpractice.Domain.Employee;

import java.util.List;

public interface Course_Interface {
    public Course Add_Course(Course crs);

    public List<Course> RetrieveAllCourse();

    public Course RetrieveOneCourse(Integer crs);

    public Course DeleteOneById(Integer crs);
}
