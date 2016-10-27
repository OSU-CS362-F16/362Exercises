package edu.osu.sort;

import java.util.*;


public class Sort{
    public static void sort(List<Integer> li){
	/*
	   Sorts a list in ascending order in-place
	   
	   @param li A list of integers
	 */
	
	for(int i=0; i < li.size(); i++){
	    for(int j=1; j < (li.size()-i); j++){
		if(li.get(j-1) > li.get(j)){
		    Collections.swap(li,j-1,j);
		}
	    }
	}
    }

}
