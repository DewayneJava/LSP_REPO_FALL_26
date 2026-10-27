# Sites used

https://www.geeksforgeeks.org/java/interfaces-in-java/ used to describe why we use interfaces.
https://www.w3schools.com/java/java_arraylist.asp used for array list syntax.


# Conversation Development Log

Date: October 26, 2026

This log records the user prompts and actions from the conversation available in this session. Prompt text is transcribed below; assistant responses and actions are summarized.

## Prompt 1: Create the submission structure

### User prompt

```text
Submission Package Structure
Use the following structure in your GitHub repository. The bracketed entry represents Java files you must determine and create for Question 3; it is not a literal filename.
org/
└── howard/
    └── edu/
        └── lsp/
            └── midterm/
                ├── crccards/                         (Question 1)
                │   ├── Book.java
                │   ├── Library.java
                │   ├── Driver.java
                │   └── doc/
                │       ├── crccards.md
                │       └── development_log.md
                ├── design/                           (Question 2)
                │   └── doc/
                │       ├── evaluation.md
                │       ├── design.md
                │       ├── design_rationale.md
                │       └── development_log_q2.md
                ├── inheritance/                     (Question 3)
                │   ├── Driver.java
                │   ├── [Your implementation .java files]
                │   └── doc/
                │       └── development_log_q3.md
                └── reflection/                        (Question 4)
                    └── doc/
                        └── ai_reflection.md
All Java files must declare the package matching their directory. Markdown files belong in the corresponding doc directory. Do not submit compiled .class files or IDE-specific project files.
 can you create the required folder structure for this
```

### Actions performed

- Inspected the existing source tree and checked for applicable AGENTS.md instructions; none were found in the locations checked.
- Found existing directories named `midterm/crccards.md` and `midterm/developmentlog.md` and preserved them.
- Created the `crccards/doc`, `design/doc`, `inheritance/doc`, and `reflection/doc` directory structure under `org/howard/edu/lsp/midterm`.
- Created these 12 named files:
  - `crccards/Book.java`
  - `crccards/Library.java`
  - `crccards/Driver.java`
  - `crccards/doc/crccards.md`
  - `crccards/doc/development_log.md`
  - `design/doc/evaluation.md`
  - `design/doc/design.md`
  - `design/doc/design_rationale.md`
  - `design/doc/development_log_q2.md`
  - `inheritance/Driver.java`
  - `inheritance/doc/development_log_q3.md`
  - `reflection/doc/ai_reflection.md`
- Added matching Java package declarations and public class skeletons. Both Driver classes include a main method with a TODO comment.
- Added headings and TODO placeholders to the Markdown documents.
- Left Question 3's additional implementation classes unspecified because the question's requirements were not provided. Did not create a literal bracketed filename.
- Listed the resulting files to confirm all 12 were present. No compilation or runtime tests were performed for this scaffolding task.
- Added no compiled .class files or IDE-specific project files. No commit or push was performed.

### Outcome communicated

The folder structure and named placeholder files were created. The assignment implementations and written answers remain to be completed.

## Prompt 2: Record conversation progress

### User prompt

```text
in developmentlog.md, transcribe the conservation progress for any prompts. Note any actions done
```

### Actions performed

- Located the existing development log files and inspected the midterm tree.
- Confirmed that `midterm/developmentlog.md` is a directory rather than a Markdown file.
- Created this file at `crccards/doc/developmentlog.md` to use the requested filename while keeping Markdown documentation in a doc directory.
- Recorded both available user prompts, the scaffolding actions, verification performed, and remaining work.
- Preserved the required `crccards/doc/development_log.md` placeholder and the existing directories.

## Prompt 3: Implement toString and verify Book

Date: October 26, 2026

### User prompt

```text
make the tostring() method in book             •	toString() format: B101 Effective Java by Joshua Bloch [AVAILABLE]. Use [BORROWED] when unavailable.
and verify my book class
```

### Actions performed

