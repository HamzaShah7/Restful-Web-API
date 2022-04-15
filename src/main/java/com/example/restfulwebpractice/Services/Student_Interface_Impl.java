package com.example.restfulwebpractice.Services;

import com.example.restfulwebpractice.Domain.Course;
import com.example.restfulwebpractice.Domain.Employee;
import com.example.restfulwebpractice.Domain.Student;
import com.example.restfulwebpractice.REpo.Student_Interface;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Student_Interface_Impl implements Student_Interface {

    private static List<Student> Std_list = new ArrayList<>();
    private static int Std_id =3;

    @Override
    public Student Add_Student(Student Stu) {
        if (Stu.getStudent_id()==null){
            Stu.setStudent_id(Std_id++);
        }
        Std_list.add(Stu);
        return Stu;
    }

    @Override
    public List<Student> RetrieveAllStudents() {
        return Std_list;
    }

    @Override
    public Student RetrieveOneStudent(Integer Stu_id) {
        for (Student s : Std_list){
            if (s.getStudent_id().equals(Stu_id)){
                return s;
            }
        }
        return null;
    }

    @Override
    public Student DeleteOneById(Integer Std_id) {
        Iterator<Student> iterator = Std_list.iterator();
        while (iterator.hasNext()){
            Student std = iterator.next();
            if (std.getStudent_id().equals(Std_id)){
                iterator.remove();
                return std;
            }
        }
        return null;
    }
}
