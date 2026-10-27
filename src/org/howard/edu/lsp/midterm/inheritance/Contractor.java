package org.howard.edu.lsp.midterm.inheritance;

/** Represents a contractor receiving a 15 percent premium on all hours. */
public class Contractor extends Employee {
    /**
     * Creates a contractor receiving a 15 percent premium on all hours.
     * @param hoursWorked nonnegative weekly hours
     * @param hourlyRate nonnegative hourly rate
     */
    public Contractor(double hoursWorked, double hourlyRate) {
        super("CONTRACTOR", hoursWorked, hourlyRate);
    }

    /**
     * Calculates pay using the stored work details.
     * @return weekly pay under this employee's pay rules
     */
    @Override
    public double calculatePay() {
        return calculatePay(getHoursWorked(), getHourlyRate());
    }

    /**
     * Calculates pay for supplied values without changing stored work details.
     * @param hoursWorked nonnegative weekly hours
     * @param hourlyRate nonnegative hourly rate
     * @return weekly pay under this employee's pay rules
     */
    @Override
    public double calculatePay(double hoursWorked, double hourlyRate) {
        return hoursWorked * hourlyRate * 1.15;
    }
}

