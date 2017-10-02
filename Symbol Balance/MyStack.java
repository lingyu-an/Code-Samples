//************************************
// Lingyu An
// la2659
// My Stack class
// Stack created with linkedlist
// 
//************************************
import java.util.LinkedList;
import java.util.List;

public class MyStack<AnyType> {
	
	private LinkedList <AnyType>list;
	
	public MyStack(){
		list = new LinkedList<>();
	}
	
	public void push(AnyType x){
		list.addFirst(x);
	}
	public AnyType pop(){
		AnyType first = list.getFirst();
		list.removeFirst();
		return first;
	}
	public AnyType peek(){
		return list.getFirst();
	}
	
	public int getSize(){
		return list.size();
	}
	
	public boolean isEmpty(){
		if(list.size()==0)
			return true;
		else
			return false;
	}

}
