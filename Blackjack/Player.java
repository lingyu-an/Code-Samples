//************************************
// Lingyu An
// la2659
// Player class
// A human player in a blackjack game 
//
//************************************
import java.util.ArrayList;

public class Player
{
	private ArrayList<Card> hand;
	private int total = 0;
	private double balance;
	private boolean ace = false;
	
	public Player()
	{
		hand = new ArrayList<Card>();
	}
	
	public void acceptCard(Card top)
	{
		// add top card that was dealt to hand
		hand.add(top);
		
		// boolean ace to keep track of whether there is an ace in your hand.
		if(top.returnValue() == 11)
			ace = true;
		
		// add value of card to total
		total += top.returnValue();
	
		// if card was an ace and total goes over 21, subtract 10 from total
		if(ace && total>21)
		{
			total -= 10;
			ace = false;
		}
	}
	
	public void showHand()
	{
		System.out.println("Your hand:");
		if(hand != null)
		{
    		for(Card c : hand)
        	{
        		System.out.println(c);
        	}
		}
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void addBalance(double money)
	{
		balance += money;
	}
	
	public void subtractBalance(double money)
	{
		balance -= money;
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
