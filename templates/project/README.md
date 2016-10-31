# CS362 Term Project 

## Overview 

The class project will require you to apply the tools and techniques
taught throughout the course to a codebase of your choice.  You will
be testing one of the following:

<ol type="a">
  <li>A buggy version of the <a href="http://commons.apache.org/proper/commons-validator/apidocs/org/apache/commons/validator/UrlValidator.html">Apache URLValidator</a>. The source can be found <a href="http://web.engr.oregonstate.edu/~baldwdav/BuggyURLValidator.zip">here</a></li>
  <li>An open-source project of your choice (including code/projects
written by at least one team member) with at least 1000 lines of code.</li>
  
</ol>


You may use any language you wish for b), but if you do not use
Java, you are responsible for finding replacements for the tools we
have covered in class.

## Milestones

***Please see the Due Dates section of Canvas for actual deadline dates***

### Project Proposal and Groups

The project will be done is groups of exactly 4 students. You are
responsible for coordinating groups and submitting a project proposal
for approval. If you are unable to form a group of 4, you will receive
credit for your project proposal, but your team may be merged with
other teams, split, etc. and you are responsible for choosing a single
proposal for the team.

Each team should create a new Github repository using the following steps. ***Form a team before attempting this process - the process cannot be repeated***

1. One person from each team should visit the [following Github link](https://classroom.github.com/group-assignment-invitations/319b5fd01dc933c2179dda2a6608999f) and create a new team using their ONID name
2. All team members should follow the link and join the team created by the first member.

If all goes well, you should end up with a new repository accessible by all team members.  If you make a mistake, you'll have to manually add each member to the team or repository via Github.

The project proposal should be submitted in Canvas as a link to your repository. The repository should consist of the a `README.md` containing the following information and code from the project. Guidelines:

* **All members' names at the top of the file**

* For option a) - add the files provided on Canvas to your repository

* For option b) - please include a link to the project's homepage (if
  available) and add a copy of the code to be tested to your repository


### Project Report Part I

Write a test plan for your chosen codebase evaluating

* The current test coverage, if any
* Areas in which the tests could be improved using the tools and techniques described in class
* A plan for implementing those improvements
* At least one additional tool/method you plan on using not utilized in the assignments.  Suggestions (and links to implementations in Java) include:
 * [Mutation testing](http://pitest.org/)
 * [Static analysis](http://findbugs.sourceforge.net/)
 * [HTMLUnit (for web interfaces)](http://htmlunit.sourceforge.net/)
 * [UISpec4J (for desktop UI testing)](https://github.com/UISpec4J/UISpec4J)

Your test plan should be at least 1 page (250 words) but no more
than 3 (750 words).  Check your plan in to your repository as `PLAN.(md/pdf)` and also submit the plan via Canvas.

### Project Report Part II

Implement the improvements described above. Submit your code and write
a test report as a text or PDF file called `REPORT.(pdf/md)` describing your experiences. Guidelines:

* Your code must include a `README.md` file describing how to run your
 code and tests

* Describe the techniques you used and include snippets of relevant testing code 

* Bug reports for any issues you find in the code

* An evaluation of the new tool you used. Include a descripton of what the tool added to your test suites and a comparision to the techniques covered in the exercises.



Your test report should be at least 3 pages (750 words) but no more
than 6 (1500 words). Check your report in to your repository and also submit the report via Canvas.


## Grading

* 10% - Project proposal
* 30% - Project Report Part I
* 60% - Project Report Part II



