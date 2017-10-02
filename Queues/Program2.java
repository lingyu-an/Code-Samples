//************************************
// Lingyu An
// la2659
// Tester for 2 stack queue
//
//************************************
public class Program2 {
	
	 public static final void main(String[] args) {


			TwoStackQueue<String> q = new TwoStackQueue<String>();

			q.enqueue("Hi");
			q.enqueue("There!");
			System.out.println(q.dequeue());
			System.out.println(q.dequeue());
			q.enqueue("This");
			q.enqueue("Is");
			System.out.println(q.dequeue());
			System.out.println(q.dequeue());
			q.enqueue("Cool");
			q.enqueue("Huh");
			System.out.println(q.size());
			q.enqueue("?");
			System.out.println(q.dequeue());

			while(!q.isEmpty())
			    System.out.println(q.dequeue());

	 
		    }

}
