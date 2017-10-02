//************************************
// Lingyu An
// la2659
// tester for avl tree
// 
//************************************
import java.io.File;
import java.util.Scanner;

public class Problem2 {

    // Takes input as command line argument
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Please provide correct file name.");
            return;
        }

        AvlTree tree = new AvlTree();
        Scanner inFile = new Scanner(new File(args[0]));
        int lineCount = 0;

        while (inFile.hasNextLine()) {
            lineCount++;
            String s = inFile.nextLine();

            Scanner scanner = new Scanner(s);

            while (scanner.hasNext()) {
            	// Make everything lowercase and remove all non-word characters.
                String word = scanner.next().toLowerCase().replaceAll("\\W", "");
                
                // Index all words
                tree.indexWord(word, lineCount);
            }
        }
        inFile.close();
        tree.printIndex();
    }
}
