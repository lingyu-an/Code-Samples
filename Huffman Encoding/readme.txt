Data Structures hw4 readme
Lingyu An
la2659

To compile all files:

javac SpellChecker.java
javac Huffman.java

To run:

java SpellChecker.java words.txt filetospellcheck.txt
java Huffman.java huffmantestfile.txt

SpellChecker:
Takes in 2 command line arguments and checks the spelling of the second one against the words provided in the first.
I put every word in the dictionary file into a hashmap, and every word in the second file is searched for in this hashmap.

There are 3 methods that are executed if it is not found:
addChar: 		adds a letter to the word and tests if the new word is valid
removeChar: 	removes a letter from the word and tests if the new word is valid
exchangeChar:	exchanges adjacent letters in the word and tests if the new word is valid


Huffman:
Creates a Huffman tree from a text file and encodes/decodes messages based on this tree.

filetospellcheck.txt and huffmantestfile.txt:
A text file based on a story taken from http://www.textfiles.com/stories/contrad1.hum