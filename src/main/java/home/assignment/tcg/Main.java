package home.assignment.tcg;

import home.assignment.tcg.exceptions.DeckEmptyException;

public class Main {

    public static void main(String[] args) throws DeckEmptyException {

        Game game = new Game();
        game.initGame();
    }

}
