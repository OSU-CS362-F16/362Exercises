package edu.osu.stupidsort;

import java.util.*;

public class StupidSort{
    public static void stupidSort(List<Integer> li){
	/* stupidSort sorts a list of integers (ascending)
	 * in the silliest way possible
	 */
	stupidSortAux(li,0,li.size());
    }
   

    static void stupidSortAux(List<Integer> li,int low, int hi){
	
	if(hi-low<=3){
	    // Sort the entire list using Java's internal sorting algorithm
	    Collections.sort(li);
	    return;
	}

	int mid = (low+hi)/2;
	// sorts a subsequence within li
	Collections.sort(li.subList(0,mid));	

	stupidSortAux(li,mid,hi);

	Collections.sort(li.subList(0,hi));	
    }
}
