# Assignment 5

## Preliminaries

* Get the latest files from the instructor's repository
~~~
    git remote add upstream "https://github.com/OSU-CS362-F16/362Exercises"
    git checkout master              # make sure we're on the master branch
    git fetch upstream             # pull any information about changes in upstream
    git merge upstream/master -m "Sync" # merge new files
~~~
* Remember to submit under a new branch called hw5
* You'll be making some improvements on your HW4 code this week.  Copy
the entire contents `submissions/hw4` to `submissions/hw5` **EXCLUDING pom.xml**.  `git add`
the copied files and then commit to your local repository


## Useful links

[Unit tests with Mockito - Tutorial (Sections 1-4)](http://www.vogella.com/tutorials/Mockito/article.html)

[Mockito Reference](http://site.mockito.org/mockito/docs/current/org/mockito/Mockito.html)

[Blackjack Rules Reference] (https://en.wikipedia.org/wiki/Blackjack#Rules_of_play_at_casinos)
## Overview

During the course of evaluating the test suite of the Blackjack
classes, you have found several bugs and have been tasked with documenting
them.  The original author of the code left little detail as to how
they developed the code, so your team has decided to use [the following
document]
(https://en.wikipedia.org/wiki/Blackjack#Rules_of_play_at_casinos) as
a reference to get the code working.


## Part 1) Mocking 

The `SimpleBlackjack` class implements a single round of Blackjack.
Because this class is dependent on the rest of the code base, it is
difficult to test this class in isolation.  It is not possible to
execute this class without providing an implementation of the Dealer
and at least one player.  Much of the logic of the game is centered in
this class - dealing, betting, etc. - and it may be difficult to
distinguish between errors in more granular classes (like the ones you
tested last week) and errors in SimpleBlack itself.

Mocking solves this problem.  Instead of providing Player and Dealer
implementations, we'll use a tool called Mockito to provide mock
objects for this class.  An example is provided in `hw5/src/test/java/edu/osu/blackjack/MockExample.java`

Write at least 5 mock tests for `SimpleBlackjack` in the test class of your choice 

## Part 2) Writing a bug report

Follow the guidelines from the readings to find and write reports for
three bugs in the Blackjack game. In addition to those guidelines, be sure to include

* ... a detailed description of the issue
* ... how the issue affects the functinnality of the game
* ... a snippet of a test case that fails
* ... justification for why that test case should pass

Your bug reports should be based on the functionality needed to implement the game as described in the Blackjack reference document. At least one bug must be from the SimpleBlackjack class. 

Submit your reports as
`submissions/hw5/report1.txt`, `submissions/hw5/report2.txt` and
`submissions/hw5/report3.txt`


## Part 3) Making the fixes

Alter the Java source files in `submissions/hw5/src/java/...` to correct the bugs in each of your reports. Modify each of your bug reports to include a code snippet of the change you made and a description of the change that you might put in a Git commit message.

As a final step, move any test cases used in the snippets to a new class called `VerifiedTest` in `submissions/hw5/src/test/.../VerifiedTest.java`.  ***All tests in your snippets must be added to `VerifiedTest`.  ALL tests in `VerifiedTest` must pass without error or failure***

## How to submit

Create a new branch of your repository called `hw5` containing your
final submission.  This branch must be created before the due date to
receive credit, the latest commit prior to the deadline will be graded.

## Submission checklist 

Did you `git add`

* `submissions/hw5/report1.txt`
* `submissions/hw5/report2.txt`
* `submissions/hw5/report3.txt`
* `submissions/hw5/src/test/.../VerifiedTest.java`
*  At least one test class utilizing Mockito tests
*  The modified source code in `submissions/hw5/src/main`

Please also submit a link to your new branch via Canvas in the Assignments section.

## Minimum passing guidelines

The following are guidelines for a basic submission that would receive a passing grade. Full credit may require significantly more effort and an otherwise perfect solution that omits one of these is not necessarily a guaranteed failure.

*  Code that compiles and runs using `mvn compile test`
*  Creation of the branch `hw5`
*  At least 3 bug reports with test and modification snippets
*  At least 5 mock tests





