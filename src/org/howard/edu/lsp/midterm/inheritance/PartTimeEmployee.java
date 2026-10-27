package org.howard.edu.lsp.midterm.inheritance;

/** Represents a part-time employee receiving straight hourly pay. */
public class PartTimeEmployee extends Employee {
    /**
     * Creates a part-time employee receiving straight hourly pay.
     * @param hoursWorked nonnegative weekly hours
     * @param hourlyRate nonnegative hourly rate
     */
    public PartTimeEmployee(double hoursWorked, double hourlyRate) {
        super("PART_TIME", hoursWorked, hourlyRate);
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
        return hoursWorked * hourlyRate;
    }
}

