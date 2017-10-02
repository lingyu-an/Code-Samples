//************************************
// Lingyu An
// la2659
// Problem 3
// Tests run times of 3 different
// algorithms
//************************************
public class Problem3 {

	public static void main(String args[]){
		
		// Values to test
		int[] valuesA = new int[]{10,10,10,100,1000,10000,100000,1000000,
				10000000};
		
		int[] valuesB = new int[]{10,10,10,100,1000,10000,100000,1000000};
		
		int[] valuesC = new int[]{10,10,10,100,1000,10000,100000,1000000,
				10000000};
		
		// Snippet A
		for(int x=0; x<valuesA.length-1; x++){
			long starTime = System.nanoTime();
			snippetA(valuesA[x]);
			//System.out.println(snippetA(valuesA[x]));
			long endTime = System.nanoTime();
			System.out.println(endTime-starTime);
			}
		
		// Snippet B
		for(int x=0; x<valuesB.length-1; x++){
			long starTime = System.nanoTime();
			snippetB(valuesB[x]);
			//System.out.println(snippetB(valuesB[x]));
			long endTime = System.nanoTime();
			System.out.println(endTime-starTime);
			}
		
		// Snippet C
		for(int x=0; x<valuesC.length-1; x++){
			long starTime = System.nanoTime();
			foo(valuesC[x],2);
			//System.out.println(foo(valuesC[x],2));
			long endTime = System.nanoTime();
			System.out.println(endTime-starTime);
			}
	}
	
	// Snippet A
	public static int snippetA(int n){
	int sum = 0;
	for ( int i = 0; i < 23; i ++)
	    for ( int j = 0; j < n ; j ++)
	        sum = sum + 1;
	return sum;
	}
	
	// Snippet B
	public static int snippetB(int n){
	int sum = 0;
	for ( int i = 0; i < n ; i ++)
	    for ( int k = i ; k < n ; k ++)
	        sum = sum + 1;
	return sum;
	}
	
	// Snippet C
	public static int foo(int n, int k) {
	    if(n<=k)
	        return 1;
	    else
	        return foo(n/k,k) + 1;
	}

}
