public class InvalidCardValueException extends  Exception {
    public InvalidCardValueException(int cardValue) {

    }

    private InvalidCardValueException() {

    }

    public String toString() {
        //return "Attempted to create card with invalid value argument" + " " + <value>
    }

    public int getValue() {
        //return int value of card attempted to be created
    }
}
