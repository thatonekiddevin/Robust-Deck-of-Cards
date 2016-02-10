
public class InvalidDeckPositionException extends Exception {

    protected int deckInput;

    public InvalidDeckPositionException(int invalidPosition) {
        this.deckInput = invalidPosition;
    }
    private InvalidDeckPositionException() {

    }
    public String toString() {
        return ("Attempted to get card from a position not in Deck:" + " " + this.deckInput);
    }
    public int getPositionValue() {
        return this.deckInput;

    }
}
