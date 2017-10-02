//************************************
// Lingyu An
// la2659
// Dealer class
// A computer player in a game of
// blackjack
//************************************
import java.util.ArrayList;

public class Dealer 
{
	private ArrayList<Card> hand;
	private int total = 0;
	private boolean bust;
	boolean ace = false;

	public Dealer()
	{
		hand = new ArrayList<Card>();
	}
	
	public void acceptCard(Card top)
	{
		// add top card that was dealt to hand
		hand.add(top);
		
		// add value of card to total
		total += top.returnValue();
		
		// boolean ace to keep track of whether there is an ace in your hand.
		if(top.returnValue() == 11)
			ace = true;
		
		// if card was an ace and total goes over 21, subtract 10 from total
		if(ace && total>21)
		{
			total -= 10;
			ace = false;
		}
	}
	
	// shows top card
	public void showTop()
	{
		System.out.println("Dealer's top card:");
		System.out.println(hand.get(0));
       
	}
	
	// shows entire hand
	public void showHand()
	{
		System.out.println("Dealer's hand:");
		if(hand != null)
		{
    		for(Card c : hand)
        	{
        		System.out.println(c);
        	}
		}
	}
	
	public int getTotal()
	{
		return total;
	}
	
	// reset hand for next round
	public void resetHand()
	{
		hand.clear();
		total = 0;
		// reset ace boolean for next hand
		ace = false;
	}
}
