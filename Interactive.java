/*
File name: Interactive.java
Author: Nafis Saadiq Bhuiyan
Colby ID: 778267
Last modified: 09/19/2022
Course: CS231B
Lab Section: CS231LC
Project 1 
*/

import java.util.Random;

public class Interactive {
    
    /*
    In the main method, we call Blackjack from the Blackjack class and assign a new Blackjack named 'gameBlackjack'. Then we call the playerTurnInteractive() method to play the game in the terminal.
     */
    public static void main(String[] args) {
        Blackjack gameBlackjack = new Blackjack();
        gameBlackjack.playerTurnInteractive();
    }

}

