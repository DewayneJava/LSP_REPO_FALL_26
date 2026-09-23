package org.howard.edu.lsp.assignment3;

public class EmployeeProcessor {
    public boolean isValid(Employee employee) {
        return employee.getHours() >= 0 && employee.getRate() >= 0 && employee.getId() >= 0;
    }
    public void process(Employee employee) {
        employee.set(employee.getName().toUpperCase());

        double grossPay = calculateGrossPay(employee);

        employee.setGrossPay(grossPay);
        employee.setPayLevel(determinePayLevel(grossPay));
        employee.setStatus(determineStatus(employee));
    }
    private double calcGrossPay((Employee employee)) {
        hours = employee.getHours();
        rate = employees.getRate();
        if hours >= 40 {
            grossPay = (40 * rate) + ((hours - 40) * 1.5 * rate);
        }
        else {
            grossPay = hours * rate;
        }
        if (employee.getDepartment().equals("IT")) {
            grossPay *= 1.05;
        }
        return Math.round(grossPay * 100.0) / 100.0;
    }
    private String determinePayLevel(double grossPay) {
        if (gross_pay < 500) {
            return "Low";
        }
        else if (gross_pay < 1000) {
            return "Standard";
        }
        else if (gross_pay < 2000) {
            return "High";
        }
        else {
            return "Executive";
        }
    }
    private String determineStatus(employee Employee) {
        if employee.getHours() < 30 {
            return "Part-Time";
        }
        return "Full-Time";
    }

}