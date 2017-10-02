//************************************
// Lingyu An
// la2659
// Rectangle class
// a rectangle with length, width, and
// perimeter
//************************************

public class Rectangle implements Comparable<Rectangle>{
	
	private int length;
	private int width;
	private int perimeter;
	
	public Rectangle(int l, int w){
		length = l;
		width = w;
		getPerimeter();	
	}
	
	
	public int getWidth(){
		return width;
	}

	public int getLength(){
		return length;
	}
	
	// method for getting perimeter
	public int getPerimeter(){
		perimeter = 2*length + 2*width;
		return perimeter;
	}
	
	// compareTo
	public int compareTo(Rectangle o){
		int x = 0;
		if(this.getPerimeter()> o.getPerimeter())
			x = 1;
		if(this.getPerimeter()== o.getPerimeter())
			x = 0;
		if(this.getPerimeter()< o.getPerimeter())
			x = -1;
		
		return x;
	}
	
	// toString to print dimensions
	public String toString(){
		String dimensions;
		dimensions = length + "x" + width;
		return dimensions;
		
	}
	
}
