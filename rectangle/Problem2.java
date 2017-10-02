//************************************
// Lingyu An
// la2659
// Problem 2
// Searches an array of rectangles for
// one with the same perimeter
//************************************

import java.util.Arrays;

public class Problem2 {
	
	public static void main(String args[]){
		// new array with room for 6 rectangles
		Rectangle[] rectangles = new Rectangle[6];
		
		// the rectangle we will be searching for
		Rectangle r = new Rectangle(12,11);
		
		// 6 rectangles for the array
		rectangles[0] = new Rectangle(5,10);
		rectangles[1] = new Rectangle(9,13);
		rectangles[2] = r;
		rectangles[3] = new Rectangle(15,13);
		rectangles[4] = new Rectangle(10,4);
		rectangles[5] = new Rectangle(7,9);
		
		// sort for binary search
		Arrays.sort(rectangles);
		
		
		System.out.println(Arrays.toString(rectangles));
		
		System.out.print
		("The rectangle you are searching for is located at index position: ");
		System.out.print(binarySearch(rectangles, r));
		
		
	}
	
	// method provided
	public static <AnyType extends Comparable<AnyType>> int binarySearch
	(AnyType[] a, AnyType x) {
		return helper(a, x, 0, a.length-1);
	}
	
	// helper method
	private static <AnyType extends Comparable<AnyType>> int helper
	(AnyType[] a, AnyType x, int start, int end) {
		
		// base case
		if(start>end)
			return -1;
		
		// variable to keep track of mid
		int mid = (start + end) / 2;
		
		// if the mid matches
		if(a[mid].compareTo(x)==0)
			return mid;
			
		// if it is smaller than mid, search the first half of the array
		if(a[mid].compareTo(x)==1)
			return helper(a, x, 0, mid-1);
		
		// if it is greater than mid, search the second half of the array
		else
			return helper(a, x, mid+1, end);
	}
}
