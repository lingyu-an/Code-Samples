//************************************
// Lingyu An
// la2659
// Two Stack Queue
// A queue made from two stacks
//
//************************************
public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
	
	MyStack<AnyType> stack1;
	MyStack<AnyType> stack2;
	
	
	public TwoStackQueue(){
		stack1= new MyStack();
		stack2= new MyStack();
	}
	
	public void enqueue(AnyType x) {
		stack1.push(x);
	}

	public AnyType dequeue() {
		// if both stacks are empty, queue is empty
		if(this.stack1.isEmpty()&&this.stack2.isEmpty())
			return null;
		
		// if second stack is empty, move everything in the first stack over
		if(this.stack2.isEmpty()){
			while(!this.stack1.isEmpty()){
				this.stack2.push(this.stack1.pop());
			}
		}
		// return top of stack 2
		AnyType top = this.stack2.pop();
		return top;
	}

	public boolean isEmpty() {
		if(this.stack1.isEmpty()&&this.stack2.isEmpty())
			return true;
		else
			return false;
	}

	public int size() {
		int size = this.stack1.getSize()+this.stack2.getSize();
		return size;
	}

	
}
