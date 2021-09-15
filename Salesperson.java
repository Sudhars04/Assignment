package com.example.java;

import java.util.ArrayList;

public class Salesperson extends Employee {

    private int target;
    private ArrayList<ArrayList<Integer>> dailysales;
    public ArrayList<Integer> tws;
    public ArrayList<String> as;



    public <dailysales> Salesperson(String empid, String empname, int target, ArrayList<ArrayList<Integer>> dailysales) {
        super(empid, empname);
        this.target = target;
        this.dailysales = dailysales;
    }
    public void totalWeeklySales(ArrayList<ArrayList<Integer>> dailysales){
        ArrayList<Integer> tws=new ArrayList<>();
        for (int i = 0; i <dailysales.size() ; i++) {
            int weeklySales=0;
            for (int j:dailysales.get(i)) {
                weeklySales+=j;
            }
            tws.add(weeklySales);
        }
        this.tws=tws;
    }
    public void achievementStatus(ArrayList<Integer> totalWeeklySales){
        String status;
        int difference;
        ArrayList<String> achieveStatus=new ArrayList<String>();
        int a = 1;
        for (int i:totalWeeklySales) {
            if(i>this.target){
                status="Achieved";
                difference=i-this.target;
                String y=Integer.toString(difference);
                achieveStatus.add("Week " + a +":"+ status+", sales done by him/her is "+y+
                        " more than the given target");



            }else if(i==this.target){
                status="Achieved";
                difference=i-this.target;
                String y=Integer.toString(difference);
                achieveStatus.add("Week " + a +":"+ status+
                        ", sales done by him/her is exactly same as the target given.");
            }
            else{
                status="Not Achieved";
                difference=this.target-i;
                String z=Integer.toString(difference);
                achieveStatus.add(status+","+z+" less than the given target");
            }
        }
        this.as= achieveStatus;
    }
}
