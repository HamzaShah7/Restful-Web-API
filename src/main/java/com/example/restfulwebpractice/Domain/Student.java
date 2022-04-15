package com.example.restfulwebpractice.Domain;

import java.util.Set;

public class Student extends People{
    private Integer Student_id;
    private String University;
    private Set<Course> Courses;

    public Student(String name, String address, int age, Integer student_id, String university, Set<Course> courses) {
        super(name, address, age);
        Student_id = student_id;
        University = university;
        Courses = courses;
    }

    public Integer getStudent_id() {
        return Student_id;
    }

    public String getUniversity() {
        return University;
    }

    public void setStudent_id(Integer student_id) {
        Student_id = student_id;
    }

    public void setUniversity(String university) {
        University = university;
    }

    public Set<Course> getCourses() {
        return Courses;
    }

    public void setCourses(Set<Course> courses) {
        Courses = courses;
    }
}
