package edu.osu.sort;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class SortTest  {

    static Random r = new Random();

    private static List<Integer> randomIntegerArray(int n){
	List<Integer> nl = new ArrayList<Integer>(n);
	for(int i=0;i<n;i++){
	    nl.add(r.nextInt());
	}

	return nl;
    }

    @Test // This test is an example template using an oracle
    public void randomTestExample() {
	int n_runs = 10;
	for(int i=0;i<n_runs;i++){
	    
	    // Generate a random array of size 10
	    List<Integer> sorted = randomIntegerArray(10);

	    // Copy the sorted array before sorting it 
	    List<Integer> original = new ArrayList(sorted);

	    // Sort it
	    Sort.sort(sorted);

	    // Test the result 
	    assertTrue(SortOracle.isSorted(original,sorted));
	}
    }
    

    @Test
    public void randomTestOracle() {    

    }

    @Test
    public void randomTestAssertion() {    


    }
}
