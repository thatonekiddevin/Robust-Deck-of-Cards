
public class InvalidDeckPositionException extends Exception {
    public InvalidDeckPositionException(int invalidPosition) {

    }
    private InvalidDeckPositionException() {

    }

    public String toString() {
        //return "Attempted to get a card from a position not in Deck:" + " " + <value>
    }

    public int getPositionValue() {
        //return int value of card attempted to be created
    }
}
