package home.assignment.tcg.exceptions;

public class DeckEmptyException extends TradingCardGameException {

    private static final long serialVersionUID = -4652492407327223999L;

    public DeckEmptyException(String message) {
        super(message);
    }
}
