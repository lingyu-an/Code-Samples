//************************************
// Lingyu An
// la2659
// Card class
// A playing card with suit, name,
// and value
//************************************
public class Card 
{
	private String suit;
	private int value;
	private String cardName;
	
	public Card(String symbol, int number, String name)
	{
		suit= symbol;
		value = number;
		cardName = name;
	}
	
	public int returnValue()
	{
		return value;
	}
	
	// toString for description
	public String toString()
	{
		String description;	
		description = cardName + " of " + suit;	
		return description;
	}
}
