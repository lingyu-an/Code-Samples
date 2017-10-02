Data Structures hw5 readme
Lingyu An
la2659

To compile all files:

javac Dijkstra.java
javac Display.java
javac Edge.java
javac Vertex.java

To run:

java Dijkstra
java Display

Display,Edge,Vertex classes:
Provided on courseworks, not modified.

Dijkstra:
Created the following methods:

computeEuclideanDistance- Computes Euclidian distance between 2 points

computeAllEuclideanDistances- Computes all Euclidian distances through an enhanced for loop

doDijkstra- Dijkstra's algorithm. made with a priority queue that stores a subclass I created. The sublclass is comparable so that it can be used with the priority queue and has 2 variables- vertex and cost of adding this vertex. Shortest path is updated when the cost of a vertex is lower than what it was before. Everything else is basically the same as going through dijkstra's on a table.



getDijkstraPath- returns a linked list of edges that compose the shortest path