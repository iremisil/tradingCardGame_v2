package home.assignment.tcg;

import home.assignment.tcg.exceptions.DeckEmptyException;
import home.assignment.tcg.exceptions.NotEnoughManaException;
import home.assignment.tcg.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    public Player current;
    public Player opponent;

    public List<Observer> observers;
    boolean newTurn = true;


    public Game() throws DeckEmptyException {
        player1 = new Player("Player1");
        player2 = new Player("Player2");
        observers = new ArrayList<>();

    }

    public void initGame() {


        int round = 0;

        while (true) {
            if (round % 2 == 0) {
                initRound(player1, player2);
            } else {
                initRound(player2, player1);
            }

            try {
                if (this.newTurn)
                    current.draw();

                Scanner scan = new Scanner(System.in);
                // display instructions
                System.out.println("Player : " + current.getPlayerName());
                System.out.println("Your Cards are : " + current.getHand());
                System.out.println("Your Mana is : " + current.getMana());
                System.out.println("Your health is : " + current.getHealth());

                if (!this.current.canPlayCard()) {
                    this.newTurn = true;
                    round++;
                    continue;
                }

                System.out.println("Please choose your card or skip(Please enter 9)");
                // get choosen card index
                int choosenCardIndex = scan.nextInt();

                if (choosenCardIndex > 0 && choosenCardIndex < 5) {

                    // get dmg done
                    Integer damage = current.play(choosenCardIndex);
                    // update both sides for mana loss and dmg done
                    this.current.getManaObserver().update(damage);
                    this.opponent.getHealthObserver().update(damage);

                    System.out.println("Current mana: " + this.current.getMana());
                    System.out.println("Opponent health: " + this.opponent.getHealth());
                    System.out.println("##########");

                    if (this.current.canPlayCard()) {
                        this.newTurn = false;
                    } else {
                        round++;
                        this.newTurn = true;
                    }

                } else {
                    System.out.println("Pick card index between 1-5");
                    this.newTurn = false;
                }

            } catch (DeckEmptyException e) {
                System.out.println(e.getMessage());
                this.current.getHealthObserver().update(1);
            } catch (NotEnoughManaException e) {
                System.out.println(e.getMessage());
                this.newTurn = false;
            }

        }
    }

    private void initRound(Player current, Player opponent) {
        this.current = current;
        this.opponent = opponent;
        if (this.newTurn)
            this.current.getManaObserver().update(1);
    }


    public Player getPlayer1() {
        return this.player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }
}

