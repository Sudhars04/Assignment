package com.example.java;

import java.util.ArrayList;

public class Salesperson extends Employee {

    private int target;
    private ArrayList<ArrayList<Integer>> dailysales;
    private ArrayList<Integer> totalweeklysales;
    private ArrayList<String> achievementstatus;


    public Salesperson(String empid, String empname, int target, ArrayList<ArrayList<Integer>> dailysales) {
        super(empid, empname);
        this.target = target;
        this.dailysales = dailysales;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public ArrayList<ArrayList<Integer>> getDailysales() {
        return dailysales;
    }

    public void setDailysales(ArrayList<ArrayList<Integer>> dailysales) {
        this.dailysales = dailysales;
    }

    public ArrayList<Integer> getTotalweeklysales() {
        return totalweeklysales;
    }

    public void setTotalweeklysales(ArrayList<Integer> totalweeklysales) {
        this.totalweeklysales = totalweeklysales;
    }

    public ArrayList<String> getAchievementstatus() {
        return achievementstatus;
    }

    public void setAchievementstatus(ArrayList<String> achievementstatus) {
        this.achievementstatus = achievementstatus;
    }

    public void totalWeeklySales() {
        ArrayList<Integer> tws = new ArrayList<>();
        for (int i = 0; i < this.dailysales.size(); i++) {
            int weeklySales = 0;
            for (int j : this.dailysales.get(i)) {
                weeklySales += j;
            }
            tws.add(weeklySales);
        }
        this.totalweeklysales = tws;
    }

    public ArrayList<Boolean> achievementStatus(ArrayList<Integer> totalWeeklySales) {
        Boolean status;
        ArrayList<Boolean> achieveStatus = new ArrayList<>();
        int a = 1; //to keep track of week's number in output
        for (int i : totalWeeklySales) {
            if (i >= this.target) {
                status = true;
                achieveStatus.add(status);
            } else {
                status = false;
                achieveStatus.add(status);
            }
        }
        return achieveStatus;
        /*String status;
        int difference;
        ArrayList<String> achieveStatus = new ArrayList<>();
        int a = 1; //to keep track of week's number in output
        for (int i : totalWeeklySales) {
            if (i > this.target) {
                status = "Achieved";
                difference = i - this.target;
                //String y = Integer.toString(difference);
                achieveStatus.add("Week " + a + ":" + status + ", sales done by him/her is "
                        + Integer.toString(difference) + " more than the given target");

            } else if (i == this.target) {
                status = "Achieved";
                achieveStatus.add("Week " + a + ":" + status +
                        ", sales done by him/her is exactly same as the target given.");
            } else {
                status = "Not Achieved";
                difference = this.target - i;
                //String z = Integer.toString(difference);
                achieveStatus.add("Week " + a + ":" + status + ", sales done by him/her is "
                        + Integer.toString(difference) + " less than the given target");
            }
        }
        this.achievementstatus = achieveStatus;*/
    }
}