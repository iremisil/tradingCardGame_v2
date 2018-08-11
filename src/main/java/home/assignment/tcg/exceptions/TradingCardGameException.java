package home.assignment.tcg.exceptions;

public class TradingCardGameException extends Exception {

    private static final long serialVersionUID = 6701300347541552892L;

    public TradingCardGameException(String message) {
        super(message);
    }

    public static final DeckEmptyException DECK_IS_EMPTY = new DeckEmptyException("Deck is empty");
    public static final NotEnoughManaException NOT_ENOUGH_MANA = new NotEnoughManaException("Not enough mana");
}
