# Question 2 — Part 4: Development Log (5 points)

## Assignment instructions

Create development_log_q2.md in org/howard/edu/lsp/midterm/design/doc. Document all external resources used, including AI tools, internet searches, documentation, lecture notes, and textbooks. For AI assistance, include the complete conversation transcript (all prompts and responses) or a working shareable conversation URL that provides the full exchange. For websites, include URLs and how they helped; cite offline sources and how they helped. If no external assistance was used, state that clearly.

## Grading rubric

| Component | Points |
| --- | ---: |
| Design evaluation and explanation | 8 |
| CRC-based redesigned architecture | 8 |
| Evolving requirements and design rationale | 4 |
| Development log | 5 |
| **Total** | **25** |

Submission reminder: Push all required files to your GitHub repository before the exam ends. Work with other people is prohibited; permitted resources include notes, books, the internet, and AI tools, subject to the development-log requirements.

## External resources used

### AI assistance — October 26, 2026

- Tool: OpenAI Codex, used through this conversation.
- Purpose: Set up the Question 2 Markdown files with assignment instructions, the provided code, blank response areas, and a CRC card template.
- Scope: AI organized the files and recorded its assistance. The student will write the design evaluation, choose the redesigned classes, fill in the CRC cards, and write the design rationale.
- Verification: Read back the four Markdown files and checked for the expected instructions and placeholders. No Java implementation or runtime tests were needed for this documentation setup.
- No internet searches, websites, textbooks, or lecture notes were consulted by the assistant for this Question 2 setup. The assignment text supplied by the user was the source of the requirements.
- Earlier in this conversation, AI created the initial submission folders and placeholders and helped with Question 1. Those actions are recorded in [the earlier development log](../../crccards/doc/development_log.md). That file contains summaries and is not a complete verbatim transcript.

## Question 2 setup conversation transcript

The following records all user and assistant messages in the Question 2 setup exchange, including progress updates. Tool operations are summarized afterward. Earlier Question 1 exchanges are outside this transcript; if submitting this entire conversation as evidence, add a working full-conversation share URL or its complete transcript before submission.

### User — initial setup request

```text
can you add the setup for question 2 (leave the writing to me)
```

### Assistant — progress update

I’ll check Question 2’s existing files and add a writing scaffold with headings and placeholders for you to fill in.

### Assistant — progress update

The four required Question 2 Markdown files are present, but I don’t have the question’s full instructions. I’ll add a general outline for evaluation, design, rationale, and development notes that you can adapt to the rubric.

The user interrupted this turn before any file changes were made.

### User — assignment context and setup request

```text
Question 2 – Evaluating Object-Oriented Design (25 points)
The following class is part of a university course registration system. Evaluate its object-oriented design using principles discussed in class, including Arthur Riel’s object-oriented design heuristics. Study the code carefully and answer the questions that follow.
Provided Class
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
Part 1 – Design Evaluation (8 points)
Evaluate the design of the CourseRegistration class. Describe the object-oriented design issues you observe and explain why they may lead to poor structure, maintainability, extensibility, or correctness. You must reference Arthur Riel’s design heuristics discussed in class.
Submit your evaluation in evaluation.md in org/howard/edu/lsp/midterm/design/doc.
Part 2 – Proposed Improved Design Using CRC Cards (8 points)
Propose an improved object-oriented design for this system. Use CRC cards to identify major classes, their responsibilities, and their collaborators. You are not required to implement the redesigned classes in Java.
Submit your CRC cards in design.md in org/howard/edu/lsp/midterm/design/doc. Use the following format for each card:
Class:
Responsibilities:
Collaborators:
Part 3 – Evolving Requirements and Design Rationale (4 points)
The university now needs to support two storage options for registration records: a local file or a database, selected according to the deployment environment. It must also support sending confirmations by either email or text message.
Explain how your proposed CRC-based design would accommodate these changes. Identify any changes you would make to your CRC cards and justify one important decision about which class should own a particular responsibility. Your explanation must be consistent with your Part 2 design.
Submit your response in design_rationale.md in org/howard/edu/lsp/midterm/design/doc.
Part 4 – Development Log (5 points)
Create development_log_q2.md in org/howard/edu/lsp/midterm/design/doc. Document all external resources used, including AI tools, internet searches, documentation, lecture notes, and textbooks. For AI assistance, include the complete conversation transcript (all prompts and responses) or a working shareable conversation URL that provides the full exchange. For websites, include URLs and how they helped; cite offline sources and how they helped. If no external assistance was used, state that clearly.
Question 2 – Grading Rubric
Component	Points
Design evaluation and explanation	8
CRC-based redesigned architecture	8
Evolving requirements and design rationale	4
Development log	5
TOTAL	25
Submission reminder: Push all required files to your GitHub repository before the exam ends. Work with other people is prohibited; permitted resources include notes, books, the internet, and AI tools, subject to the development-log requirements.

  provided is the context for q2. Can you set up the question for me to answer, as in, put the information in each file. Remember to update on AI usage, this time in development_log_q2.md
```

### Assistant — progress update

I’ll put the relevant instructions and blank answer sections in each Question 2 file, including the provided code in `evaluation.md`. I’ll also record the Question 2 prompts and my responses in `development_log_q2.md`, leaving the analysis and design decisions to you.

### Assistant — final response

Set up all four Question 2 files with the provided instructions, source code, and blank answer sections. Added CRC card placeholders using the required format.

Recorded the Question 2 conversation and AI actions in `development_log_q2.md`. The evaluation, design, and rationale are left for you to write.

## Actions performed

1. Inspected the existing Question 2 files. They contained placeholders or were empty.
2. Added the provided CourseRegistration code and Part 1 instructions to evaluation.md, with a blank evaluation section.
3. Added Part 2 instructions and a repeatable Class / Responsibilities / Collaborators template to design.md.
4. Added Part 3 instructions and blank sections for storage options, confirmation options, CRC changes, and a responsibility ownership decision to design_rationale.md.
5. Added Part 4 requirements, the grading rubric, this Question 2 transcript, AI usage details, and a table for future resources to development_log_q2.md.
6. Retried the file-writing command using literal here-strings after a PowerShell quoting error; the failed attempt made no file changes.
7. Verified that all four Markdown files contain the intended setup.
8. Preserved existing image files. No Java classes were added or changed, and no commit or push was performed.
