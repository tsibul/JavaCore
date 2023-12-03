package main.java.ru.javacore.lessons.l3.employee;

public class Freelancer extends Employee{
    @Override
    public float getSalary() {
        return super.getSalary() * 20.8f * 8f;
    }
}
