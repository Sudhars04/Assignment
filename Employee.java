package com.example.java;

public class Employee {

    public String getEmpname() {
        return empname;
    } private String empid;
    private String empname;
    public Employee(String empid,String empname){
        this.empid = empid;
        this.empname = empname;
    }
    public String getEmpid() {
        return empid;
    }
}
