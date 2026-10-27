# Question 2 — Part 1: Design Evaluation (8 points)

## Assignment context

The following class is part of a university course registration system. Evaluate its object-oriented design using principles discussed in class, including Arthur Riel’s object-oriented design heuristics. Study the code carefully and answer the questions that follow.

## Provided class

```java
import java.io.FileWriter;
import java.util.Date;
 
public class CourseRegistration {
 
    public String studentId;
    public String studentName;
    public String email;
    public String courseCode;
    public int creditHours;
 
    public void registerStudent() {
        // calculate tuition
        double tuition = creditHours * 750.0;
 
        // apply discount for heavy course load
        if (creditHours >= 12) {
            tuition = tuition * 0.90;
        }
 
        // print registration confirmation
        System.out.println("Student: " + studentName);
        System.out.println("Course: " + courseCode);
        System.out.println("Tuition: " + tuition);
 
        // save registration to file
        try {
            FileWriter writer = new FileWriter("registrations.txt", true);
            writer.write(studentId + "," + courseCode + "," + tuition + "\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        // send confirmation email
        System.out.println("Sending confirmation email to " + email);
 
        // log registration
        System.out.println("Registration processed at " + new Date());
    }
}
```

## Instructions

Evaluate the design of the CourseRegistration class. Describe the object-oriented design issues you observe and explain why they may lead to poor structure, maintainability, extensibility, or correctness. You must reference Arthur Riel’s design heuristics discussed in class.

Submit this response in `org/howard/edu/lsp/midterm/design/doc/evaluation.md`.

## Your evaluation

The OOP design in this question is quite flawed. First, the fields are public, which can lead to dangerous exploits. This violates encapsulation, which means anyone from anywhere can modify the data for a course. 
Second, there is no constructor explicitly here, which means Java is made to guess what the object is. This can result in incorrect data for the fields.
Third, this class violates the Single Responsibility idea. It attempts to be a registar, a file writer and a logger all at once. This is a God class.



## Sources cited

<!-- Cite any sources you use and document their use in development_log_q2.md. -->

