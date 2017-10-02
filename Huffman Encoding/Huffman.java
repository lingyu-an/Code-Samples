//************************************
// Lingyu An
// la2659
// Huffman tree encoding
// 
//************************************
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.PriorityQueue;


public class Huffman {
	
	private static HuffmanNode root;
	private static Map<Character, String> charCode;
	
	public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Please provide valid file name.");
            return;
        }
        
        Map<Character, Integer> charFreq = getFreqs(args[0]);
        
        root = buildTree(charFreq);
        charCode = encode(charFreq.keySet(), root);
        printTable(charCode);
        
        System.out.println("Please enter a code of 0s and 1s");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if(!input.matches("^[01]+$")){
        	System.out.println("Invalid code1");
        	System.exit(0);
        }
        
        System.out.println(decode(input));
        System.out.println("Please enter a message to encode");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String input2 = br2.readLine();
        
        System.out.println(encodeInput(charCode, input2));
   
        
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        	
        
	}
	
	// create map with char frequencies
	private static Map<Character, Integer> getFreqs(String input) throws IOException{
		
		BufferedReader in = new BufferedReader(new FileReader(input));
		int x;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		        
		while((x= in.read())!= -1){
		
			char c = (char)x;
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} 
			else {
				int freq = map.get(c);
		       	map.put(c, ++freq);
		    }
		}
		in.close();
		return map;
	}
	
	// build Huffman tree
	private static HuffmanNode buildTree(Map<Character, Integer> map) {
		
		// make forest of nodes and insert into priority queue
		PriorityQueue<HuffmanNode> nodeForest = new PriorityQueue<HuffmanNode>(10, new HuffComparator());
		
		for( char ch : map.keySet()) {
			nodeForest.add(new HuffmanNode(ch, map.get(ch), null, null));
		}
		
		// build tree from priority queue
		while(nodeForest.size() > 1) {
			
			HuffmanNode a = nodeForest.remove();
			HuffmanNode b = nodeForest.remove();
			HuffmanNode node = new HuffmanNode('\0', a.frequency + b.frequency, a, b);
			nodeForest.add(node);
		}
		
		// return root
		return nodeForest.remove();
	}
	

	private static String decode(String input){
		
		StringBuilder sb = new StringBuilder();
		HuffmanNode node = root;
		String working = input;
		
		while(working.length()!=0){
	
			char current = working.charAt(0);

			if(!node.isLeaf()){	
				
				if(working.charAt(0) =='0'){				
					node = node.left;		
				}
				else
					node = node.right;		
			}
			if(node.isLeaf()){
				sb.append(node.element);
				node = root;
			}
			working = working.substring(1);
		}
		
		String output = sb.toString();

		// check for invalid codes
		if(!encodeInput(charCode,output).equals(input)){
			System.out.println("Invalid code");
			System.exit(0);
		}
		return sb.toString();		
	}

	// encodes user input message
	private static String encodeInput(Map<Character, String> codeMap, String input) {
		
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < input.length(); i++) {
			sb.append(codeMap.get(input.charAt(i)));
		}
		return sb.toString();
	}
	
	// encode characters
	public static Map<Character, String> encode(Set<Character> chars, HuffmanNode node) {
		
		Map<Character, String> map = new HashMap<Character, String>();
		encodeHelper(node, map, "");
		return map;
	}

	private static void encodeHelper(HuffmanNode node, Map<Character, String> map, String code) {
			
		if (node.left == null && node.right == null) {
		map.put(node.element, code);
		return;
		}
		
		encodeHelper(node.left, map, code + '0');
		encodeHelper(node.right, map, code + '1' );
	}
	
	public static void printTable(Map<Character, String> map){
		System.out.printf("%-8s %-8s %n", "character", "Huffman Code");
		
		for(Character key: map.keySet()){
			System.out.printf("%-8s %-8s %n", key,"" + map.get(key));
		}
	}
		
	// Node nested class
	private static class HuffmanNode {

        HuffmanNode(Character theElement) {
            this(theElement, 0, null, null);
        }

        HuffmanNode(Character theElement, int freq, HuffmanNode lt, HuffmanNode rt) {
            element = theElement;
            left = lt;
            right = rt;
            frequency = freq;
        }

        char element;
        HuffmanNode left;
        HuffmanNode right;
        int frequency;
        
        private boolean isLeaf(){
        	if(this.left==null&&this.right==null)
        		return true;
        	else
        		return false;     	
        }
    }
	
	// Comparator to order priority queue
	private static class HuffComparator implements Comparator<HuffmanNode> {
		
		public int compare(HuffmanNode a, HuffmanNode b) {
		return a.frequency - b.frequency;
		}
	}

}
