//************************************
// Lingyu An
// la2659
// Expression tree class
// Postfix based
// 
//************************************
import java.util.Scanner;

public class ExpressionTree {
	
	// Expression node nested class
    private class ExpressionNode {

        public String data;
        public ExpressionNode leftChild;
        public ExpressionNode rightChild;
        
        public ExpressionNode(String value) {
            this.data = value;
        }
    }
    
    private ExpressionNode root = null;

    // Build the postfix expression tree
    public ExpressionTree(String postfix) {
        MyStack<ExpressionNode> stack = new MyStack<>();

        // Scan the postfix expression
        Scanner scanner = new Scanner(postfix);

        while (scanner.hasNext()) {
            String s = scanner.next();

            // If digit, push onto the stack, otherwise it is an operator
            if (Character.isDigit(s.charAt(0))) {
                stack.push(new ExpressionNode(s));
                
            } // If operator, pop two digits from the stack and attach them as leaves
            else if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
                ExpressionNode node = new ExpressionNode(s);
                node.rightChild = stack.pop();
                node.leftChild = stack.pop();

                if (node.leftChild == null || node.rightChild == null) {
                    System.out.println("That is not a valid postfix expression.");
                    System.exit(0);
                }

                // push the tree onto the stack
                stack.push(node);
            } 
            else {
                System.out.println("Invalid operator/digit in postfix expression.");
                System.exit(0);
            }
        }

        root = stack.pop();
        
        if (!stack.isEmpty()) {
            System.out.println("That is not a valid postfix expression.");
            System.exit(0);
        }
    }
    
    // Evaluate the expression tree
    public int eval() {
        return eval(root);
    }

    // Evaluate the expression tree
    private int eval(ExpressionNode current) {
        if (Character.isDigit(current.data.charAt(0))) {
            return Integer.parseInt(current.data);
        }

        int left = eval(current.leftChild);
        int right = eval(current.rightChild);
        
        // switch statement to determine operation
        switch (current.data.charAt(0)) {
        
        	case '+':
        		return left + right;
        	case '-':
        		return left - right;
            case '*':
                return left * right;
            case '/':
                return left / right;
        }

        return 0;
    }

    // Returns postfix expression
    public String postfix() {
        StringBuilder sb = new StringBuilder();
        postfix(root, sb);

        return sb.toString().trim();
    }

    // Returns postfix expression
    private void postfix(ExpressionNode current, StringBuilder sb) {
        if (current == null) {
            return;
        }

        postfix(current.leftChild, sb);
        postfix(current.rightChild, sb);

        sb.append(current.data).append(" ");
    }

    // Returns prefix expression
    public String prefix() {
        StringBuilder sb = new StringBuilder();
        prefix(root, sb);

        return sb.toString().trim();
    }

    // Returns prefix expression
    private void prefix(ExpressionNode current, StringBuilder sb) {
        if (current == null) {
            return;
        }

        sb.append(current.data).append(" ");

        prefix(current.leftChild, sb);
        prefix(current.rightChild, sb);
    }
    
    // Returns infix expression
    public String infix() {
        StringBuilder sb = new StringBuilder();
        infix(root, sb);

        return sb.toString().trim();
    }

    // Returns infix expression
    private void infix(ExpressionNode current, StringBuilder sb) {
        if (current == null) {
            return;
        }
        
        sb.append("( ");
        infix(current.leftChild, sb);
        sb.append(current.data).append(" ");
        infix(current.rightChild, sb);
        sb.append(") ");
    }
}
