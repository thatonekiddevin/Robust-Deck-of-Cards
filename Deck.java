import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.ArrayList;
import java.util.Random;

public class Deck
{
	private final int NUMBER_OF_SUITS = 4;  //By using these constants we can alter the characteristics of the cards
	private final int CARDS_PER_SUIT = 13;
	private final char [] CARD_SUIT_CHARS = {'H', 'S', 'C', 'D'};  //Great idea from Melissa Bruno
	
	private final int DECK_SIZE = 52;
	private ArrayList deck;  //I chose to use an array.  However, an ArrayList will probably have more utility in the future

	//Deck() : creates an ordered standard deck of 52 cards
	// 1: First method set written and tested
	public Deck()
	{
		deck = new ArrayList();
		
		int cardValue;
		char cardSuit;
		

		for(int deckIndex=0; deckIndex<DECK_SIZE; deckIndex++)
		{
			cardValue = (deckIndex % CARDS_PER_SUIT) + 1;  //these calculations could have been done in the call, but were separated for clarity
			cardSuit = CARD_SUIT_CHARS[deckIndex/CARDS_PER_SUIT];
			try {
				Card tempCard = new Card(cardSuit, cardValue);  //again, could have been done within the next statement but separated for clarity
				this.deck.add(tempCard);
			}
			catch (InvalidCardSuitException badChar) {
				System.out.println(badChar.getSuitDesignator());
			} catch (InvalidCardValueException badValue){
				System.out.println(badValue.getValue());
			}
		}
	}

	//String toString() :   returns a representation of the Deck as Card + “ “ + Card + … 
	// 1: First method set written and tested
	public String toString()
	{
		String returnString = "";
		
		for(int deckIndex=0; deckIndex<DECK_SIZE; deckIndex++)
		{
			returnString += this.deck.get(deckIndex) + " ";  // Not quite correct since it will end with an extra space
																			//  Also need to consider using getCard method instead of directly accessing deck
		}
		
		return returnString;
	}
	
	//Card getCard(int) : returns the Card from the Deck in the designated position
	// 2: Second method set written and tested
	public Card getCard(int inDeckIndex)
	{
		return (Card) this.deck.get(inDeckIndex);
	}
	
	//private swapCards(int, int) : swaps the Card positions within the Deck
	// 3: Third method set written and tested
	// tough to test without implementing shuffle so for an initial proof of function made the method public, tested and then changed back to private
	private void swapCards(int inFirstLocation, int inSecondLocation)
	{
		
		Card tempCard;
		
		tempCard = this.getCard(inFirstLocation);
		this.deck.set(inFirstLocation, this.getCard(inSecondLocation));
		this.deck.set(inSecondLocation, tempCard);
		
	}
	
	//shuffle() : randomizes the Card order within the deck
	// 4: Fourth method set written and tested	
	public void shuffle() 
	{
		Random randomSpot = new Random();
		for(int deckIndex=0; deckIndex<DECK_SIZE; deckIndex++)
		{
			this.swapCards(deckIndex, (randomSpot.nextInt(DECK_SIZE)));
		}
		
	}

	
	//boolean compareTo(Deck) : returns true if both Decks have the same cards in the exact order
	// 5: Fifth method set written and tested
	//  As a note, public'd swapCards briefly to have direct access to change the deck to test this method. Briefly considered creating a temporary helper method to set a card at a specific spot in the deck to test this method
	public boolean compareTo(Deck inDeck)
	{
		boolean returnValue = true;  // assume true until a mismatch
		for(int deckIndex=0; deckIndex<DECK_SIZE; deckIndex++)
		{
			if(!(this.getCard(deckIndex).compareTo(inDeck.getCard(deckIndex))))
			{
				returnValue = false;
				break;
			}
		}
		
		return returnValue;
	}

}
