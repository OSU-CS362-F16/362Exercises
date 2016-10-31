# Assignment 6: Random Testing

## Preliminaries

* Get the latest files from the instructor's repository
~~~
    git remote add upstream "https://github.com/OSU-CS362-F16/362Exercises"
    git checkout master              # make sure we're on the master branch
    git fetch upstream             # pull any information about changes in upstream
    git merge upstream/master -m "Sync" # merge new files
~~~
* Remember to submit under a new branch called hw6
* You'll be making some improvements on your HW5 code this week.  Copy

1. `submissions/hw5/src/main/edu/osu/blackjack/*` to `submissions/hw6/src/main/edu/osu/blackjack/*`.  
2. `submissions/hw5/src/test/edu/osu/blackjack/*` to `submissions/hw6/src/test/edu/osu/blackjack/*`.  

`git add`the copied files and then commit to your local repository

* You may find it useful to comment out your Blackjack test cases -
  you are only required to submit tests described in this assignment.

## Useful links

[Java `Collections` reference](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html
http://blog.regehr.org/archives/856)

### Useful Java library routines

```
Collections.shuffle(...) // shuffles a Java collection in a random order
Collections.sort(...) // sorts a Java collection

Random r = new Random(); // create a new Random number generator
r.nextInt();             // generate a random integer
```

## Overview

Writing tests is time consuming and it is impossible to anticipate the
behavior of every possible input.  Random testing allows testers to
automatically generate test cases and check the result using an "Oracle".

## Part 1) Random testing a sort implementation

### Testing with an Oracle

If we have a known-good implementation of the system to be tested, the
simplest way to implement a random testing oracle is via comparison.

1. Using the Java Collections library or your own sorting routine,
complete the `isSorted` method within
`src/test/java/edu/osu/sort/SortOracle.java`.  This method should
sort the `original` parameter with the known-good sorting
implementation and then compare the result to `sorted`

2. Complete the method `SortTest.randomTestOracle` in the `SortTest`
class.  You should generate 100 random tests against `Sort.sort` with
randomly generated `List`s. Each list should be of random size between
0 and 1000 and each element should be a random Java integer. Assert
that the list is sorted by calling the `SortOracle.isSorted` method.

### Testing with Assertions

In the absence of a reference implementation, it is possible to test
the output of a random test against assertions.  For example, we might
test that...

* ... the list contains the same number of elements before and after the sort
* ... index 8, if it exists, should be less than than index 10, if it exists
* ... the last element is the largest in the array

Complete the method `SortTest.randomTestAssertion` in the `SortTest`
class by writing 5 different assertions against the (presumably)
sorted list.

## Part 2) Random testing SimpleBlackjack.playRound()

Now write a random tester for the SimpleBlackjack.playRound method.
 This is more complicated than the sorting task, because we must
 consider a random state of all of the possible data variables within
 each `DealerAction` and `PlayerAction` implementation.  

For this section, you are to write a test class in
 `submissions/hw6/src/test/edu/osu/blackjack` that implements a random
 tester. You should generate a valid random state at the beginning of
 a round of Blackjack and then and test playRound (via assertions). A
 valid random state includes

* A dealer with a random `deck` and an empty `dealerHand`
* 1-4 players each with a random `currentWallet` and an empty `currentHand`

You are free to modify the source code of the Blackjack classes as you
wish. If you make assumpetions or constraints on the creation of the random 
test cases, document them in the comments of your test class.

## How to submit


Create a new branch of your repository called hw6 containing your final submission. This branch must be created before the due date to receive credit, the latest commit prior to the deadline will be graded.
## Submission checklist 

Did you `git add`

* `submissions/hw6/src/test/java/edu/osu/sort/SortOracle.java`
* `submissions/hw6/src/test/java/edu/osu/sort/SortTest.java`
* At least one test class for `SimpleBlackjack` in `submissions/hw6/src/test/edu/osu/blackjack`
* Any modifications to files in `submissions/hw6/src/main/*``

Please also submit a link to your new branch via Canvas in the
Assignments section and make sure your code compiles via `mvn
compile`. Test failures in `mvn test` are acceptable so long as the
code itself compiles unless stated otherwise above.

## Minimum passing guidelines

The following are guidelines for a basic submission that would receive a passing grade. Full credit may require significantly more effort and an otherwise perfect solution that omits one of these is not necessarily a guaranteed failure.

*  Creation of the branch `hw6`
*  A random tester for Sort
*  A random tester for SimpleBlackjack






