# Question 2 — Part 2: Proposed Improved Design Using CRC Cards (8 points)

## Instructions

Propose an improved object-oriented design for this system. Use CRC cards to identify major classes, their responsibilities, and their collaborators. You are not required to implement the redesigned classes in Java.

Submit this response in `org/howard/edu/lsp/midterm/design/doc/design.md`.

Use the following format for each card:

```text
Class:
Responsibilities:
Collaborators:
```

The provided source code is included in [evaluation.md](evaluation.md).

## Your CRC cards

<!-- Copy the card below for each class you propose. Choose the class names, responsibilities, collaborators, and number of cards yourself. -->

Class: Student

Responsibilities: Holds student id, name and email. 


Collaborators: None

Class: Course

Responsibilities: Holds course code and credit hours, aswell as students registers to it.


Collaborators: Student

Class: TuitionCalculator

Responsibilities: Calculates tuition based on credit hours, provides discounts for heavy course loads.


Collaborators: Course, Student

Class: Registrar

Responsibilities: Holds courses in a database and writes to a file.


Collaborators: Course

Class: EmailService

Responsibilities: Sends confirmation emails to students, or update emails to students.


Collaborators: Student

Class: CourseEnrollmentService

Responsibilities: Manages the calculation, storage and notification (essentially a mastermind of the system).


Collaborators: Student, Course, TuitionCalculator, Registrar, EmailService



