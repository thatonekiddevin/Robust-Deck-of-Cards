import java.util.Scanner;

public class FindCard {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String args[]) {
        char cardSuit;
        int cardValue;
        Card userCard = null;
        boolean breakFree = true;

        System.out.println("You will be creating a card today.");

        Deck gameDeck = new Deck();
        gameDeck.shuffle();

        while(breakFree) {

            System.out.println("Enter a card value from 1-13: ");
            cardValue = userInput.nextInt();

            System.out.println("Enter a suit character: ");
            cardSuit = userInput.next().charAt(0);

            try {
                userCard = new Card(cardSuit, cardValue);
                break;
            } catch (InvalidCardSuitException badChar) {
                System.out.println(badChar.toString());
            } catch (InvalidCardValueException badValue){
                System.out.println(badValue.toString());
            }
        }
        
        System.out.println("You created: " + userCard);

        String userCardString = userCard.toString();

        for (int deckIndex = 0; deckIndex < 52; deckIndex++) {
            if(gameDeck.getCard(deckIndex).toString().equals(userCardString)) {
                System.out.println("Your card is at position " + deckIndex + " in the deck!");
            }
        }
        
    }
}
