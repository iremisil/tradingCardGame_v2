package home.assignment.tcg.commands;

import home.assignment.tcg.exceptions.TradingCardGameException;

public interface Command {

    Object execute(Object... param) throws TradingCardGameException;

}
