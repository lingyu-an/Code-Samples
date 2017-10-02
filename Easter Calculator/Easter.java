/* Lingyu An
 * la2659
 * EasterSundayCalculator.java
 */
import java.util.Scanner;

public class Easter
{
	public static void main(String[] args)
	{
		//Get year from user
		Scanner year = new Scanner(System.in);
		System.out.print("Please enter a year to calculate the date of Easter:");
		int y= year.nextInt() ;
		
		//Do calculations
		int	a = y % 19,
			b = y / 100,
	        c = y % 100,
	        d = b / 4,
	        e = b % 4,
	        g = (8 * b + 13) / 25,
		    h = (19 * a + b - d - g + 15) % 30,
	        j = c / 4,
	        k = c % 4,
	        m = (a + 11 * h) / 319,
		    r = (2 * e + 2 * j - k - h + m + 32) % 7,
	        n = (h - m + r + 90) / 25,
            p = (h - m + r + n + 19) % 32;
		
		 //Print results
		 System.out.println("");
		 System.out.println("Easter will be on " + n + "/" + p +" in " + y);
				
 	}// end main method
	

}// end class