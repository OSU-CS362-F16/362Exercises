# Assignment 2

## Preliminaries

* You'll first need to download and unzip Maven 3.3.9 if you haven't done so already. We will be using the Maven `mvn` command frequently and we highly recommend you create an alias to the `<maven directory>/bin` in your *NIX shell.
* Get the latest files from the instructor's repository by running the `bin/sync` script
* Copy the contents `templates/hw2` to `submissions/hw2`.  `git add` the copied files and then commit to your local repository

## Part 1) Warm up

The file `submissions/hw2/src/main/java/edu/osu/cs362/WarmUp.java` contains 4 functions for which you are to develop unit tests. We will be using a tool called JUnit which is a unit test framework for Java.  The file `submissions/hw2/src/test/java/edu/osu/cs362/WarmupTest.java` is provided to you with an example unit test

Create a new method called `testX` where `X` is the name of each of the four functions in the Warmup class.  Create a set of tests for each of these four functions and answer the following questions for each

* Over what inputs, if any, does this function throw an Exception?
* Over what inputs, if any, does this function provide incorrect output?

## Part 2) The blackjack game

***Something something story developer leave***

The developer left a note that there was a serious bug that was
affecting a previous version of certain card games. During the
execution of a game, it appeared as if cards within the deck switched
positions. and that they suspected the error was somewhere in either
the Card or CardCollection classes.

Your task is to a) find the issue and b) create a suite of units test
to find existing issues and prevent future ones.

### Part 2a) Writing a test suite

Create two new files in your submissions/hw2 directory:

* submissions/hw2src/test/java/edu/osu/cs362/CardCollectionTest.java 
* submissions/hw2src/test/java/edu/osu/cs362/CardTest.java 

To write new test suites, you'll need to mimic the WarmupTest.java
class. In particular: 

 - Your class must extend TestCase
 - Your class must provide method public static Test suite() 
 - Each test case method must start with test...

It is good practice to use a new method for each piece of
functionality you might test.  Similar test cases (e.g., testing a
class constructor with differnet parameters) can be grouped in the
same method

- Write a suite of JUnit tests to test the Card class
- Write a suite of JUnit tests for each method of the Hand class **excluding the `permute` function**. 

## Part 2b) The bug

If you were able to find an issue like the one described above, answer the following

  - What is the bug? Concisely describe it and provide a test case that reproduces it. Include a JUnit case in your writeup that replicates the error.  Be clear as to what the expected and actual outputs look like 
  - Would this error surface when the class was used for the following:
   - ...a deck where cards are always drawn from the top?
   - ...a hand where the player is required to keep their cards in order?
   - ...a deck that is shuffled by removing cards from a random place in the deck and adding them back via method `add`?

If you were unable describe your approach to developing your test suite and justify why the class is correct for the cases above

## What to submit

* All test suite files from part 1)
* Written answers from part 1) in `submissions/README.md`
* All test suite files from part 2a) 
* Written answers from part 2b) in `submissions/README.md`

