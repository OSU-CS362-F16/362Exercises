
- Consider the permute function.  

The intention of this code was to provide a way to shuffle the
deck. It asks the caller to provide a random permutation of the
indicies of the cards. This permutation is generated elsewhere in the
code, but we still need to unit test this method.

-- *Written problem A:* Describe at least 2 assertions of behavior that should never occur when we shuffle a real life card deck.  For example, if I shuffle a deck with at least one card, the deck should not be empty
-- *Written problem B:* Briefly document how this code attempts to 'shuffle' the CardCollection given a permutation
-- *Written problem C:* Describe the sets of input parameters under which this function  
  -- throws an Exception
  -- does not throw an Exception but violates how the deck should be if we are 
  -- operates correctly.

Write a test suite containing between 5 and 10 tests