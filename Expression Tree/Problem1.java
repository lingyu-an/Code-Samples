//************************************
// Lingyu An
// la2659
// tester for expression tree
// runs all required methods
// 
//************************************

public class Problem1 {


    public static void main(String[] args) {

        String postfix = "34 2 - 5 *";
        ExpressionTree tree = new ExpressionTree(postfix);
        System.out.println("Evaluation: " + tree.eval());
        System.out.println("Postfix: " + tree.postfix());
        System.out.println("Prefix: " + tree.prefix());
        System.out.println("Infix: " + tree.infix());
    }
}
