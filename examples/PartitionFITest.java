package edu.osu.cs362;
import static org.junit.Assert.*;
import org.junit.Test;


public class PartitionFITest  {

    /*
 Interface-based approach.

 Develop characteristics directly from individual input parameters.
          Just use properties of the domains without considering the
          actual function under test

int abs(int x){
   if(x < 0) return -x;
   else      return  x;
}
       B_1       B_2
x      <0         >=0

       B_1       B_2    B_3 
x      <0        0      >0







Attempt #1)
              B_1      B_2     
arr           null     non-null
toFind        <=0        >1       

findInteger( null, 0 )
findInteger( null, 1 )
findInteger( ... (non-null), 0 )
findInteger( ... (non-null), 1 )


Attempt #2)
              B_1      B_2                     B_3
arr           null     non-null, length == 1   non-null, length > 1
toFind        <0       =0                      >=1                   




Functionality-based approach
 
    Develops characteristics from a behavioral view of the program under test
    Harder to develop—requires more design effort
    May result in better tests, or fewer tests that are as effective


Attempt #1

     B1 - arr = null, toFind = *
     B2 - arr = any array where toFind exists, toFind = *
     B3 - arr = any array where toFind does not exist, toFind = *

Attempt #2

     B1 - arr = null, toFind = *
     B2 - arr = any array where toFind exists, toFind = *
        B2_1 - arr = any array where toFind == arr[0], toFind = *
        B2_2 - arr = any array where toFind == arr[arr.length - 1], toFind = *
        B2_3 - arr = any array where toFind == arr[i], i!=0 && i!=(arr.length - 1), toFind = *
     B3 - arr = any array where toFind does not exist, toFind = *



Attempt #3


     B1 - arr = null, toFind = *
     B2 - arr = any array where toFind exists, toFind = *
        B2_1 - arr = any array where toFind == arr[0], toFind = *
            B2_1_1 - arr =  any array where toFind == arr[0], all are elements distinct 
            B2_2_1 - arr =  any array where toFind == arr[0], there are duplicates
        B2_2 - arr = any array where toFind == arr[arr.length - 1], toFind = *
        B2_3 - arr = any array where toFind == arr[i], i!=0 && i!=(arr.length - 1), toFind = *
     B3 - arr = any array where toFind does not exist, toFind = *
    */

    @Test
    public void testFindIntegerArrNull(){
	// B_1
	boolean hit = false;
	try{
	    WarmUp.findInteger(null, 27);
	}
	catch(NullPointerException e){
	    hit = true;
	}

	assertTrue("Expected an NullPointerException",hit);
    }
    






    @Test
    public void testFindIntegerToFindFirst(){
    //       B2_1_1 - arr =  any array where toFind == arr[0], all are elements distinct 
	int[] testArr = new int[10];
	for(int i=0;i<10;i++){
	    testArr[i] = i;
	}
	int result = WarmUp.findInteger(testArr,testArr[0]);
	assertEquals(0,result);
    }
    
    

    @Test
    public void testFindIntegerToFindFirstNonUnique(){
//       B2_2_1 - arr =  any array where toFind == arr[0], there are duplicates
	int[] testArr = new int[10];
	for(int i=0;i<10;i++){
	    testArr[i] = 0;
	}
	int result = WarmUp.findInteger(testArr,testArr[0]);
	assertEquals(0,result);
    }
    

    @Test
    public void testFindIntegerToFindLast(){
	//    B2_2 - arr = any array where toFind == arr[arr.length - 1], toFind = *
	int[] testArr = new int[10];
	for(int i=0;i<10;i++){
	    testArr[i] = i;
	}
	int result = WarmUp.findInteger(testArr,testArr[testArr.length-1]);
	assertEquals(testArr.length-1,result);
    }


    @Test
    public void testFindIntegerMiddle(){
	//    B2_2 - arr = any array where toFind == arr[arr.length - 1], toFind = *
	int[] testArr = new int[10];
	for(int i=0;i<10;i++){
	    testArr[i] = i;
	}
	int result = WarmUp.findInteger(testArr,testArr[3]);
	assertEquals(testArr.length-1,result);
    }

    
    @Test
    public void testFindIntegerNotExists(){
	// B3
	int[] testArr = new int[10];
	for(int i=0;i<10;i++){
	    testArr[i] = i;
	}
	int result = WarmUp.findInteger(testArr,47);
	assertEquals(-1,result);
    }
    

}
