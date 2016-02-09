
public class InvalidSuitException extends  Exception {
    public InvalidSuitException(char invalidSuit) {

    }

    private InvalidSuitException() {

    }

    public String toString() {
        //return "Attempted to create card with invalid suit argument" + " " + <value name>
    }

    public char getSuitDesignator() {
        //return char desginator of card suit attempted to be created
    }
}
