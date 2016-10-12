
# Assignment 3: Input Domain Partitioning

## Preliminaries

* Completion of this assignment is not required, but it may help you on HW3
* You may turn in the written sections of Part II for extra credit
* You'll be making some improvements on your HW2 code this week.  Copy
the entire contents `submissions/hw2` to `submissions/hw3`.  `git add`
the copied files and then commit to your local repository

## Part I

Re-evaluate your test cases for `lastZero `and answer the following questions in `submissions/hw3/P1.txt`

1. Correct the bug in `lastZero` within `Warmup.java`

2. Is it possible to organize each of your test case functions into disjoint partitions? If so, describe 
your partitioning scheme, making note of which test functions correspond to which partition.  If not, come up with a new disjoint partitioning scheme, describe it and modify your `WarmupTest.java` tests to reflect your new scheme.  

3. Describe the advantage of having input disjoint test cases



## Part II

Consider the `CardCollection.discardCard` function. The function should remove the element at index `handPos` and leave the relative order of all other cards the same. Input domain partitioning is traditionally applied to stateless functions, but we can generalize it to a stateful object.  When working with stateful objects, the behavior of a function is dependent on not only the function interface, but the state of the object itself.  `discardCard` is dependent on not only the parameter `handPos`, but the state of the deck held in `CardCollection.cards`. Consider the following partitioning 

| Partition | CardCollection.cards | handPos |  
|---|---|---|
|  b<sub>0</sub>  |  empty | 0  |
|  b<sub>1</sub>  | Card.newDeck() | 0  |
|  b<sub>2</sub> | Card.newDeck()  | cards.size()-1  |
| b<sub>3</sub>  |  Card.newDeck() | 0&lt;x&lt;cards.size()-1  |
|  b<sub>4</sub>  | Card.newDeck()*2  |  0 | 
|  b<sub>5</sub> | Card.newDeck()*2  | cards.size()-1  | 
| b<sub>6</sub>  | Card.newDeck()*2  | 0&lt;x&lt;cards.size()-1 | 

<sub>
`Card.newDeck()` returns a new 52 card deck, above it indicates a CardCollection with a full deck. `Card.newDeck()*2` indicates a CardCollection containing two full decks.  See the example below for an example of code that builds a CardCollection from a `Card.newDeck()`
</sub>

Answer the following questions in `submissions/hw3/P2.txt`

1. 

    * Why don't we need to consider a partition where CardCollection.cards is `null`?         
    * Do we consider every possible state of `CardCollection.cards` in at least one partition?
    * Do we consider every possible value of `handPos` in at least one partition?
    * Is this partitioning complete? In other words, does the partitioning above consider every possible combination of CardCollection.cards and handPos?  

2.  The current implementation (given in HW2 and unchanged here) fails for at least one of these partitions. Find at least one partition where this fails and identify the bug if you haven't already.  It is recommended you implement tests for each, but you are not required to submit them.

3.  Suppose we have a CardCollection  `cc` consisting of 2, 52-card decks (`Card.newDeck()*2`) and we produce a test like the one below
~~~
    
    public void testCardRemoveFromMiddle(int i){
        CardCollection c = new CardCollection();
        ArrayList<Card> comparison = Card.newDeck(); // Keep track of the ordering of a new deck
        c.add(Card.newDeck()); // Add a new deck 
        c.add(Card.newDeck()); // Add another new deck 
        
        c.discardCard(i);  // remove ith card
        assertEquals(comparison.get(0),c.getCards().get(0)); // first element shouldn't change
    }
  
    @Test public void testCardRemoveFromMiddle(){
       testCardRemoveFromMiddle(1);
       testCardRemoveFromMiddle(2);
    }
~~~ 
that succeeds on ` testCardRemoveFromMiddle(1)` but fails on `testCardRemoveFromMiddle(2)` - what does this say about partition  b<sub>6</sub>?





## What to submit

Did you `git add`

<!--
* All of the files you copied from `submissions/hw2` to submissions/hw3`
* Modified `WarmupTest.java`
* Written answers from part 1) in `submissions/hw3/P1.txt`
-->
* Written answers from part 2) in `submissions/hw3/P2.txt`


## How to submit

Create a new branch of your repository called `hw3` containing your
final submission.  This branch must be created and pushed to GitHub `git push origin hw3` before the due date to
receive credit.
