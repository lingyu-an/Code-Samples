Lingyu An
la2659
HW 1

To compile all files:

javac Rectangle.java
javac Problem1.java
javac Problem2.java
javac Problem3.java


To run:

(There should be no reason to run rectangle)
java Problem1
java Problem2
java Problem3


Rectangle class:
Other than the methods provided, I also created a getPerimeter method that returns the perimeter
and a toString method that returns the dimensions of the rectangle.

Problem 1:
I created an array of 6 rectangles and filled it with rectangles of various dimensions.
The findMax method provided returns the one with the largest perimeter.

Problem 2:
The array of rectangles is the same as Problem 1.
One of these is the rectangle will be the one we are searching for.

I created a helper method that takes in 4 variables- the array we are searching, the rectangle we are looking for, a start point, and an end point.
In the recursive search, there is a base case- if the start and end intersect, which means that the rectangle is not in the array.
The other cases are determined by the outcome of the comparison to the midpoint of the array.
If it is the same, it will return that location.
If it is greater than the mid, it will check the midpoint of the first half of the array.
If it is smaller than the mid, it will check the midpoint of the second half of the array.

Problem 3:
Explained in Problem3.txt
