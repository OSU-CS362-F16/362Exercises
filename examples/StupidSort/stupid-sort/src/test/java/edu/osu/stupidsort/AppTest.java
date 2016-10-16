package edu.osu.stupidsort;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class AppTest  {



    private static List<Integer> identityPermutation(int n){
	List<Integer> nl = new ArrayList<Integer>(n);
	for(int i=0;i<n;i++){
	    if(i%10000==0) System.out.printf("%d\n",i);
	    nl.add(i);
	}

	return nl;
    }

    private boolean isIdentityPermutation(List<Integer> li){
	for(int i=0;i<li.size();i++){
	    if(li.get(i) != i)
		return false;
	}
	return true;
    }

    @Test
    public void stupidSortSample() {
	List<Integer> li = identityPermutation(10);

	// get a random shuffling of the identity permutation
	Collections.shuffle(li); 
	// stupidsort it 
	StupidSort.stupidSort(li);

	// check if the sorted list is back to the identity permutation
	assertTrue(isIdentityPermutation(li));
    }
    

    @Test
    public void stupidSortSample2() {
	List<Integer> li = identityPermutation(Integer.MAX_VALUE/2 +100000);

	// get a random shuffling of the identity permutation
	Collections.shuffle(li); 

	/* We can test the internal (package protected) auxillary
	   recursive method here.  Note that external packages would
	   **NOT** be able to call this method, so if we find a bug or
	   exception when calling this function, we need to argue that
	   we could make a call to stupidSort that provides similar
	   arguments
	*/

	StupidSort.stupidSortAux(li,0,li.size());

	// check if the sorted list is back to the identity permutation
	assertTrue(isIdentityPermutation(li));
    }
    

}
