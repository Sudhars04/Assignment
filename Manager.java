package com.example.java;

import java.util.ArrayList;

public class Manager extends Employee {

    public ArrayList<Salesperson> managingemployees;
    public Manager(String empid, String empname, ArrayList<Salesperson> employees) {
        super(empid, empname);
        this.managingemployees=employees;
    }
}
