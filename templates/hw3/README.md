# Assignment 2

## Preliminaries

* You'll be making some improvements on your HW2 code this week.  Copy
the entire contents `submissions/hw2` to `submissions/hw3`.  `git add`
the copied files and then commit to your local repository

## Part 2) The blackjack game
### Part 2a) Writing a test suite

Create two new files in your submissions/hw2 directory:

* submissions/hw2src/test/java/edu/osu/cs362/CardCollectionTest.java 
* submissions/hw2src/test/java/edu/osu/cs362/CardTest.java 

To write new test suites, you'll need to mimic the WarmupTest.java
class. In particular: 

 - Each test case method must begin with @Test

It is good practice to use a new method for each piece of
functionality you might test.  Similar test cases (e.g., testing a
class constructor with differnet parameters) can be grouped in the
same method

- Write a suite of JUnit tests to test the Card class
- Write a suite of JUnit tests for each method of the Hand class **excluding the `permute` function**. 

## Part 2b) The bug

If you were able to find an issue like the one described above, answer the following in `submissions/hw2/P2.txt`

  - What is the bug? Concisely describe it and provide a test case that reproduces it. Include a JUnit case in your writeup that replicates the error.  Be clear as to what the expected and actual outputs look like 
  - Would this error surface when the class was used for the following:
   - ...a deck where cards are always drawn from the top?
   - ...a hand where the player is required to keep their cards in order?
   - ...a deck that is shuffled by removing cards from a random place in the deck and adding them back via method `add`?

If you were unable describe your approach to developing your test suite and justify why the class is correct for the cases above

## What to submit

Your code must 

* All test suite files from part 1)
* Written answers from part 1) in `submissions/hw2/P1.txt`
* All test suite files from part 2a) 
* Written answers from part 2b) in `submissions/hw2/P2.txt`


## How to submit

Create a new branch of your repository called HW2 containing your
final submission.  This branch must be created before the due date to
receive credit.
