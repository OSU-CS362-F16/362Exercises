package osu.example;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;

import java.util.*;


public class CollectionsTest
{
    
    protected Random r;


    @Rule
    public TestRule outputName = new TestWatcher() {
	protected void starting(Description description) {
	    System.out.println("Running: " + description.getMethodName());
	}
    };

    @Before
    public void initRandom(){
	long seed = System.currentTimeMillis();
	r = new Random(seed);
	System.out.printf("====CollectionTest seed: %d======\n",seed);
    }


    public List<Integer> generateRandomList(int length, int lbound, int ubound )
    {
	List<Integer> li = new ArrayList<Integer>();
	for(int i=0;i<length;i++){
	    int rv = generateRandomInt(lbound,ubound);
	    li.add(rv);
	}
	return li;
    }

    public int  generateRandomInt(int lbound, int ubound){
	return r.nextInt(ubound-lbound) + lbound;
    }

    final int N_RANDOM_TESTS = 100;
    final int N_ELEMENTS = 50;
    final int ELEMENT_UBOUND = 10000;


    public void checkAdd(int newVal, List<Integer> toTest){
	    // last element should be new value
	    assertEquals(newVal, toTest.get(toTest.size()-1).intValue());
	    assertEquals(toTest.size()-1, toTest.lastIndexOf(newVal));
	    assertEquals(newVal, toTest.toArray(new Integer[0])[toTest.size()-1].intValue());
    }

    
    @Test
    public void simpleListRandomTeat(){
	for(int i=0;i<N_RANDOM_TESTS;i++){
	    List<Integer> toTest = generateRandomList(N_ELEMENTS,0,ELEMENT_UBOUND);	    
	    int newVal = generateRandomInt(0,ELEMENT_UBOUND);

	    toTest.add(newVal);
	    
	    // Check some properties of the list
	    checkAdd(newVal,toTest);
	}
    }

    @Test
    public void simpleListRandomTeatWithLength(){
	for(int i=0;i<N_RANDOM_TESTS;i++){
	    List<Integer> toTest = generateRandomList(generateRandomInt(0,1000),0,ELEMENT_UBOUND);	    
	    int newVal = generateRandomInt(0,ELEMENT_UBOUND);

	    toTest.add(newVal);
	    
	    // Check some properties of the list
	    checkAdd(newVal,toTest);
	}
    }

    @Test
    public void randomAddRemoveTest(){
	for(int i=0;i<N_RANDOM_TESTS;i++){
	    List<Integer> toTest = generateRandomList(generateRandomInt(0,1000),0,ELEMENT_UBOUND);

	    randomAddRemoveSeq(toTest,1000);
	}
    }


    public void randomAddRemoveSeq(List<Integer> li, int noMethods){

	for(int mn=0;mn<noMethods;mn++){
	    int methodno =  generateRandomInt(0,2);
	    switch(methodno){
	    case 0:
		int newVal = generateRandomInt(0,ELEMENT_UBOUND);
		li.add(newVal);
		break;
	    case 1:
		int currentSize = li.size();
		try{
		    li.remove(0); //remove the first 
		    assertTrue(currentSize>0); // if currentSize==0, this should have thrown Exception
		}
		catch(IndexOutOfBoundsException e){
		    assertTrue(currentSize==0); 
		}
		break;
	    }
	
	}
    }

}
