//************************************
// Lingyu An
// la2659
// Symbol Balance class
// Checks a file for unbalanced
// symbols, comments, and quotes
//************************************
import java.io.*;
import java.util.Stack;

public class SymbolBalance{
	
	public static void main(String args[]) throws IOException{
	
		MyStack<Character> stack= new MyStack();
		// to keep track of if we are in a comment
		boolean comment = false;
		// to keep track of if we are in quotes
		boolean quote = false;
		
		// take in file and read by line
		File inFile= new File(args[0]);
		BufferedReader in  = new BufferedReader(new FileReader(inFile));
		String line = in.readLine();
		
		while(line!=null){
	
			// for every char in the line
			for(int i=0; i<=line.length()-1; i++){
				char x = line.charAt(i);
				
				// beginning of a quote
				if(x=='"' && comment==false){
					if(quote==false){
						quote = true;
					}
					// end of a quote
					else
						quote = false;	
				}
				
				// if it reaches the end of the line without closing
				if(quote==true && i==line.length()-1){
					System.out.println("Unbalanced!"+'"'+"is mismatched");
					System.exit(0);
				}
			
				// no index out of bounds error
				if(i<line.length()-1){
					// beginning of a comment
					if(x=='/' && line.charAt(i+1)=='*'&&comment==false){
						comment = true;
						stack.push(x);
					}
					// end of comment
					if(x=='*'&& line.charAt(i+1)=='/'&&!stack.isEmpty()){
						comment = false;
						if(stack.peek()!='/')
							System.out.println("Unbalanced! */ is mismatched");
						stack.pop();
					}
				}
				
				// opening brackets and not in a comment or quotations
				if(x=='('||x=='{'||x=='['){
					if(quote==false && comment==false){
						stack.push(x);
					}
				}
				
				// closing bracket and not in a comment or quotations
				if(x==')' && quote==false && comment==false){
					if(stack.isEmpty()){
						System.out.println("You have an extra )");
						System.exit(0);
					}
					if(stack.peek()!='('){
						System.out.println("Unbalanced! ) is mismatched");
						System.exit(0);
					}
					stack.pop();
					
				}
				if(x=='}' && quote==false && comment==false){
					if(stack.isEmpty()){
						System.out.println("You have an extra }");
						System.exit(0);
					}
					if(stack.peek()!='{'){
						System.out.println("Unbalanced! } is mismatched");
						System.exit(0);
					}
					stack.pop();
				}
				
				if(x==']' && quote==false && comment==false){
					if(stack.isEmpty()){
						System.out.println("You have an extra ]");
						System.exit(0);
					}
					if(stack.peek()!='['){
						System.out.println("Unbalanced! ] is mismatched");
						System.exit(0);
					}
					stack.pop();
				}
				
			}
			// next line
			line = in.readLine();
		}
		in.close();
		
		// if stack is not empty at end of file
		if(!stack.isEmpty()){
			if(stack.peek()=='(')
				System.out.println("You are missing a )");
			if(stack.peek()=='{')
				System.out.println("You are missing a }");
			if(stack.peek()=='[')
				System.out.println("You are missing a ]");
			System.exit(0);
		}
		
		// if comment is not closed by end of file 
		if(comment==true){
			System.out.println("You are missing a */");
			System.exit(0);
		}
		// yay good job
		System.out.println("Your file is balanced!");
	}
}
	
