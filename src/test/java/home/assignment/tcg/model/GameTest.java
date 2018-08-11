package home.assignment.tcg.model;

import home.assignment.tcg.Game;
import home.assignment.tcg.exceptions.DeckEmptyException;
import home.assignment.tcg.observers.HealthObserver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    private Game game;
    private HealthObserver healthObserver;


    @Before
    public void setUp() throws DeckEmptyException {

        game = new Game();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void gameInitalRequirementsShouldBeTrue() {

        int player1HandSize = game.getPlayer1().getHand().size();
        int player2HandSize = game.getPlayer2().getHand().size();

        assertThat("Player1 hand size should be 3", player1HandSize, is(3));
        assertThat("Player2 hand size should be 3", player2HandSize, is(3));

        int player1Mana = game.getPlayer1().getMana();
        int player2Mana = game.getPlayer2().getMana();

        assertThat("Player1 should have 0 Mana ", player1Mana, is(0));
        assertThat("Player2 should have 0 Mana ", player2Mana, is(0));

        int player1Health = game.getPlayer1().getHealth();
        int player2Health = game.getPlayer2().getHealth();

        assertThat("Player1 inital health should be 30 ", player1Health, is(30));
        assertThat("Player2 inital health should be 30 ", player2Health, is(30));

        int player1DeckSize = game.getPlayer1().getCardList().size();
        int player2DeckSize = game.getPlayer2().getCardList().size();

        assertThat("Player1 has 17 remaning card in his deck", player1DeckSize, is(17));
        assertThat("Player2 has 17 remaning card in his deck", player2DeckSize, is(17));

    }

    @Test
    public void playerChangeAfterTurn() {

        String player1Name = game.getPlayer1().getPlayerName();

        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();

        player1.setMana(6);

        game.initRound(player1, player2);
        String currentPlayerName = game.current.getPlayerName();

        assertThat("Player should be change after damage", currentPlayerName, is(player1Name));
    }


}
