Data Structures hw3 readme
Lingyu An
la2659

To compile all files:

javac ExpressionTree.java
javac MyStack.java
javac Problem1.java
javac AvlTree.java
javac UnderFlowException.java
javac Problem2.java

To run:

java ExpressionTree
java MyStack
java Problem1
java AvlTree
java UnderFlowException
java Problem2 frank.txt (or whatever other txt you're using)

ExpressionTree:
Creates an expression tree based on a postfix expression.
Contains an expression node nested class and uses my Mystack class from hw2.
Methods included:
eval-	Evaluates the expression provided.
postFix-	Returns the postfix equivalent expression.
preFix-	Returns the prefix equivalent expression.
inFix-	Returns the infix equivalent expression.

MyStack:
From hw2
Stack class created with a linkedlist.
Contains methods pop, push, peek, getSize, and isEmpty.
All methods are created with list methods.

Problem1:
Test class for ExpressionTree.
Hardcoded with postfix expression 34 2 - 5 *
Evaluates expression and gives postfix, prefix, and infix equivalents from the four required methods.

AvlTree:
Based on avltree class provided, but with 4 added methods.
1. indexWord- 	Adds a new word or line number in the tree.
2. getLinesForWord-	Returns the list of line numbers in which a word occurs
3. printIndex-	Prints out the list of unique words in the AVL tree
4. findNode-	 A helper method that returns the node of a word

UnderFlowException:
Provided on courseworks.

Problem2:
Creates an instance of my AVL tree and uses it to index the words contained in a text file.
It then prints a list of unique words and the lines on which they appear.

