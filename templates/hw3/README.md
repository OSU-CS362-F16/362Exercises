# Assignment 3

## Preliminaries

* Get the latest files from the instructor's repository by running the `bin/sync` script
* Remember to submit under a new branch called `hw3`

## Useful links

[Cobertura homepage](http://cobertura.github.io/cobertura/)

[Cobertura Maven reference](https://github.com/OSU-CS362-F16/362Exercises/edit/inprogress/templates/hw3/README.md)

## Overview

You've successfully survived your first week on the Blackjack team and now you've been asked to prepare a 30-page [TPS Report](https://www.youtube.com/watch?v=Fy3rjQGc6lA) on the current state of the test suite.  Unfortunately, it looks like the current code base has two very small tests.  Instinctively, you know that these two tests are probably not sufficent, but you decide to do a bit more research to see how bad the problem really is.

In this assignment, we'll look at using a code coverage tool to measure the quality of the existing test suite and then explore where these metrics are useful (and where they are not). The `submissions/hw3` folder contains a new `pom.xml` that will pull down some new dependencies when you `mvn compile`.  In particular, you'll get a new library containing a tool called Cobertura.

### Part 1) Fill in the test gap

Create a new JUnit test class in your `submissions/hw3` directory (follow the conventions described in the previous assignment about function names, etc):

* `submissions/hw3/src/test/java/edu/osu/blackjack/BlackjackTest.java `

Write unit tests for all of the classes excluding `SimpleBlackjack` (i.e., do not use `SimpleBlackjack` at all) following your own intuition on what a good test suite might look like.  

## Part 2) Code Coverage using Cobertura

**BEFORE ATTEMPTING THIS SECIION: Comment out all of the functions you just wrote within BlackjackTest!**

Run the following command 

`mvn cobertura:cobertura`

This should generate a set of files in the `submissions/hw3/target/site` folder including an `index.html` file.  Open this file with a web browser.  If you are SSH'd into a server without X11 (user interface) forwarding, you may want to use the `deploy` script in the the `submissions/hw3` folder to copy the site to your EECS webspace.

Your coverage report should be similar to this:
![](https://snag.gy/C3He0V.jpg)

The `testBasicFunctionality` test is what's called a *functional test* - it tests a run of the entire program rather than the operation of individual components.  With a single functional test, we achieve 71% branch coverage.  In fact, if we designed this case more carefully, we might be able to get into the 80-100% range

Answer the following questions and put the answers in `submissions/hw3/P2.txt`

1) Explore your Cobertura site and find a branch (`for`/`if`) that has been 'covered' (a hit count of greater than zero on the left column near the line number) but is highlighted red.  What does this indicate?

2) Why are Java interfaces always marked with N/A for coverage?

3) From a debugging perspective, what is the disadvantage of a functional test like `testBasicFunctionality`?


### Part 3) 

**BEFORE ATTEMPTING THIS SECTION: Comment out all of the functions within `SimpleBlackjackTest` and uncomment your code from `BlackjackTest`! Your tests must achieve the target WITHOUT using the SimpleBlackjack class**

Now measure the coverage of your code. If you have less than 80% line coverage, fill in the gaps and until you achieve it. Take a screenshot of your coverage and submit it as `submissions/hw3/P3.<jpg/pdf>`. 

### Part 4)
Answer the following questions and put the answers in `submissions/hw3/P4.txt`

1) True or False: A good test suite has good coverage

2) True or False: A suite with good coverage implies a good test suite

3) True or False: 100% Line/Statement Coverage implies 100% Branch Coverage

4) True or False: 100% Branch Coverage implies 100% Line/Statement Coverage

5) Describe how you intuitions for what consitutes a quality test suite aligned (or did not) with your initial coverage results in problem 3

## Submission checklist 

Make sure you've uncommented any tests in the `BlackjackTest` class before submitting and you've done `git add` on

* `submissions/hw3/src/test/java/edu/osu/blackjack/BlackjackTest.java`
* `submissions/hw3/P2.txt`
* `submissions/hw3/P3.<jpg/pdf>`
* `submissions/hw3/P4.txt`

Don't forget to `git commit` and `git push origin master`

## How to submit

Create a new branch of your repository called `hw3` containing your
final submission.  This branch must be created before the due date to
receive credit, the latest commit prior to the deadline will be graded.


