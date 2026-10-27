# Question 2 — Part 3: Evolving Requirements and Design Rationale (4 points)

## Instructions

The university now needs to support two storage options for registration records: a local file or a database, selected according to the deployment environment. It must also support sending confirmations by either email or text message.
Explain how your proposed CRC-based design would accommodate these changes. Identify any changes you would make to your CRC cards and justify one important decision about which class should own a particular responsibility. Your explanation must be consistent with your Part 2 design.

Submit this response in `org/howard/edu/lsp/midterm/design/doc/design_rationale.md`.

## Supporting the new storage options

<!-- Explain how your Part 2 design accommodates local-file or database storage selected according to the deployment environment. -->

There is a class called Registrar that saves any changes to courses to a file. Essentially, the Course class would have a list of students registered, and this would be put into a database for future look-ups.

## Supporting the new confirmation options

<!-- Explain how your Part 2 design accommodates email or text-message confirmations. -->

There is a class called Email Service that would update students in a course list to any changes, updates or removals of that course. It would also confirm students registry to a course.

## Changes to your CRC cards

The main changes I made was separating the responsibilities of the original class into many smaller classes. The original class would get reworked to a manager or controller of the other classes.
The classes I made were for each task of the program. There is a Student and Course class that have the general information for those objects. 
The Registrar class handles the file writing. The EmailService handles the notifications. The BusinessCalculator assigns the cost based on a course to a student's tuition.
Lastly, I added a controller class to coordinate all of these classes together.

 

## Responsibility ownership decision

<!-- Choose one important responsibility, identify the class that should own it, and justify your decision. -->

An important responsibility is a list of students in the course. I thought the course class should have it since each course will be unique anyways, and you want errors or bugs to be in the course class for easier debugging.
If instead the Registrar held the student list, it could cause bugs when saving to a file. Essentially, having it in the course prevents bugs from spilling out to the entire system.




