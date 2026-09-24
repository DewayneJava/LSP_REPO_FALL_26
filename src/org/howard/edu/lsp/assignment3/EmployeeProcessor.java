package org.howard.edu.lsp.assignment3;

public class EmployeeProcessor {

    public Employee createEmployee(String[] fields) {
        if (fields.length != 5) {
            return null;
        }
        try {

            for (int i = 0; i < fields.length; i++) {
                fields[i] = fields[i].trim();

            }

            int id = Integer.parseInt(fields[0]);
            double hours = Double.parseDouble(fields[3]);
            double rate = Double.parseDouble(fields[4]);

            return new Employee(id, fields[1], fields[2], hours, rate);
        }
        catch (NumberFormatException e) {
            return null;
        }
    }
    public boolean isValid(Employee employee) {
        return employee.getHours() >= 0 && employee.getRate() >= 0 && employee.getId() >= 0;
    }
    public void process(Employee employee) {
        employee.setName(employee.getName().toUpperCase());

        double grossPay = calcGrossPay(employee);

        employee.setGrossPay(grossPay);
        employee.setPayLevel(determinePayLevel(grossPay));
        employee.setStatus(determineStatus(employee));
    }
    private double calcGrossPay(Employee employee) {
        double hours = employee.getHours();
        double rate = employee.getRate();
        double grossPay;
        if (hours >= 40) {
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
        if (grossPay < 500) {
            return "Low";
        }
        else if (grossPay < 1000) {
            return "Standard";
        }
        else if (grossPay < 2000) {
            return "High";
        }
        else {
            return "Executive";
        }
    }
    private String determineStatus(Employee employee) {
        if (employee.getHours() < 30) {
            return "Part-Time";
        }
        return "Full-Time";
    }

}