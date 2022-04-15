package com.example.restfulwebpractice.Services;

import com.example.restfulwebpractice.Domain.Course;
import com.example.restfulwebpractice.Domain.Employee;
import com.example.restfulwebpractice.REpo.Course_Interface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class Course_Interface_Impl implements Course_Interface {

    private static List<Course> Course_List = new ArrayList<>();
    private static int Course_id = 3;

    @Override
    public Course Add_Course(Course crs) {
        if (crs.getCourse_ID()==null){
            crs.setCourse_ID(Course_id++);
        }
        Course_List.add(crs);
        return crs;
    }

    @Override
    public List<Course> RetrieveAllCourse() {
        return Course_List;
    }

    @Override
    public Course RetrieveOneCourse(Integer crs_id) {
        for (Course  c : Course_List){
            if (c.getCourse_ID().equals(crs_id)){
                return c;
            }
        }
        return null;
    }

    @Override
    public Course DeleteOneById(Integer crs) {
        Iterator<Course> iterator = Course_List.iterator();
        while (iterator.hasNext()){
            Course c = iterator.next();
            if (c.getCourse_ID().equals(crs)){
                iterator.remove();
                return c;
            }
        }
        return null;
    }
}
