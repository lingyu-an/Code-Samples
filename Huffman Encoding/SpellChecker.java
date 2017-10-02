//************************************
// Lingyu An
// la2659
// Spellchecker
// 
//************************************
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
public class SpellChecker {
	
	static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	
	 // Takes input as command line argument
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Please provide correct file names.");
            return;
        }

        Map<Integer,String> dictionary = new HashMap<>();
        Scanner inFile = new Scanner(new File(args[0]));
        int count = 0;

        while (inFile.hasNext()) {
            String word = inFile.next().toLowerCase();         
            dictionary.put(count, word);
            count++;
        	
        }
        inFile.close();
        Scanner words = new Scanner(new File(args[1]));
        int lineCount = 0;
        while (words.hasNextLine()) {
            lineCount++;
            String s = words.nextLine();
            Scanner scanner = new Scanner(s);

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                
                // remove leading and trailing punctuation
                if(!Character.isLetterOrDigit(word.charAt(0)))
                	word = word.substring(1);
                if(!Character.isLetterOrDigit(word.charAt(word.length()-1)))
                	word = word.substring(0,word.length()-1);
                
                // check hashmap for word
                if(!dictionary.containsValue(word)){
                	System.out.println(word +" is misspelled on line " 
                			+ lineCount);
                	
                	// add a char
                	System.out.println("Words obtainable by adding a "
                			+ "character:" + addChar(word, dictionary));
                	
                	// remove a char
                	System.out.println("Words obtainable by removing a "
                			+ "character:" + removeChar(word, dictionary));
     	
                	// exchange adjacent chars
                	System.out.println("Words obtainable by exchanging "
                			+ "two adjacent characters:" + exchangeChar(word, dictionary));
                	System.out.println();
                }
            }
        }
        words.close();
        
    }
    
    // add a char
    private static ArrayList<String> addChar(String word,Map<Integer,String> map){
    	ArrayList<String> obtainable = new ArrayList<>();
    	
    	String str = word;
	    for (char c : alphabet) {   	   
	       for (int x=0;x<=str.length();x++){
		   	   String newWord = str.substring(0,x) + c + str.substring(x);
		   	   
		   	if(map.containsValue(newWord)&&!obtainable.contains(newWord))
		   	   obtainable.add(newWord);
	       }
	       
	    }
    	return obtainable;
    }
    
    // remove a char
    private static ArrayList<String> removeChar(String word,Map<Integer,String> map){
    	ArrayList<String> obtainable = new ArrayList<>();
    	
    	String str = word;
    	
	    for (int x=0;x<=str.length()-1;x++){	    	   
	    	String newWord = str.substring(0,x) + str.substring(x+1);	    	   
	    	
	    	if(map.containsValue(newWord)&&!obtainable.contains(newWord))
			   	   obtainable.add(newWord);
	    }  	   	    
    	return obtainable;
    }
    
    // exchange adjacent chars
    private static ArrayList<String> exchangeChar(String word,Map<Integer,String> map){
    	ArrayList<String> obtainable = new ArrayList<>();
    	
    	for (int i = 0; i < word.length() - 1; i++) {
            String working = word.substring(0, i);// System.out.println("    0:" + working);
            working = working + word.charAt(i + 1);  //System.out.println("    1:" + working);
            working = working + word.charAt(i); //System.out.println("    2:" + working);
            working = working.concat(word.substring((i + 2)));//System.out.println("    FIN:" + working); 
            if (map.containsValue(working)) 
                obtainable.add(working);
            
        }
        return obtainable;
    }
}
