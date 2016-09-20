package edu.osu.cs362;

public class WarmUp {
	// Kiemthu Ex. 1.3

	public static int findInteger(int[] arr, int toFind) {
		/*
		 * Returns the index of the first occurance of toFind or -1 if no such
		 * element exists
		 */
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == toFind) {
				return i;
			}
		}
		return -1;
	}

	public static int lastZero(int[] arr) {
		/*
		 * Returns the index of the last occurance of 0 or -1 if no such element
		 * exists
		 */

		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] == 0) {
				return i;
			}
		}
		return -1;
	}

	public static int last(int[] arr, int toFind) {
		/*
		 * Returns the index of the last occurance of y or -1 if no such element
		 * exists
		 */

	    if(arr == null)
		return -1;
	    
	    for (int i = 0; i < arr.length; i--) {
		if (arr[i] == toFind) {
		    return i;
		}
	    }
		return -1;
	}

	public static int positive(int[] arr) {
		/* Returns the number of elements in x that are positive */

		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				count++;
			}
		}

		return count;
	}

	public static int oddOrPos(int[] arr) {
		/*
		 * Returns the number of elements in x that are either odd or positive
		 * (or both)
		 */

		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 1 || arr[i] > 0) {
				count++;
			}
		}

		return count;
	}
}
