# Assignment 6 — AI Usage Report

# Resources Used

Geeks4Geek: https://www.geeksforgeeks.org/advance-java/before-vs-beforeclass-vs-beforeeach-vs-beforeall-in-junit/

## Conversation history

AI tool used: OpenAI Codex. This history summarizes the available Assignment 6 exchanges. Earlier implementation discussions are known only from the previous report 5; 

| User request or discussion                                                                                                                 | Assistant response and work                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
|--------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Complete the remaining 45 tests based on the first 2 I wrote and the @BeforeEach, use `assertThrows`, and document test scenarios.         | Helped complete the 47 predefined JUnit 5 tests, fixture setup, assertion syntax, package placement, and readability improvements. Added checks for contents, boundaries, unchanged inputs, and result independence.                                                                                                                                                                                                                                                                        |
| November 16: “read the context for assignment 6”                                                                                           | Read `IntegerSet.java`, `IntegerSetTest.java`, and the report. Summarized the available context; no Java changes or tests run at that stage.                                                                                                                                                                                                                                                                                                                                                |
| November 16: supplied the Assignment 6 rubric, repeated after an interrupted turn, and requested documentation in the Assignment 6 report. | Recorded the requirements and emphasized meaningful assertions and independent tests.                                                                                                                                                                                                                                                                                                                                                                                                       |
| November 16: “clean up the ai usage md and make it more clear”                                                                             | Reorganized the report and condensed repeated rubric text and progress updates.                                                                                                                                                                                                                                                                                                                                                                                                             |
| November 16: “verify the java code and that ir compiles”                                                                                   | Reviewed both Java files and confirmed all 47 predefined test names. Compiled without warnings and ran all 47 tests successfully. Identified that the extrema tests needed ordinary-value checks in addition to integer-limit checks. Downloaded the JUnit runner from [Maven Central](https://repo.maven.apache.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/junit-platform-console-standalone-1.10.2.jar); no external instructional references were consulted. |
| November 16: “what would this improvement entail, also are the current tests sufficient”                                                   | Explained that methods returning constant integer limits could pass the original extrema tests. Recommended ordinary-value, all-negative, and all-positive cases.                                                                                                                                                                                                                                                                                                                           |
| November 16: “make these changes and rerun the tests”                                                                                      | Added four extrema assertions while keeping the boundary assertions and all 47 predefined methods. Recompiled without warnings; all 47 JUnit 5 tests passed again.                                                                                                                                                                                                                                                                                                                          |
| November 16: “include the convo history of the previous assignment 6 stuff”                                                                | Expanded the history to cover the available implementation summaries, rubric discussion, code review, test improvements, and results.                                                                                                                                                                                                                                                                                                                                                       |
| November 16: “clean up the report to include only the convohistory and the chnages made”                                                   | Reduced the report to conversation history and changes made, removing repeated transcripts, the rubric recap, and the separate scenario checklist.                                                                                                                                                                                                                                                                                                                                          | |

## Changes made

### Earlier implementation assistance recorded in the previous report

- Completed the bodies of the 47 predefined tests in `IntegerSetTest.java`, retaining their names and keeping them separate.
- Set up a fresh `IntegerSet` using `@BeforeEach` and a `makeSet(int... values)` helper.
- Corrected assertion syntax and package placement.
- Used `assertThrows(IllegalStateException.class, ...)` for empty-set extrema calls.
- Strengthened assertions for clearing, unique counts, boundaries, set-operation contents, unchanged inputs, independent results, and exact ascending `toString()` formatting.
- Reformatted test bodies for readability.

### Changes made during this conversation's November 16 review

- Added these assertions inside the existing extrema tests, retaining their original boundary checks:

```java
// testLargestNegativeAndPositiveValues
assertEquals(6, makeSet(-10, 0, 6).largest());
assertEquals(-2, makeSet(-10, -2, -7).largest());

// testSmallestNegativeAndPositiveValues
assertEquals(-10, makeSet(-10, 0, 6).smallest());
assertEquals(2, makeSet(10, 2, 7).smallest());
```

- Left `IntegerSet.java` unchanged during this review.
- Updated this report with the conversation history, assistance provided, changes, and verification results.
- Verified the updated sources with Java 21, `javac -Xlint:all`, and JUnit 5.10.2 through Console Standalone 1.10.2: **compilation passed without warnings; 47 tests passed, 0 failed, 0 skipped, 0 aborted**. Dependencies and compiled classes were kept outside the submission package.
