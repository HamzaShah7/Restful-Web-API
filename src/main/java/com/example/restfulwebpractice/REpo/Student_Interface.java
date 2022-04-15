package com.example.restfulwebpractice.REpo;

import com.example.restfulwebpractice.Domain.Student;

import java.util.List;

public interface Student_Interface {
    public Student Add_Student(Student Stu);

    public List<Student> RetrieveAllStudents();

    public Student RetrieveOneStudent(Integer Stu);

    public Student DeleteOneById(Integer Std);

}
