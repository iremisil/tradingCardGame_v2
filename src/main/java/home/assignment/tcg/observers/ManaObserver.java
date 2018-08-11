package home.assignment.tcg.observers;

import home.assignment.tcg.model.Player;

public class ManaObserver extends Observer {

    public ManaObserver(Player player) {
        this.player = player;
    }

    @Override
    public void update(Integer damage) {
        if (this.player.getMana() < 10)
            this.player.setMana(this.player.getMana() + damage);

    }
}
