package org.howard.edu.lsp.midterm.inheritance;

/** Represents a full-time employee with time-and-a-half pay beyond 40 hours. */
public class FullTimeEmployee extends Employee {
    /**
     * Creates a full-time employee with time-and-a-half pay beyond 40 hours.
     * @param hoursWorked nonnegative weekly hours
     * @param hourlyRate nonnegative hourly rate
     */
    public FullTimeEmployee(double hoursWorked, double hourlyRate) {
        super("FULL_TIME", hoursWorked, hourlyRate);
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
        double regularHours = Math.min(hoursWorked, 40.0);
        double overtimeHours = Math.max(hoursWorked - 40.0, 0.0);
        return regularHours * hourlyRate + overtimeHours * hourlyRate * 1.5;
    }
}

