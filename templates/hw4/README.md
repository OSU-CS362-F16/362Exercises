# Assignment 4

## Preliminaries

* Get the latest files from the instructor's repository
~~~
    git remote add upstream "https://github.com/OSU-CS362-F16/362Exercises"
    git checkout master              # make sure we're on the master branch
    git fetch upstream             # pull any information about changes in upstream
    git merge upstream/master -m "Sync" # merge new files
~~~


* Remember to submit under a new branch called hw4

## Useful links

[Cobertura homepage](http://cobertura.github.io/cobertura/)


## Overview

You've successfully survived your first week on the Blackjack team and now you've been asked to prepare a 30-page [TPS Report](https://www.youtube.com/watch?v=Fy3rjQGc6lA) on the current state of the test suite.  Unfortunately, it looks like the current code base has two very small tests.  Instinctively, you know that these two tests are probably not sufficent, but you decide to do a bit more research to see how bad the problem really is.

In this assignment, we'll look at using a code coverage tool to measure the quality of the existing test suite and then explore where these metrics are useful (and where they are not). The `submissions/hw4` folder contains a new `pom.xml` that will pull down some new dependencies when you `mvn compile`.  In particular, you'll get a new library containing a tool called Cobertura.

The code below may have bugs in its functionality, throw exceptions where it shouldn't, etc.  Write your test cases for how you think the code should behave - submitting a failing test case may be appropriate. For this assignment, you will not be evaluated on the substance of your test cases, but writing good test cases will help you on a future assignment.

## Part 1) Code Coverage using Cobertura

Run the following command 

`mvn clean test`

followed by 

`mvn cobertura:clean cobertura:cobertura`

This should generate a set of files in the `submissions/hw4/target/site` folder including an `index.html` file.  Open this file with a web browser.  If you are SSH'd into a server without X11 (user interface) forwarding, you may want to use the `deploy` script in the the `submissions/hw4` folder to copy the site to your [EECS webspace](http://it.engineering.oregonstate.edu/where-do-i-put-my-personal-webpages).  

Your coverage report should be similar to this (link to [live page here](http://web.engr.oregonstate.edu/~baldwdav/report/) ):
![](https://snag.gy/C3He0V.jpg)

The `testBasicFunctionality` test is what's called a *functional test* - it tests a run of the entire program rather than the operation of individual components.  With a single functional test, we achieve 71% branch coverage.  In fact, if we designed this case more carefully, we might be able to get into the 80-100% range

Answer the following questions and put the answers in `submissions/hw4/P2.txt`

1) Explore your Cobertura site and find a branch (`for`/`if`) that has been 'covered' (a hit count of greater than zero on the left column near the line number) but is highlighted red.  What does this indicate?

2) Why are [Java interfaces](https://docs.oracle.com/javase/tutorial/java/concepts/interface.html) always marked with N/A for coverage? 

3) From a testing and debugging perspective, what is the disadvantage of a functional test like `testBasicFunctionality`?

4) Describe the relationship, if any, between the number of `if/else if/else` statements in a piece of code and the number of branches to be covered.


### Part 2) Fill in the test gap

Create a new JUnit test class in your `submissions/hw4` directory (follow the conventions described in the previous assignment about function names, etc). You may find it easier to use multiple class files.

* `submissions/hw4/src/test/java/edu/osu/blackjack/<YourTestSuiteName>Test.java` 

Write unit tests for all of the classes excluding `SimpleBlackjack` (i.e., do not use `SimpleBlackjack` at all) following your own intuition on what a good test suite might look like or using any technique we've done thus far.


### Part 3) 

**BEFORE ATTEMPTING THIS SECTION: Comment out all of the functions within `SimpleBlackjackTest` and `SimpleBlackjack` and uncomment your code from your test suite! Your tests must achieve the target WITHOUT using the SimpleBlackjack class, but you don't need to cover that class in the percentage calculation below**

Now measure the coverage of your test suit. If you have less than 75% line coverage, fill in the gaps and until you achieve it. Take a screenshot of your coverage and submit it as `submissions/hw4/P3.<jpg/pdf>`. 

### Part 4)

Answer the following questions and put the answers in `submissions/hw4/P4.txt`

1) True or False: A good test suite has good coverage

2) True or False: A suite with good coverage implies a good test suite

3) True or False: 100% Line/Statement Coverage implies 100% Branch Coverage. Justify your answer

4) True or False: 100% Branch Coverage implies 100% Line/Statement Coverage.  Justify your answer

5) True or False: 100% Branch Coverage implies 100% Path Coverage. Full path coverage implies that every possible execution path in the tested code is followed by at least one test.  Justify your answer

6) Describe in a paragraph or less how your intuitions for what consitutes a quality test suite aligned (or did not) with your initial coverage results in problem 3

7) Compare in a paragraph or less a test suite written only using input domain partitioning to a test suite written to optimize coverage metrics. 

## How to submit

Create a new branch of your repository called `hw4` containing your
final submission.  This branch must be created before the due date to
receive credit, the latest commit prior to the deadline will be graded.

## Submission checklist 

Make sure you've uncommented any tests in your new class before submitting, but leave the `SimpleBlackjackTest` commented out. Did you `git add`....

* At least one test suite class in `submissions/hw4/src/test/java/edu/osu/blackjack`
* `submissions/hw4/P2.txt`
* `submissions/hw4/P3.<jpg/pdf>`
* `submissions/hw4/P4.txt`


## Minimum passing guidelines

The following are guidelines for a basic submission that would receive a passing grade. Full credit may require significantly more effort and an otherwise perfect solution that omits one of these is not necessarily a guaranteed failure.

*  A test suite that compiles with `mvn compile`
*  Creation of the branch `hw4`
*  At least 60% coverage on your test suite excluding SimpleBlackjackTest
*  Answers to the written questions


