//package home.assignment.tcg.model;
//
//import home.assignment.tcg.Game;
//import home.assignment.tcg.exceptions.DeckEmptyException;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.*;
//import static org.junit.Assert.*;
//
//
//public class PlayerTest {
//
//    private Game game;
//
//    @Before
//    public void setUp() throws DeckEmptyException {
//        game = new Game();
//
//    }
//
//    @After
//    public void tearDown() {
//
//    }
//
//    @Test
//    public void playerHandShouldBeInitializeWithThreeCard() {
//        assertThat("Player should have 3 cards when game start", game.getPlayer1().getHand().size(), is(3));
//        assertThat("Player should have 3 cards when game start", game.getPlayer2().getHand().size(), is(3));
//    }
//
//    @Test
//    public void whenPlayerDrawCardItShoucurrentldBeDiscardedFromDeck() throws DeckEmptyException {
//
//        List<Integer> hand = game.getPlayer1().getHand();
//        int beforeDraw = hand.size();
//        ArrayList<Integer> cardList = game.getPlayer1().getCardList();
//        int cardSizeBeforeDraw = cardList.size();
//
//        game.getPlayer1().draw();
//
//        int afterDraw = game.getPlayer1().getHand().size();
//        int cardSizeAfterDraw = game.getPlayer1().getCardList().size();
//
//        assertThat("Hand should be increase after draw", afterDraw, is(beforeDraw + 1));
//        assertThat("Card Size should be decrease after draw", cardSizeAfterDraw, is(cardSizeBeforeDraw - 1));
//
//    }
//
//    @Test
//    public void playerHandShouldBeFiveMax() throws DeckEmptyException {
//
//        game.getPlayer1().draw();
//        game.getPlayer1().draw();
//        game.getPlayer1().draw();
//        game.getPlayer1().draw();
//        game.getPlayer1().draw();
//        game.getPlayer1().draw();
//
//        int playerHandSize = game.getPlayer1().getHand().size();
//
//        assertThat("Player has max 5 card in his hand deck", playerHandSize, is(5));
//    }
//}
