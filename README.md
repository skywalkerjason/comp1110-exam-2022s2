
# COMP1110/1140/6710 Final Exam

This repository contains the IntelliJ project for the 2022 S2 final exam.

You have 3 hours and 15 minutes to complete the exam.

The question is marked out of 100, and accounts for 40% of your final
course mark. Marks for each question are specified below.

This exam is open book. This means that you may use books, notes, and
any other such pre-existing information as you complete the exam.

You must, however, **not communicate with any person other than the
examiners at any time during the exam**.
Chat, text, email and all other such forms of communications must be
turned off prior to the exam and must remain off for the entire duration
of the exam. You may _only_ use the class piazza forum.
Do not post to piazza visible to all during the exam.
The penalties for cheating in an exam at ANU are severe.

## Advice

*   **Read all questions and instructions carefully**.

*   Questions are **not** ordered by difficulty. Some questions are
	meant to be significantly harder than others (Q3, for example, is
	one of the hard ones). Take the time to read through all questions
	at the start of the exam, and solve the ones you think will be easy
	first.

*   Programming questions are marked on functionality, as determined by
	testing. Code style does not matter.

*   We will test your code with additional test cases other than those that
	are provided here, so it is important that you read and understand the
	specification of the method/methods that you are asked to implement,
	and implement that specification correctly. The tests that are provided
	are meant to help you do that, but _the tests are not the specification_.

*   A partially correct implementation (i.e., one that passes some tests
	but not all) will usually receive some marks. (There are exceptions,
	for example in cases where a “dummy” implementation like always
	returning false happens to pass a certain test; then there will be no
	marks for passing that particular test only.). However, _marks are not
	necessarily proportional to the number of tests passed_.

*   Some questions have an explicit breakdown of marks for parts or levels
	of functionality. (For example, Q4 has some marks for implementing
	methods _correctly_, and some additional marks for implementing them
	_correctly and in amortised constant time_.) Again, think about solving
	the easy part/level first, and attempt the harder one if you have time.
	
*   **Commit and push your work** regularly as you complete it. Access to the
	exam gitlab will close at the end of your exam time, and after that you
	will not be able to push anything more. We will only mark what is in your
	exam repository on the gitlab server after the exam.

	Close to the end of the exam (last 10-15 minutes), the exam server is
	likely to be very busy, and pushing can take much longer than normal.
	Be prepared	for that - don't leave pushing to the last minute!

*   Note that the exam server does **not** have CI (server-side testing)
	enabled. To test your solutions, you will have to run the provided
	tests in your IDE. (This also means when you push, you don't have to
	wait for CI to finish.)

	Do not modify the intelliJ project settings, since that may cause some
	of the tests to break.


## Q1  [15 Marks] Programming

Using the template [Q1AverageInRange.java](src/comp1110/exam/Q1AverageInRange.java), complete the unimplemented method `averageInRange`.



## Q2  [15 Marks] Programming

Using the template [Q2ThreeOdd.java](src/comp1110/exam/Q2ThreeOdd.java), complete the unimplemented method `threeOdd`.



## Q3  [15 Marks] Programming (search problem, hard)

Using the template [Q3Schedule.java](src/comp1110/exam/Q3Schedule.java), complete the unimplemented method `maximalSchedule`.



## Q4  [15 + 5 Marks] Implementation and computational complexity

Using the template [Q4Sources.java](src/comp1110/exam/Q4Sources.java),
complete *all unimplemented methods*. You must also add fields to the
class, as necessary to implement the specified method functionality.

You must complete your solution within
**the single file, [Q4Sources.java](src/comp1110/exam/Q4Sources.java)**.
You can, and indeed are incouraged to, create additional classes if that
helps you solve the problem, but any additional classes must be implemented
as nested classes within the `Q4Sources` class.

Note that this question has two levels of diffculty:

For *level 1* (15 marks), you are only required to implement the
functionality specified for each method. Use the tests provided
([Q4SourcesTest](tests/comp1110/exam/Q4SourcesTest.java)) to test your
implementation for correctness.

For *level 2* (5 additional marks), you must implement the methods so that
they are not only functionally correct, but also run in amortised constant
time. (In other words, the difference between level 1 and 2 is not what you
implement, but _how_.) To help you test the scaling behaviour of your
implementation, a scaling test is implemented in the `main` method of the
`Q4Sources` class. If your solution meets the amortised constant time
requirement, you should find that the test runtime is approximately equal
for increasing network sizes. If you see a consistent trend for the time
to increase as the network size increases, then your implementation (of
at least some method) is probably not constant time.

Remember to commit and push your work!



## Q5  [15 Marks] Testing

Using the template
[Q5IsIncreasingTest.java](src/comp1110/exam/Q5IsIncreasingTest.java),
write at most 5 unit tests for the `isIncreasing` method in the
[IsIncreasing.java](src/comp1110/exam/IsIncreasing.java) class. The
method is not implemented, but the javadoc comment describes what a
correct implementation of the method is meant to do.

*   You can write up to 5 tests (assertions) in the one test method,
	or split them over several test methods, as you prefer. However,
	all your test methods must have the `@Test` annotation.

*   Your tests should cover all edge cases.

*   A correct implementation should pass all your tests. (If you want
	to, you can write a correct implementation of the `isIncreasing`
	method to test that your tests meet this requirement.)

*   Note that the `IsIncreasing` class is generic: to test the method,
	you must instantiate the class with a type of your choice; you can
	use different types for different tests.
	
Remember to commit and push your work.



## Q6  [15 Marks] Hashing and equality

Using the template
[Q6StringPattern.java](src/comp1110/exam/Q6StringPattern.java),
implement `equals` and `hashCode` in both subclasses `StringConstant` and
`StringOperator`.

Use the tests provided in
[Q6StringPatternTest.java](tests/comp1110/exam/Q6StringPatternTest.java) to
test your implementation.

Marks for this question are divided between implementing the `equals` and
`hashCode` methods correctly (12 marks, tests `testEquals`, `testHashEq`
and `testHash2`) and implementing a good hash function (up to 3 additional
marks, tests `testHash6` and `testHash16`).



## Q7  [5 Marks] JavaFX Programming

Using the template
[Q7TrafficLight.java](src/comp1110/exam/Q7TrafficLight.java),
complete the event handlers to make the application have the following
behaviour:

*   When the &quot;Go&quot; button is pressed, set the colour of the lower circle
	to GREEN and the colour of the upper circle to GRAY.
*   When the &quot;Stop&quot; button is pressed, set the colour of the upper circle
	to RED and the colour of the lower circle to GRAY.
*   When the &quot;Reset&quot; button is pressed, set the colour of both circles to
	GRAY.

A method `setColor` and predefined red, green and gray colours are provided
to help you. You can make other changes to the class (such as add fields or
methods) if you think it is helpful, but you must **not** modify the UI
components (that is, not change the nodes in the scene or their layout).

Note that there are no unit tests for this question; you will have to test
it yourself.

