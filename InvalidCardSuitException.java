
public class InvalidCardSuitException extends Exception {

    protected char charInput;

    public InvalidCardSuitException(char invalidSuit) {
        this.charInput = invalidSuit;
    }
    private InvalidCardSuitException() {

    }
    public String toString() {
        return ("Attempted to create a card with invalid suit argument" + " " + this.charInput);

    }
    public char getSuitDesignator() {
        return this.charInput;
    }

}
