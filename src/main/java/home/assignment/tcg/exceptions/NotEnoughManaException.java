package home.assignment.tcg.exceptions;

public class NotEnoughManaException extends TradingCardGameException {

    private static final long serialVersionUID = -2375257626990447806L;

    public NotEnoughManaException(String message) {
        super(message);
    }
}
