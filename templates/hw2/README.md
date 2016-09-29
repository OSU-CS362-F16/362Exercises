# Assignment 2

## Preliminaries

* The only supported platform for this and all future assignments is EECS's `flip` server. You are welcome to use your own environment, but we can only provide support for issues on `flip`
* You'll first need to untar Maven 3.3.9 from the `bin` directory in the root of the repository if you haven't done so already. 

~~~
tar -xvf apache-maven-3.3.9.tar
~~~

You can untar into the `bin` directory or a directory of your chosing. We will be using the Maven `mvn` command frequently and we highly recommend you add the `<untarred maven directory>/bin`  to your [PATH](https://kb.iu.edu/d/acar) variable.  If you don't, you'll need to substitute `mvn` with `<untarred maven directory>/bin/mvn` 

* Get the latest files from the instructor's repository by running (from your repository directory)

**WARNING: Do not use the `bin/sync` script (yet). If you tried running the `bin/sync` script prior to this exercise, you'll need to do `git remote remove upstream` first**
~~~
    git remote add upstream "https://github.com/OSU-CS362-F16/362Exercises"
    git checkout master              # make sure we're on the master branch
    git fetch upstream             # pull any information about changes in upstream
    git merge upstream/master -m "Sync" # merge new files
~~~

You should now have new files in your `templates/hw2` directory



* Copy the contents `templates/hw2` to `submissions/hw2`.  `git add` the copied files and then commit to your local repository

## Part 1) Warm up

First, `cd` into the `submissions/hw2` directory and make sure you can run Maven and compile using

`mvn compile test`

The tail of your output should look like this

~~~~
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running edu.osu.cs362.WarmupTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.05 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 5.385 s
[INFO] Finished at: 2016-09-26T09:44:57-07:00
[INFO] Final Memory: 19M/1109M
[INFO] ------------------------------------------------------------------------
~~~

For this assignment, this is the only command you should need to know.  This Maven task will compile your code then run all the tests and display the output.  If you have compilation errors, the tests will not be run and the output of the Java compiler will be shown.


The file `submissions/hw2/src/main/java/edu/osu/cs362/WarmUp.java` contains 4 functions for which you are to develop unit tests. We will be using a tool called JUnit which is a unit test framework for Java.  The file `submissions/hw2/src/test/java/edu/osu/cs362/WarmupTest.java` is provided to you with an example unit test

Create a new method called `@Test public void testX(){...}` where `X` is the name of each of the four functions in the Warmup class.  Create a set of tests for each of these four functions and answer the following questions for each and submit the answers in `submissions/hw2/P1.txt`

* Over what inputs, if any, does this function throw an Exception?
* Over what inputs, if any, does this function provide incorrect output?

## Part 2) The blackjack game

You just joined a team that is working on an online Blackjack
server. The last developer left a note in a source control commit that there was a serious bug that
was affecting a previous version of certain card games. During the
execution of a game, it appeared as if certain cards changed position in the deck unexpectedly and that they suspected the error was somewhere in either
the Card or CardCollection classes.

Your task is to examine the two classes a) find the issue and b)
create a suite of units test to find existing issues and prevent
future ones.

### Part 2a) Writing a test suite

Create two new files in your submissions/hw2 directory:

* submissions/hw2/src/test/java/edu/osu/cs362/CardCollectionTest.java 
* submissions/hw2/src/test/java/edu/osu/cs362/CardTest.java 

To write new test suites, you'll need to mimic the WarmupTest.java
class. In particular: 

 - Each test case method must begin with @Test
 - All classes (.java files) must end in ...Test.java  (which you've already done above if you named your files as described)
 - All class names (`public class CardCollectionTest{...}`)  must reside in a .java file of the same name (`CardCollectionTest.java`)
 
Maven automatically runs the tests from classes in folder `src/test` fulfilling these two requirements.

It is good practice to use a new method for each piece of
functionality you might test.  Similar test cases (e.g., testing a
class constructor with differnet parameters) can be grouped in the
same method

- Write a suite of JUnit tests to test the Card class
- Write a suite of JUnit tests for each method of the CardCollection class **excluding the `permute` function**. 

## Part 2b) The bug

If you were able to find an issue like the one described above, answer the following in `submissions/hw2/P2.txt`

  - What is the bug? Concisely describe it and provide a test case that reproduces it. Include a JUnit case in your writeup that replicates the error.  Be clear as to what the expected and actual outputs look like 
  - Would this error surface when the class was used for the following:
   - ...a deck where cards are always drawn from the top?
   - ...a hand where the player is required to keep their cards in order?
   - ...a deck that is shuffled by removing cards from a random place in the deck and adding them back via method `add`?

If you were unable describe your approach to developing your test suite and justify why the class is correct for the cases above

## Submission checklist

Did you `git add` ...

* All test suite files from part 1)?
* Written answers from part 1) in `submissions/hw2/P1.txt`?
* All test suite files from part 2a) ?
* Written answers from part 2b) in `submissions/hw2/P2.txt`?

Be sure to `git commit` and `git push origin master`

## How to submit

When you've done the above, create a new branch of your repository called `hw2`. `submissions/hw2` in branch `hw2` should contain all files from `templates/hw2` in addition to the files you added.   This branch must be created and pushed to Github before the due date to
receive credit.
