package com.designpatterns.prototype;

import java.util.List;

public class EmployeeDemo {
    public static void main(String[] args) {
        Employees emp = new Employees();
        emp.loadData();

        System.out.println(emp.getEmpList());
        List<String> list1 = emp.getEmpList();
        list1.add("JhonK");
        //use the clone method to get the employee object

        Employees empN = (Employees) emp.clone();
        System.out.println(empN.getEmpList());
        List<String> list = empN.getEmpList();
        list.add("JhonC");
        System.out.println(list);
        System.out.println(empN.getEmpList());

        Employees empN1 = (Employees) emp.clone();
        List<String> list2 = empN1.getEmpList();
        list2.remove("Jhon");
        System.out.println(list2);


    }
}
