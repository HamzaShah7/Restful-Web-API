package com.example.restfulwebpractice.Web;

import com.example.restfulwebpractice.Domain.Employee;
import com.example.restfulwebpractice.Domain.Student;
import com.example.restfulwebpractice.Exception.UserNotFoundException;
import com.example.restfulwebpractice.Services.Employee_Interface_Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class Employee_Controller {

    @Autowired
    private Employee_Interface_Impl employee;

    @GetMapping("/Employees")
    public List<Employee> RetriveAllEmployee(){
        List<Employee> emp = employee.RetrieveAllEmployee();

        if (emp.isEmpty()){
            throw new UserNotFoundException("No employee record found.");
        }

        return emp;
    }

    @PostMapping("/Employees")
    public ResponseEntity<Object> createUser(@RequestBody Employee Empl){
        Employee Empl1 = employee.Add_Employee(Empl);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(Empl1.getEmp_ID())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @GetMapping("/Employee/{id}")
    public Employee RetrieveUser(@PathVariable int id){
        Employee emp = employee.RetrieveOneEmployee(id);
        if (emp==null){
            throw new UserNotFoundException("Employee with id: "+id+" not Found.");
        }

        return emp;
    }

    @DeleteMapping("/Employee/{id}")
    public void DeleteUser(@PathVariable int id){
        Employee emp = employee.DeleteOneById(id);

        if (emp==null) {
            throw new UserNotFoundException("Employee with id: "+id+" not Found.");
        }
    }

}
