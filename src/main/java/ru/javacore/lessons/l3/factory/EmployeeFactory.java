package main.java.ru.javacore.lessons.l3.factory;

import main.java.ru.javacore.lessons.l3.employee.Employee;
import main.java.ru.javacore.lessons.l3.employee.Freelancer;
import main.java.ru.javacore.lessons.l3.employee.Worker;
import main.java.ru.javacore.lessons.l3.finals.Name;
import main.java.ru.javacore.lessons.l3.finals.SurName;

import java.util.ArrayList;
import java.util.Random;

public class EmployeeFactory {
    public static ArrayList<Employee> createEmployees(int empCount) {
        ArrayList<Employee> employees = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < empCount; i++) {
            int type = random.nextInt(0, 2);
            String nameEmp = Name.name[random.nextInt(0, 10)];
            String surNameEmp = SurName.surName[random.nextInt(0, 10)];
            int yearBirth = 1983 + random.nextInt(0, 21);
            if(type == 0){
                Worker worker = new Worker();
                worker.setName(nameEmp);
                worker.setSurName(surNameEmp);
                worker.setYearBirth(yearBirth);
                worker.setSalary(60000f + random.nextInt(1, 10) * 1000f);
                employees.add((Employee) worker);
            } else {
                Freelancer freelancer = new Freelancer();
                freelancer.setName(nameEmp);
                freelancer.setSurName(surNameEmp);
                freelancer.setYearBirth(yearBirth);
                freelancer.setSalary(350f + random.nextInt(1, 6) * 5f);
                employees.add((Employee) freelancer);
            }
        }
        return employees;
    }

    public static void printEmployees(ArrayList<Employee> emp){
        emp.forEach(employee -> {
            System.out.print(employee.getName() + " ");
            System.out.print(employee.getSurName() + " ");
            System.out.print("year of birth: " + employee.getYearBirth() + " ");
            System.out.print("monthly salary: " + employee.getSalary() + " ");
            System.out.println();
        });
    }
}
