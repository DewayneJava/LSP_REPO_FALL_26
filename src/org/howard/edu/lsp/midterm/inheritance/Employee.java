package org.howard.edu.lsp.midterm.inheritance;

/** Represents an employee whose pay is determined by a subclass. */
public abstract class Employee {
    private final String employeeType;
    private double hoursWorked;
    private double hourlyRate;

    /**
     * Creates an employee with the supplied work details.
     * @param employeeType the work type identifier
     * @param hoursWorked nonnegative weekly hours
     * @param hourlyRate nonnegative hourly rate
     */
    public Employee(String employeeType, double hoursWorked, double hourlyRate) {
        this.employeeType = employeeType;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    /**
     * Returns the work type.
     * @return the employee type identifier
     */
    public String getEmployeeType() {
        return employeeType;
    }

    /**
     * Checks the work type without selecting a pay calculation.
     * @param employeeType the exact, case-sensitive type to check
     * @return true when the supplied type matches
     */
    public boolean isWorkType(String employeeType) {
        return this.employeeType.equals(employeeType);
    }

    /**
     * Returns weekly hours.
     * @return the hours worked
     */
    public double getHoursWorked() {
        return hoursWorked;
    }

    /**
     * Updates weekly hours.
     * @param hoursWorked nonnegative weekly hours
     */
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     * Returns the hourly rate.
     * @return the hourly rate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Updates the hourly rate.
     * @param hourlyRate the nonnegative hourly rate
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Calculates pay using the stored hours and rate.
     * @return the employee's weekly pay
     */
    public abstract double calculatePay();

    /**
     * Calculates pay for supplied values without changing stored fields.
     * @param hoursWorked nonnegative weekly hours
     * @param hourlyRate nonnegative hourly rate
     * @return pay under this employee's pay rules
     */
    public abstract double calculatePay(double hoursWorked, double hourlyRate);

    /**
     * Describes this employee's work type, hours, and rate.
     * @return a readable description of the employee
     */
    @Override
    public String toString() {
        return employeeType + " [hoursWorked=" + hoursWorked
                + ", hourlyRate=" + hourlyRate + "]";
    }
}

