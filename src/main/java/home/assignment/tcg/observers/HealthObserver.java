package home.assignment.tcg.observers;

import home.assignment.tcg.model.Player;

public class HealthObserver extends Observer {

    public HealthObserver(Player player) {
        this.player = player;
    }

    @Override
    public void update(Integer damage) {

        this.player.setHealth(this.player.getHealth() - damage);
    }
}
