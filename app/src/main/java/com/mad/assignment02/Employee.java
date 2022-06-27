package com.mad.assignment02;

public class Employee {
    public String Fname, Lname, Position;
    public Integer Age, Salary;
    public Long Phone;
    Employee(String fname, String lname, Integer age, Long phone, Integer salary, String position){
        this.Fname = fname;
        this.Lname = lname;
        this.Age = age;
        this.Phone = phone;
        this.Salary = salary;
        this.Position = position;
    }
}
