# Assignment 2

## Preliminaries

* You'll first need to download and unzip Maven 3.3.9 if you haven't done so already. We will be using the Maven `mvn` command frequently and we highly recommend you create an alias to the `<maven directory>/bin` in your *NIX shell.
* Get the latest files from the instructor's repository by running 

~~~
    git remote add upstream "https://github.com/OSU-CS362-F16/362Exercises"
    git checkout master              # make sure we're on the master branch
    git fetch upstream             # pull any information about changes in upstream
    git merge upstream/master -m "Sync" # merge new files
~~~

* Copy the contents `templates/hw2` to `submissions/hw2`.  `git add` the copied files and then commit to your local repository

## Part 1) Warm up

The file `submissions/hw2/src/main/java/edu/osu/cs362/WarmUp.java` contains 4 functions for which you are to develop unit tests. We will be using a tool called JUnit which is a unit test framework for Java.  The file `submissions/hw2/src/test/java/edu/osu/cs362/WarmupTest.java` is provided to you with an example unit test

Create a new method called `testX` where `X` is the name of each of the four functions in the Warmup class.  Create a set of tests for each of these four functions and answer the following questions for each and submit the answers in `submissions/hw2/P1.txt`

* Over what inputs, if any, does this function throw an Exception?
* Over what inputs, if any, does this function provide incorrect output?

## Part 2) The blackjack game

You just joined a team that is working on an online Blackjack
server. The developer left a note that there was a serious bug that
was affecting a previous version of certain card games. During the
execution of a game, it appeared as if cards within the deck switched
positions. and that they suspected the error was somewhere in either
the Card or CardCollection classes.

Your task is to examine the two classes a) find the issue and b)
create a suite of units test to find existing issues and prevent
future ones.

### Part 2a) Writing a test suite

Create two new files in your submissions/hw2 directory:

* submissions/hw2src/test/java/edu/osu/cs362/CardCollectionTest.java 
* submissions/hw2src/test/java/edu/osu/cs362/CardTest.java 

To write new test suites, you'll need to mimic the WarmupTest.java
class. In particular: 

 - Your class must extend TestCase
 - Your class must provide method public static Test suite() that mimics the form of WarmupTest.java
 - Each test case method must start with `test`...

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
