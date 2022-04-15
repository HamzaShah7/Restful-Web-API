package com.example.restfulwebpractice.Domain;

public class Course {
    private Integer Course_ID;
    private String Course_Name;
    private int Credit_Hours;
    private String Teacher;

    public Course(Integer course_ID, String course_Name, int credit_Hours, String teacher) {
        Course_ID = course_ID;
        Course_Name = course_Name;
        Credit_Hours = credit_Hours;
        Teacher = teacher;
    }

    public Integer getCourse_ID() {
        return Course_ID;
    }

    public void setCourse_ID(Integer course_ID) {
        Course_ID = course_ID;
    }

    public String getCourse_Name() {
        return Course_Name;
    }

    public void setCourse_Name(String course_Name) {
        Course_Name = course_Name;
    }

    public int getCredit_Hours() {
        return Credit_Hours;
    }

    public void setCredit_Hours(int credit_Hours) {
        Credit_Hours = credit_Hours;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }
}
