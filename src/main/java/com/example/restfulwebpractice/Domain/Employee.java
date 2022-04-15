package com.example.restfulwebpractice.Domain;

public class Employee extends People{
    private Integer Emp_ID;
    private int Salary;

    public Employee(String name, String address, int age, Integer emp_ID, int salary) {
        super(name, address, age);
        Emp_ID = emp_ID;
        Salary = salary;
    }

    public Integer getEmp_ID() {
        return Emp_ID;
    }

    public void setEmp_ID(Integer emp_ID) {
        Emp_ID = emp_ID;
    }


    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
}
