# Question 3 Development Log

Date: October 26, 2026

## External resources

- AI tool: OpenAI Codex, in this conversation.
- Assistance: Implemented and documented the employee hierarchy requested by the user; copied the supplied driver into the existing placeholder; compiled and verified the implementation.
- Requirements source: The assignment and driver supplied in the user prompt below.
- No internet searches, online documentation, lecture notes, or textbooks were consulted by the assistant for this task.
- Earlier repository scaffolding assistance is recorded in the Question 1 development log. The transcript below contains the complete Question 3 implementation exchange; it does not reproduce earlier Question 1 and Question 2 conversations.

## Complete Question 3 conversation transcript

### User

```text
The following class calculates employee pay using a conditional statement to select behavior. Refactor the design to use inheritance, method overriding, and polymorphism. Do not use a design pattern for this question.
Provided Class
public class EmployeePayCalculator {
    public double calculatePay(String employeeType,
                               double hoursWorked,
                               double hourlyRate) {
        if (employeeType.equals("FULL_TIME")) {
            return hoursWorked * hourlyRate;
        }
        if (employeeType.equals("PART_TIME")) {
            return hoursWorked * hourlyRate;
        }
        if (employeeType.equals("CONTRACTOR")) {
            return hoursWorked * hourlyRate * 1.15;
        }
        return 0.0;
    }
}
Part 1 – Refactor the Implementation (23 points)
Refactor the provided design using inheritance, method overriding, and polymorphism. Each class must be in its own .java file in the package org.howard.edu.lsp.midterm.inheritance.
Use the provided Driver to determine the classes, public constructors, method signatures, and required behavior. Your implementation must compile and execute with the Driver without modifying it.
You may introduce any appropriate fields, constructors, or supporting methods needed for your design. Assume hoursWorked and hourlyRate are nonnegative. As part of the refactoring, full-time employees must receive overtime pay at 1.5 times their hourly rate for hours worked beyond 40 per week. Part-time employees receive straight hourly pay, and contractors receive a 15% premium on all hours worked.
Include Javadoc comments for all classes, public constructors, and public methods. No separate design explanation is required.
Part 2 – Provided Driver (Do Not Modify)
package org.howard.edu.lsp.midterm.inheritance;
 
public class Driver {
    private static int passed = 0;
    private static int failed = 0;
 
    private static void check(String label, boolean condition) {
        if (condition) {
            passed++;
            System.out.println("PASS: " + label);
        } else {
            failed++;
            System.out.println("FAIL: " + label);
        }
    }
 
    private static boolean equal(double actual, double expected) {
        return Math.abs(actual - expected) < 0.000001;
    }
 
    private static void test(String label, Employee employee,
                             double expected) {
        try {
            check(label, equal(employee.calculatePay(), expected));
        } catch (Exception e) {
            check(label, false);
        }
    }
 
    public static void main(String[] args) {
        test("Full-time 0 hours", new FullTimeEmployee(0, 20), 0);
        test("Full-time 30 hours", new FullTimeEmployee(30, 20), 600);
        test("Full-time 40 hours", new FullTimeEmployee(40, 20), 800);
        test("Full-time 45 hours", new FullTimeEmployee(45, 20), 950);
        test("Full-time 50 hours", new FullTimeEmployee(50, 10), 550);
        test("Part-time 0 hours", new PartTimeEmployee(0, 20), 0);
        test("Part-time 30 hours", new PartTimeEmployee(30, 20), 600);
        test("Part-time 45 hours", new PartTimeEmployee(45, 20), 900);
        test("Contractor 0 hours", new Contractor(0, 20), 0);
        test("Contractor 30 hours", new Contractor(30, 20), 690);
        test("Contractor 45 hours", new Contractor(45, 20), 1035);
        test("Contractor 40 hours", new Contractor(40, 10), 460);
        System.out.println("RESULT: " + passed + " PASSED, "
                           + failed + " FAILED");
    }
}
Expected result for a correct implementation: RESULT: 12 PASSED, 0 FAILED. Each test is worth an equal share of the 13 functional-test points. The inheritance/polymorphism design is assessed separately.
Part 3 – Development Log (5 points)
Create development_log_q3.md in org/howard/edu/lsp/midterm/inheritance/doc. Document all external resources used while completing this question. For AI assistance, include the complete conversation transcript; for online sources, include URLs and how they helped; for offline sources, provide identifying citations. If no external assistance was used, write: "No external assistance was used."
 update the files needed for question 3. Refactor this class based on the following: Create an employee class with the fields in the first method. Have another method that checks the work type  of an employee (ie part time full time) Allow for inheritance, method overloading and polymorphism for future classes. Also include getter setting and a toString method
```

### Assistant — initial progress update

I’ll create an `Employee` base class and the three subclasses required by the driver, with getters, setters, work-type checking, `toString()`, and overloaded pay methods. Pay calculation will use overridden methods rather than type-based conditionals, as Question 3 requires. I’ll also save the supplied driver and record the full Question 3 exchange in its development log.

### Assistant — verification update

The supplied driver passed all 12 tests. All 25 additional checks passed too, covering setters, work-type checks, overloaded pay calculations, `toString()`, and boundary cases. Javadoc validation passed. The work type is read-only so it stays consistent with the subclass; hours and rate have setters.

### Assistant — final response

Implemented `Employee`, `FullTimeEmployee`, `PartTimeEmployee`, and `Contractor` with inheritance, overridden and overloaded pay methods, getters/setters, work-type checking, `toString()`, and Javadocs.

- Supplied driver: **12 passed, 0 failed**.
- Additional API and boundary checks: **25 passed**.
- Javadoc validation passed.

Recorded the Question 3 exchange and actions in `development_log_q3.md`. Compiled files stayed outside the repository.

## Actions performed

1. Inspected the inheritance directory, which contained a placeholder Driver and development log.
2. Added Employee.java as an abstract superclass with private employeeType, hoursWorked, and hourlyRate fields. The type is immutable; hours and rate have public getters and setters. Added getEmployeeType, isWorkType, and toString.
3. Declared abstract calculatePay() and an overloaded calculatePay(double hoursWorked, double hourlyRate). The overload computes pay without mutating the stored fields.
4. Added FullTimeEmployee.java, PartTimeEmployee.java, and Contractor.java. Each extends Employee and overrides both pay methods. No design pattern or employee-type conditional selects pay behavior.
5. Implemented full-time overtime at 1.5 times the rate after 40 hours, part-time straight hourly pay, and a contractor premium of 15 percent on all hours.
6. Replaced the placeholder Driver.java with the user-supplied driver without changing its code.
7. Added Javadocs to all implementation classes, public constructors, and public methods. Preserved the provided Driver exactly, including its absence of Javadocs.
8. Compiled all five repository Java files and a temporary extra-check harness successfully.
9. Ran the provided Driver: RESULT: 12 PASSED, 0 FAILED.
10. Ran 25 additional checks covering work types, unmatched/null type queries, overloaded calculations, field preservation, getters/setters, updated polymorphic pay, string output, zero rates, and fractional overtime. All passed.
11. Generated Javadocs for the four implementation classes with full doclint enabled; validation passed.
12. Kept the additional test harness, compiled classes, and generated documentation in a temporary directory outside the repository.
13. Recorded this transcript and verified that the saved driver matches the supplied source (ignoring line endings and trailing whitespace at the end of the file). No commit or push was performed.
