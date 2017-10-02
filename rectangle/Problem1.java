//************************************
// Lingyu An
// la2659
// Problem 1
// Returns largest rectangle
// in the array
//************************************

public class Problem1 {
	
	public static void main(String args[]){
		// new array with room for 6 rectangles
		Rectangle[] rectangles = new Rectangle[6];
		
		// 6 rectangles
		rectangles[0] = new Rectangle(5,10);
		rectangles[1] = new Rectangle(9,13);
		rectangles[2] = new Rectangle(12,11);
		rectangles[3] = new Rectangle(15,13);
		rectangles[4] = new Rectangle(10,4);
		rectangles[5] = new Rectangle(7,9);
		
		System.out.println("The dimensions of the largest rectangle are: " + 
				findMax(rectangles));
	}
	
	
	public static <AnyType extends Comparable<AnyType>>  AnyType findMax
		(AnyType[] arr) {
		  int maxIndex = 0;
		  for (int i = 1; i < arr.length; i++)
		    if ( arr[i].compareTo(arr[maxIndex]) > 0 )
		       maxIndex = i;
		    return arr[maxIndex];
		}

}
