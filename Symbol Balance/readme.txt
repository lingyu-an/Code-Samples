Lingyu An
la2659
HW2

To compile all files:

javac Myqueue.java
javac MyStack.java
javac Program2.java
javac TwoStackQueue.java
javac Test.java
javac SymbolBalance.java

To run:

java Myqueue
java MyStack
java Program2
java TwoStackQueue
java Test
java SymbolBalance

MyQueue:
This is the interface provided on courseworks.

MyStack:
Stack class created with a linkedlist.
Contains methods pop, push, peek, getSize, and isEmpty.
All methods are created with list methods.

Program2:
Test class for TwoStackQueue that prints

Hi
There!
This
Is
2
Cool
Huh
?

TwoStackQueue:
Queue made with 2 stacks (myStacks)
Enqueue pushs an object onto stack 1.
Dequeue transfers all objects in stack 1 into stack 2 if stack 2 is empty.
The top of stack 2 is then popped and returned.
If stack 2 is not empty, it just pops the top object.

Also included are methods isEmpty which returns whether the queue is empty or not
and size(), which returns the size.

Test:
Test class for SymbolBalance.
Has an extra }

SymbolBalance:

Takes in a file and checks whether the brackets, quotation marks, and comment markers are balanced.

The first things that are checked for are comments and quotations, since brackets could appear inside of these.
Two booleans keep track of whether we are in a comment or between quotation marks.
If we are, brackets are ignored.
Otherwise, they are pushed into the myStack stack and popped when the corresponding bracket is encountered.
If the algorithm makes it past all of the checks, the file is balanced.