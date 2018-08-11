package home.assignment.tcg.observers;

import home.assignment.tcg.model.Player;

public abstract class Observer {

    protected Player player;

    public abstract void update( Integer damage);

}
