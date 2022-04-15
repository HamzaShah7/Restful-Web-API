package com.example.restfulwebpractice.REpo;

import com.example.restfulwebpractice.Domain.Employee;
import com.example.restfulwebpractice.Domain.Student;

import java.util.List;

public interface Employee_Interface {
    public Employee Add_Employee(Employee Emp);

    public List<Employee> RetrieveAllEmployee();

    public Employee RetrieveOneEmployee(Integer Emp);

    public Employee DeleteOneById(Integer Emp);
}
