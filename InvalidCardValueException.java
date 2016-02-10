
public class InvalidCardValueException extends Exception {

    protected int valueInput;

    public InvalidCardValueException(int invalidValue) {
        this.valueInput = invalidValue;
    }
    private InvalidCardValueException() {
    }
    public String toString() {
        return ("Attempted to create card with invalid value argument" + " " + this.valueInput);
    }
    public int getValue() {
        return this.valueInput;
    }
}
