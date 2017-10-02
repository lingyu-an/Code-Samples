//************************************
// Lingyu An
// la2659
// Deck class
// A deck of 52 playing cards 
//
//************************************
import java.util.Arrays;

public class Deck 
{
	private Card[] deck;
	private int count;
	private Card top;
	private int i;
	
	public Deck()
	{
		deck = new Card[52];
		count = 52;
		newDeck();
		shuffle();
	}
	
	// fills the deck with cards
	public void newDeck()
	{
		String symbol = "";
		int number;
		String name = "";
		
		for(i = 1; i<=deck.length; i++)
		{	
			// divide by 13 in order to assign suits
			if(i / 13 == 0)
				symbol = "Spades";
			if(i / 13 == 1)
				symbol = "Hearts";
			if(i / 13 == 2)	
				symbol = "Clubs";
			if(i / 13 == 3)
				symbol = "Diamonds";
			
			// modulus to keep it between 0-12
			number = i % 13;
			
			switch (number)
			{
				case 1 : name = "Ace"; break;
				case 2: name = "Two"; break;
				case 3: name = "Three"; break;
				case 4: name = "Four"; break;
				case 5: name = "Five"; break;
				case 6: name = "Six"; break;
				case 7 : name = "Seven"; break;
				case 8: name = "Eight"; break;
				case 9: name = "Nine"; break;
				case 10: name = "Ten"; break;
				case 11: name = "Jack"; break;
				case 12: name = "Queen"; break;
				case 0: name = "King"; break;
				default: name = ""; break;
			}
			
			// if number is a face card, its value is 10
			if(number == 0 | number > 10)
				number = 10;
			// if it is an ace, it starts at 11
			if(number == 1)
				number = 11;
			
			deck[i-1] = new Card(symbol, number, name);
			count = 52;
		}
	}
	
	// shuffles the deck
	public void shuffle()
	{
	
    	int x, j;
    	for(int i = 0; i < 1000; i++){
        	x = (int) (Math.random()*52);
        	j = (int) (Math.random()*52);
    		Card temp = deck[x];
    		deck[x] = deck[j];
    		deck[j] = temp;
    	}
	}
	
	// takes a card off the top and moves the rest of the cards up
	public Card deal()
	{
		top = deck[0];
		for(i=0; i<51; i++)
		{
			deck[i]= deck[i+1];
		}
		
		count--;
		// if number of cards goes below 12, refill the deck.
		return top;
	}
	
	public void checkCount()
	{
		if(count < 12)
		{
			newDeck();
			shuffle();
		}
	}
	
	public String toString()
	{
		String cards = ""; 			
		for (int i = 0; i < count; i++)
			cards += deck[i].toString() + "\n";
		
		return cards;
	}
	
}
