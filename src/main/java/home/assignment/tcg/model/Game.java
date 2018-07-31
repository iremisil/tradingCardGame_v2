package home.assignment.tcg.model;

import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    public Player current;


    public Game() {
        player1 = new Player("Player1");
        player2 = new Player("Player2");

    }

    public void initGame() {


        int round = 0;

        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            turn(round, false, true);
            round++;
        }
        if (player1.getHealth() == 0) {
            System.out.println("Player2 WIN!!");
        } else if (player2.getHealth() == 0) {
            System.out.println("Player1 WIN!!");
        }
    }

    public void turn(int round, boolean canPlay, boolean validInput) {


        if (round % 2 == 0) {
            makeMove(round, canPlay, validInput, player1, player2);
        } else {
            makeMove(round, canPlay, validInput, player2, player1);
        }
    }

    private void makeMove(int round, boolean canPlay, boolean validInput, Player current, Player opponent) {
        Scanner scan = new Scanner(System.in);

        if (!canPlay && validInput) {
            if (current.getCardList().size() == 0) {
                System.out.println("Your deck is empty. Your health decreased -1!!");
                current.setHealth(current.getHealth() - 1);
                if (current.getHealth() == 0) {
                    return;
                }
            }
            current.setMana(current.getMana() + 1);
            current.drawCard();
        }
        System.out.println("Player : " + current.getPlayerName());
        System.out.println("Your Cards are : " + current.getHand());
        System.out.println("Your Mana is : " + current.getMana());
        System.out.println("Your health is : " + current.getHealth());
        System.out.println("Please choose your card or skip(Please enter 9)");

        int choosenCardIndex = scan.nextInt();

        if (choosenCardIndex >= 1 && choosenCardIndex <= 5) {
            //remove card from hand and get damage
            Integer damage = current.playCard(choosenCardIndex);
            //damage to opponent
            boolean resultDamage = damageOpponent(damage, current, opponent);
            if (resultDamage) {
                current.getHand().remove(choosenCardIndex - 1);
            }
            if (current.canPlayCard())
                turn(round, current.canPlayCard(), true);


        } else if (choosenCardIndex == 9) {
            return;
        } else {
            System.out.println("Please enter valid card Index");
            turn(round, current.canPlayCard(), false);
        }
    }

    public boolean damageOpponent(Integer damage, Player current, Player opponent) {
        this.current = current;
        boolean result = false;
        if (current.getMana() < damage) {
            System.out.println("Not enough mana try again");
        } else {
            opponent.setHealth(opponent.getHealth() - damage);
            current.setMana(current.getMana() - damage);
            result = true;
        }
        return result;
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }
}

