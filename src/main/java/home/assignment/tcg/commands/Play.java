package home.assignment.tcg.commands;

import home.assignment.tcg.exceptions.NotEnoughManaException;
import home.assignment.tcg.exceptions.TradingCardGameException;
import home.assignment.tcg.model.Player;

public class Play implements Command {

    private Player player;

    public Play(Player player) {
        this.player = player;
    }

    @Override
    public Integer execute(Object... param) throws NotEnoughManaException {
        Integer index = (Integer) param[0];
        Integer damage = this.player.getHand().get(index - 1);
        if (this.player.getMana() < damage)
            throw TradingCardGameException.NOT_ENOUGH_MANA;

        this.player.getHand().remove(index - 1);
        return damage;
    }
}
