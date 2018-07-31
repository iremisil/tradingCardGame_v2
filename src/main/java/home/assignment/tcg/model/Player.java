package home.assignment.tcg.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {


    private int mana = 0;
    private int health = 30;
    private ArrayList<Integer> cardList = new ArrayList(Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 8));
    private String playerName;
    private List<Integer> hand = new ArrayList();


    public List<Integer> getHand() {
        return hand;
    }

    public void setHand(List<Integer> hand) {
        this.hand = hand;
    }

    public Player(String playerName) {
        this.setPlayerName(playerName);
        initHand();
    }

    private void initHand() {
        while (hand.size() < 3) {
            hand.add(getRandomCard());
        }
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana <= 10) {
            this.mana = mana;
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0)
            this.health = 0;
        this.health = health;
    }

    public int getRandomCard() {
        // pick random card
        int index = new Random().nextInt(cardList.size());
        int damage = cardList.get(index);
        // card was already drawn before
        if (damage == -1) {
            getRandomCard();
        } else {
            // card is now drawn
            cardList.remove(index);
        }
        // hit
        return damage;
    }

    public void drawCard() {
        if (this.getCardList().size() > 0) {
            int randomCard = getRandomCard();
            if (hand.size() < 5) {
                hand.add(randomCard);
            }
        }
    }

    public Integer playCard(int choosenCardIndex) {
        return hand.get(choosenCardIndex - 1);
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

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public ArrayList<Integer> getCardList() {
        return cardList;
    }
}


