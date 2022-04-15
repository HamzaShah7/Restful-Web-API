package com.example.restfulwebpractice.Services;

import com.example.restfulwebpractice.Domain.Course;
import com.example.restfulwebpractice.Domain.Employee;
import com.example.restfulwebpractice.REpo.Employee_Interface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class Employee_Interface_Impl implements Employee_Interface {

    private static List<Employee> Emp_List = new ArrayList<>();
    private static int Emp_id = 3;

    @Override
    public Employee Add_Employee(Employee Emp) {
        if (Emp.getEmp_ID()==null){
            Emp.setEmp_ID(Emp_id++);
        }
        Emp_List.add(Emp);
        return Emp;
    }

    @Override
    public List<Employee> RetrieveAllEmployee() {
        return Emp_List;
    }

    @Override
    public Employee RetrieveOneEmployee(Integer Emp_id) {
        for (Employee e : Emp_List){
            if (e.getEmp_ID().equals(Emp_id)){
                return e;
            }
        }
        return null;
    }

    @Override
    public Employee DeleteOneById(Integer Emp_id) {
        Iterator<Employee> iterator = Emp_List.iterator();
        while (iterator.hasNext()){
            Employee emp = iterator.next();
            if (emp.getEmp_ID().equals(Emp_id)){
                iterator.remove();
                return emp;
            }
        }
        return null;
    }
}
