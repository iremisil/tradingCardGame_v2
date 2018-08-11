package home.assignment.tcg.commands;

import home.assignment.tcg.exceptions.DeckEmptyException;
import home.assignment.tcg.exceptions.TradingCardGameException;
import home.assignment.tcg.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Draw implements Command {

    private Player player;

    public Draw(Player player) {
        this.player = player;
    }

    @Override
    public Integer execute(Object... param) throws DeckEmptyException {
        return getRandomCard();
    }

    private Integer getRandomCard() {

        // pick random card
        List<Integer> hand = this.player.getCardList();

        int index = new Random().nextInt(hand.size());
        int damage = hand.get(index);
        // card was already drawn before
        if (damage == -1) {
            getRandomCard();
        } else {
            // card is now drawn
            hand.remove(index);
        }
        // hit
        return damage;
    }


}
