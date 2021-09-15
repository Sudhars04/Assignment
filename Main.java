package com.example.java;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

        public static void main(String[] args){
            String empId;
            String empName;
            int target;
            int days;
            Scanner scan=new Scanner(System.in);
            int n;
            ArrayList<Salesperson> splist=new ArrayList<>();
            System.out.println("Enter number of salesperson");
            n=scan.nextInt();
            for (int i = 0; i < n; i++) {
                scan.nextLine();
                System.out.println("Enter the details of salesperson "+(i+1));
                System.out.println("Enter Employee Id");
                empId = scan.nextLine();
                System.out.println("Enter Employee Name");
                empName = scan.nextLine();
                System.out.println("Enter sales target for a week");
                target = scan.nextInt();
                System.out.println("Enter number of days sales happened");
                days = scan.nextInt();
                scan.nextLine();
                ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
                int c=1;
                for (int j = 0; j < (days / 7); j++) {
                    ArrayList<Integer> inside = new ArrayList<Integer>();
                    int x;
                    for (int k = 0; k < 7; k++) {
                        System.out.println("Enter Sales for day "+c);
                        x = scan.nextInt();
                        inside.add(x);
                        c++;
                    }
                    list.add(inside);
                }
                ArrayList<Integer> left = new ArrayList<Integer>();
                for (int j = 0; j < days % 7; j++) {
                    int y;
                    System.out.println("Enter Sales for day "+c);
                    y = scan.nextInt();
                    left.add(y);
                    c++;
                }
                list.add(left);
                splist.add(new Salesperson(empId,empName,target,list));
                splist.get(i).totalWeeklySales(list);
                splist.get(i).achievementStatus(splist.get(i).tws);
            }
            int m;
            int empCount;
            String spempid;
            int d=1;
            ArrayList<Manager> mlist= new ArrayList<>();
            System.out.println("Enter number of Managers");
            m=scan.nextInt();
            scan.nextLine();
            for (int i = 0; i < m; i++) {
                ArrayList<Salesperson> managingemployees=new ArrayList<>();
                System.out.println("Enter the details of Manager, "+(i+1));
                System.out.println("Enter Employee ID");
                empId=scan.nextLine();
                System.out.println("Enter Employee Name");
                empName=scan.nextLine();
                System.out.println("Enter the number of salespersons working under him/her");
                empCount=scan.nextInt();
                scan.nextLine();
                for (int j = 0; j < empCount; j++) {
                    System.out.println("Enter employee Id of salesperson "+d);
                    spempid=scan.nextLine();
                    for (Salesperson k:splist) {
                        if(k.getEmpid().equalsIgnoreCase(spempid)){
                            managingemployees.add(k);
                        }
                    }
                    d++;
                }
                mlist.add(new Manager(empId,empName,managingemployees));
            }
            System.out.println("Salesperson details along with their managers");
            for (int i = 0; i < mlist.size() ; i++) {
                System.out.println("The details of Manager "+(i+1)+" are");
                System.out.println("Employee Id: "+mlist.get(i).getEmpid()+
                        " , Manager Name: "+mlist.get(i).getEmpname());
                System.out.println("The details of salespersons under this manager");
                for (int j = 0; j <mlist.get(i).managingemployees.size() ; j++) {
                    System.out.println("The details of salesperson "+(j+1)+" are");
                    System.out.println("Employee Id: "+mlist.get(i).managingemployees.get(j).getEmpid()+
                            " , Salesperson Name: "+mlist.get(i).managingemployees.get(j).getEmpname());
                    System.out.println("The weekly sales done by the salesperson for the respective week is: ");
                    System.out.println(mlist.get(i).managingemployees.get(j).tws);
                    System.out.println("The achievement status for this Salesperson is: ");
                    System.out.println(mlist.get(i).managingemployees.get(j).as);
                }
            }
        }
}
