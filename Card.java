
//  Author: Eric Luczaj

public class Card 
{
	
	private int cardID;  //I chose to use a single variable that could mathematically be used to transform from and to the value and suit
								//However a far simpler method would have simply stored the value and suit exactly as given by the constructor
	
	private final int NUMBER_OF_SUITS = 4;  //By using these constants we can alter the characteristics of the cards
	private final int CARDS_PER_SUIT = 13;
	private final char [] CARD_SUIT_CHARS = {'H', 'S', 'C', 'D'};  //Great idea from Melissa Bruno
	private final String [] CARD_SUIT_NAMES = {"Heart", "Spade", "Club", "Diamond"};
	private final String [] CARD_VALUE_NAMES = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	
	
	
	//  private Card(): creates a blank card with no suit and no value
	// 1: First method set written and tested
	private Card()
	{
	}

	// Card(char suit, int value)  : creates a card of the specified suit (H, S, C, D) and value (1-13)
	// 1: First method set written and tested
	public Card(char inCardSuit, int inCardValue) throws InvalidCardSuitException, InvalidCardValueException
	{
		int suitSequence;
		boolean charValidInput = false;

		for (int i = 0; i < CARD_SUIT_CHARS.length; i++) {
			if (inCardSuit == CARD_SUIT_CHARS[i]) {
				charValidInput = true;
			}
		}

		if (!charValidInput) {
			InvalidCardSuitException suitInvalid = new InvalidCardSuitException(inCardSuit);
			throw suitInvalid;
		}

		if (inCardValue < 1 || inCardValue > 13) {
			InvalidCardValueException valueInvalid = new InvalidCardValueException(inCardValue);
			throw valueInvalid;
		}
		for(suitSequence = 0; suitSequence < this.NUMBER_OF_SUITS; suitSequence++)
		{
			if(this.CARD_SUIT_CHARS[suitSequence] == inCardSuit)
			{
				break;  //Suit found
			}
		}

		this.cardID = (suitSequence * this.CARDS_PER_SUIT) + (inCardValue - 1);
	}

	//char getSuitDesignator() : returns char designator of card suit
	// 4: Fourth method set written and tested 
	public char getSuitDesignator()
	{
		int suitSequence = this.cardID / this.CARDS_PER_SUIT; //int Math to get the suit - originally had / and % flipped - found and fixed during testing
		return this.CARD_SUIT_CHARS[suitSequence];
	}
	
	//int getValue() : returns card value (1-13)
	// 4: Fourth method set written and tested 
	public int getValue()
	{
		int cardValue = this.cardID % this.CARDS_PER_SUIT; //int Math to get the suit
		return cardValue + 1; //Adding 1 to translate to a 1-13 card value (did not do this at first - found and fixed during testing)
		
	}
	
	
	//String getSuitName() : returns String name of card suit
	// 2: Second method set written and tested (also altered toString to use this method
	public String getSuitName()
	{
		int suitSequence = this.cardID / this.CARDS_PER_SUIT; //int Math to get the suit
		return this.CARD_SUIT_NAMES[suitSequence];
	}

	//String getValueName() : returns String name of card value (i.e. â€œAceâ€�, â€œTwoâ€�, â€¦ , â€œQueenâ€�, â€œKingâ€�)
	// 3: Third method set written and tested (also altered toString to use this method
	public String getValueName()
	{
		int valueSequence = this.cardID % this.CARDS_PER_SUIT; //int Math to get the suit
		return this.CARD_VALUE_NAMES[valueSequence];
		
	}

	//String toString() :  returns a representation of the Card as <suit name> +  â€œ â€œ + <value name>
	// 1: First method set written and tested
	public String toString()
	{
		//return this.cardID;  // 1: As it was first written (simply for testing the constructor
		//return this.getSuitName() + " " + this.cardID;  // 2: As altered for Second method set
		return this.getSuitName() + " " + this.getValueName();  // 3: Final version
	}

	//boolean compareSuit(Card) : returns true if both cards have the same suit regardless of value
	// 5: Fifth method set written and tested 
	public boolean compareSuit(Card inCompareCard)
	{
		return inCompareCard.getSuitDesignator() == this.getSuitDesignator();
	}

	//boolean compareValue(Card) : returns true if both cards have the same value regardless of suit
	// 6: Sixth method set written and tested 
	public boolean compareValue(Card inCompareCard)
	{
		return inCompareCard.getValue() == this.getValue();
	}

	//boolean compareTo(Card) : returns true if both cards have the same value and suit
	// 6: Sixth method set written and tested 
	public boolean compareTo(Card inCompareCard)
	{
		return (this.compareValue(inCompareCard) && this.compareSuit(inCompareCard)); //reuse the methods already written -- less code and changes go everywhere
	}
	

}
