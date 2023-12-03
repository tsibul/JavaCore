package main.java.ru.javacore.lessons.l3;

import main.java.ru.javacore.lessons.l3.employee.Employee;
import main.java.ru.javacore.lessons.l3.factory.EmployeeFactory;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> emp = EmployeeFactory.createEmployees(11);
        EmployeeFactory.printEmployees(emp);
    }
}
