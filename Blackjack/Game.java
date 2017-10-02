//************************************
// Lingyu An
// la2659
// Game class
// A game of blackjack with one player, 
//  one dealer, and a deck of cards
//************************************
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class Game 
{
	private Deck deck;
	private Player player;
	private Dealer dealer;
	private boolean blackjack;
	private boolean valid;
	private double bet;
	private boolean playerBust;
	private boolean dealerBust;
	private boolean dealerHit;
	private boolean keepPlaying;
	Scanner input = new Scanner(System.in);
	NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
	
	public Game()
	{
		deck = new Deck();
		player = new Player();
		dealer = new Dealer();
	}
	
	public void play()
	{
		System.out.println("Welcome to Blackjack!");
		buyIn();
		//System.out.println(player.getBalance());
		keepPlaying = true;
		//loop
		while(keepPlaying == true && player.getBalance() >= 10)
			
		{
			reset();
			bet();
			deal();
			// I put these to make it easier to read while playing.
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			player.showHand();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			dealer.showTop();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			checkBlackjack();		
			if(blackjack == false)
			{
				playerTurn();
				if(playerBust == false)
					dealerTurn();
				if(dealerBust == false && playerBust == false)
					getResults();
			}
			// if balance is greater than 10, ask to play again
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			if(player.getBalance() >= 10)
				playAgain();
			// if balance is less than 10, exit
			if(player.getBalance() < 10)
				System.out.println("You don't have enough money to continue!");
		}	
		System.out.println("Thanks for playing!");
		System.out.println("Have a fantastic day!");
	}
	
	// checks whether the input value is greater than 100 and then
	// adds it into the players balance if it is.
	private void buyIn()
	{
		System.out.println("How much would you like to buy in for?");
		double buyIn = input.nextInt();
		while(buyIn<100)
		{	
			System.out.println("Please enter a value greater than 100!");
			buyIn = input.nextInt();
		}
		player.addBalance(buyIn);
	}
	
	// deals the initial cards
	private void deal()
	{
		player.acceptCard(deck.deal());
		dealer.acceptCard(deck.deal());
		player.acceptCard(deck.deal());
		dealer.acceptCard(deck.deal());
	}
		
	// checks for blackjack after dealing
	private void checkBlackjack()
	{
		blackjack = false;
		// check for blackjack push
		if(player.getTotal() == 21 && dealer.getTotal() == 21)
		{
			System.out.println("You both got blackjack. It's a push!");
			blackjack = true;
		}
		//check for dealer blackjack
		if(dealer.getTotal() == 21 && dealer.getTotal() > player.getTotal())
		{
			dealer.showHand();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Dealer got blackjack. You lose!");
			player.subtractBalance(bet);
			blackjack = true;
		}
		//check for player blackjack
		if(player.getTotal() == 21 && player.getTotal() > dealer.getTotal())
		{
			System.out.println("You got blackjack. You win! Wowee!!!");
			player.addBalance(bet*1.5);
			blackjack = true;
		}
	}
	
	// asks for bet
	private void bet()
	{
		System.out.println("How much would you like to bet?");
		System.out.print("Your current balance is: ");
		System.out.print(fmt.format(player.getBalance()) + "\n");
		
		bet = input.nextInt();
		while(bet < 10 || bet > 1000)
		{	
			System.out.println("Please enter a value between 10 and 1000!");
			bet = input.nextInt();
		}
		while( bet > player.getBalance())
		{
			System.out.println("You don't have that much money!");
			System.out.println("Please enter a valid amount!");
			bet = input.nextInt();
		}
	}

	//player's turn
	public void playerTurn()
	{
		boolean hit = true;
		// loop to keep hitting
		while(hit == true)
		{
			System.out.println("Your current total is: " + player.getTotal());
			System.out.println("Please enter '1' to hit or '2' to stand");
			int x = input.nextInt();
			
			// hit
			if(x==1)
			{
				player.acceptCard(deck.deal());
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~"
						+ "~~~~~~~~~~~~~~~~~~~~");
				
				player.showHand();
				
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~"
						+ "~~~~~~~~~~~~~~~~~~~~");
				
				if(player.getTotal()>21)
				{
					System.out.print("Your total is now: ");
					System.out.print(player.getTotal() + "\n");
					System.out.println("You busted!");
					playerBust = true;
					player.subtractBalance(bet);
					hit = false;
				}
			}
			
			// stand
			if(x==2)
			{
				System.out.println("You stand");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~"
						+ "~~~~~~~~~~~~~~~~~~~~");
				hit = false;
			}
		}
	}
	
	// dealer's turn
	public void dealerTurn()
	{
		while(dealer.getTotal()<17)
		{
			dealer.acceptCard(deck.deal());
			System.out.print("Dealer hits! Their total is now: ");
			System.out.print(dealer.getTotal());
			System.out.println("");
			dealerHit = true;
			if(dealer.getTotal()>21)
			{
				System.out.println("Dealer busted! Lucky you!!!" + "\n");
				player.addBalance(bet);
				dealer.showHand();
				dealerBust = true;
			}
			
		}
		// when dealer has 17 or higher after dealing
		if(dealerBust == false && dealerHit == false)
		{
				System.out.print("Dealer stands. Their total is: ");
				System.out.print(dealer.getTotal());
				System.out.println("");
		}
		// when dealer gets to 17 or higher after hitting
		if(dealerBust == false && dealerHit == true)
		{
				System.out.println("Dealer stands");
		}
	}

	// decides winner and adds/subtracts money 
	
	// determine outcome
	private void getResults()
	{
		if(dealer.getTotal() == player.getTotal())
		{
			dealer.showHand();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("You tied!");
		}
		if(dealer.getTotal() > player.getTotal())
		{
			dealer.showHand();
			System.out.println("You lose!");
			player.subtractBalance(bet);
		}
		if(dealer.getTotal() < player.getTotal())
		{
			System.out.println("You win!");
			player.addBalance(bet);
		}
	}
	
	// asks if you would like to continue playing
	private void playAgain()
	{
		System.out.print("Your balance is now: ");
		System.out.print(fmt.format(player.getBalance()) + "\n");
		System.out.println("Would you like to play again?");
		System.out.println("Please enter '1' For Yes and '2' for No");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		int p = input.nextInt();
		while(p < 1 || p > 2)
		{
			System.out.println("Please enter a valid option");
			p = input.nextInt();
		}
		if(p == 1)
			keepPlaying = true;
		if(p == 2)
			keepPlaying = false;
		
			
	}

	// resets hands and variables for the next round
	private void reset()
	{
		playerBust = false;
		dealerBust = false;
		player.resetHand();
		dealer.resetHand();
		deck.checkCount();
	}
}