- Reviewed Book.java and its neighboring Library and Driver classes.
- Located the existing conversation log at `crccards/doc/development_log.md` and continued logging there.
- Fixed the constructor's invalid `True` literal to Java's lowercase `true`.
- Replaced the incomplete toString declaration and pasted assignment text with an overridden `toString()` method.
- Implemented the exact format `B101 Effective Java by Joshua Bloch [AVAILABLE]`, switching to `[BORROWED]` when unavailable.
- Preserved the existing borrow/return behavior and package-private class visibility.
- Compiled Book, Library, and Driver with javac alongside a temporary verification harness.
- Ran checks for all three getters, initial availability, both exact string formats, borrowing, returning, and IllegalStateException on invalid repeated operations. All checks passed, including state preservation after rejected operations.
- Wrote the verification harness and compiled classes to a temporary directory outside the repository.
- Verification covers the provided formatting requirement and current class behavior; the full Question 1 specification has not been supplied.

## Prompt 4: Write the findBook check

Date: October 26, 2026

### User prompt

```text
write the check for findBook based on the rubric
```

### Actions performed

- Reviewed Library.java and the instructor-provided verification Driver.java. No separate rubric was found in the searched workspace files.
- Used the driver's requirements: an existing ISBN returns the same Book object; a missing ISBN returns null.
- Implemented findBook with a loop using String.equals to compare ISBNs, returning the stored matching book or null if none matches.
- The initial edit attempt found a line-ending mismatch and made no changes; the subsequent edit succeeded.
- Reviewed the implementation against the lookup checks. No compilation or runtime tests were run because Library has other compilation blockers: its import precedes its package declaration, it is an interface containing concrete method bodies, and other method declarations remain unfinished.
- Left the remaining Library implementation unchanged.

## Prompt 5: Complete Library and verify results

Date: October 26, 2026

### User prompt

```text
write the remaining functions in library and verify results
```

### Actions performed

- Reviewed the current Library, Book, and instructor-provided Driver files.
- Changed Library from an interface to a concrete public class so the driver can instantiate it, placed the package declaration before imports, and made the book collection private and specific to each Library instance.
- Fixed addBook to reject duplicate ISBNs with IllegalArgumentException and preserve the original book.
- Preserved findBook's matching-object/null lookup behavior.
- Implemented borrowing with a maximum of three borrowed books, and returning through Book's state validation. Unknown ISBNs throw IllegalArgumentException; invalid state transitions and exceeding the limit throw IllegalStateException.
- Implemented available-book filtering, case-sensitive author filtering including borrowed books, and ascending ISBN sorting on a copied list.
- Replaced the unused borrow counter with a count derived from current Book availability, avoiding a separate counter that could become inconsistent with book state.
- Compiled Book.java, Library.java, and Driver.java successfully with javac, writing class files to a temporary directory outside the repository.
- Ran the unchanged instructor-provided Driver: 44 PASSED, 0 FAILED; FUNCTIONAL SCORE: 25.00 / 25. This score is the driver's functional result, not an assessment of the full assignment rubric.
- Updated this development log with the prompt, completed actions, and verification results.

## Prompt 6: Add Javadocs under Step 3

Date: October 26, 2026

### User prompt

```text
add javadocs under step 3
```

### Actions performed

- Searched the midterm files for Step 3 and Javadoc instructions; no matching instructions were found. Interpreted the request in the current Question 1 context as documenting Book, Library, and the Driver entry point.
- Added Javadocs to Book and Library classes, Book's constructor, and all their declared public methods, including parameters, return values, and intentional exceptions where applicable.
- Documented exact string formatting, case-sensitive author lookup, missing ISBN behavior, the three-book borrowing limit, copied result lists, and ISBN sorting.
- Added Javadoc to Driver.main while preserving the existing driver class documentation and all executable code.
- Generated documentation successfully using `javadoc -package -Xdoclint:all,-missing`, with UTF-8 encoding and output in a temporary directory outside the repository. This validates Javadoc syntax and links; missing-comment warnings were excluded for private implementation details and implicit constructors.
- No runtime tests were repeated because only comments changed.
