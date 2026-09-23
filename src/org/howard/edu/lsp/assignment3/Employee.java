package org.howard.edu.lsp.assignment3;

public class Employee{
    private int id;
    private String name;
    private String department;
    private double hours;
    private double rate;
    private double grossPay;
    private String payLevel;
    private String status;

    public Employee(int id, String name, String department, double hours, double rate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.hours = hours;
        this.rate = rate;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public double getHours() {
        return hours;
    }
    public double getRate() {
        return rate;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }
    public void setPayLevel(String payLevel) {
        this.payLevel = payLevel;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String toCSV() {
       return String.format(
               "%d,%s,%s,%.2f,%.2f,%.2f,%s,%s",
               id,
               name,
               department,
               hours,
               rate,
               grossPay,
               payLevel,
               status
       );

    }

}