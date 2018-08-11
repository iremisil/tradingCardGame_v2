package home.assignment.tcg.model;

import home.assignment.tcg.commands.Draw;
import home.assignment.tcg.commands.Play;
import home.assignment.tcg.exceptions.DeckEmptyException;
import home.assignment.tcg.exceptions.NotEnoughManaException;
import home.assignment.tcg.observers.HealthObserver;
import home.assignment.tcg.observers.ManaObserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {


    private final Draw drawCommand;
    private final Play playCommand;
    private final HealthObserver healthObserver;
    private final ManaObserver manaObserver;

    private int mana = 0;
    private int health = 30;
    private ArrayList<Integer> cardList = new ArrayList(Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 8));
    private String playerName;
    private List<Integer> hand;


    public Player(String playerName) throws DeckEmptyException {
        this.setPlayerName(playerName);
        drawCommand = new Draw(this);
        playCommand = new Play(this);
        healthObserver = new HealthObserver(this);
        manaObserver = new ManaObserver(this);
        this.initHand();
    }

    public Integer play(int chosenCardIndex) throws NotEnoughManaException {
        return this.playCommand.execute(chosenCardIndex);
    }

    public void draw() throws DeckEmptyException {

        // draw card and remove from deck
        Integer card = this.drawCommand.execute();
        // if hand is full, the drawn card is discarded.
        if (this.getHand().size() < 5)
            this.getHand().add(card);
    }

    private void initHand() throws DeckEmptyException {
        this.hand = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            this.draw();
        }

    }


    public boolean canPlayCard() {
        boolean playable = false;
        for (int card : this.getHand()) {
            if (card <= this.getMana()) {
                playable = true;
                break;
            }
        }
        return playable;
    }


    public void setCardList(ArrayList<Integer> cardList) {
        this.cardList = cardList;
    }

    public void setHand(List<Integer> hand) {
        this.hand = hand;
    }

    public List<Integer> getHand() {
        return hand;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public ArrayList<Integer> getCardList() {
        return cardList;
    }

    public HealthObserver getHealthObserver() {
        return healthObserver;
    }

    public ManaObserver getManaObserver() {
        return manaObserver;
    }

}


