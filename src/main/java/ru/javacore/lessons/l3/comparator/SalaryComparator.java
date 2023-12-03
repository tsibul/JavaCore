package main.java.ru.javacore.lessons.l3.comparator;

import main.java.ru.javacore.lessons.l3.employee.Employee;

import java.util.Comparator;

public class SalaryComparator implements Comparator <Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.getSalary() < o2.getSalary()){
            return 1;
        }
        else if(o1.getSalary() > o2.getSalary()){
            return -1;
        }
        return 0;
    }
}
