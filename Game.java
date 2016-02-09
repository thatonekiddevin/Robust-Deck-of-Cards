
public class Game
{
	public static final int  HAND_SIZE=5;
	public static void main( String[] argv)
	{
		
		Card [] hand = new Card[HAND_SIZE];
		//This program needs to get a deck of cards
		Deck gameDeck = new Deck();
		System.out.println(gameDeck);
		
		// shuffle it 
		gameDeck.shuffle();
		
		//deal out the top 5 cards
		for(int dealSpot=0; dealSpot < HAND_SIZE; dealSpot++)
		{
			hand[dealSpot] = gameDeck.getCard(dealSpot);
		}
		
		// It then needs to add the values of the cards and display the result
		int totalCardValue = 0;
		for(int handSpot=0; handSpot < HAND_SIZE; handSpot++)
		{
			totalCardValue += hand[handSpot].getValue();
		}
		System.out.println("Total Card Values: " + totalCardValue);
		
		//count how many cards of each suit and display that as well.
		int totalHearts = 0;
		int totalSpades = 0;
		int totalClubs = 0;
		int totalDiamonds = 0;
		int totalBadCards = 0;
		for(int handSpot=0; handSpot < HAND_SIZE; handSpot++)
		{
			char cardSuit = hand[handSpot].getSuitDesignator();
			switch(cardSuit)
			{
				case 'H':
					totalHearts++;
					break;
				case 'S':
					totalSpades++;
					break;
				case 'C':
					totalClubs++;
					break;
				case 'D':
					totalDiamonds++;
					break;
				default:
					totalBadCards++;
					break;		
			}			
		}
		System.out.println("Hearts: " + totalHearts + "; Spades: " + totalSpades + "; Clubs: " + totalClubs + "; Diamonds: " + totalDiamonds + "; Other: " + totalBadCards );
		
		//Hand reveal
		for(int dealSpot=0; dealSpot < HAND_SIZE; dealSpot++)
		{
			System.out.println(hand[dealSpot]);
		}
	}


}
