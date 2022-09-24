/*
File name: Blackjack.java
Author: Nafis Saadiq Bhuiyan
Colby ID: 778267
Last modified: 09/19/2022
Course: CS231B
Lab Section: CS231LC
Project 1 
 
*/

import java.util.Scanner;
/*
 We declare the fields value, gameDeck, player and dealer and we use 'private' access modifier so that they are accessible within this class only. 
 */

public class Blackjack {

    private int value; 
    private Deck gameDeck;
    private Hand player;
    private Hand dealer;
    

    /*
     We set the parameter reshuffleCutoff as the value, and call a new Deck, a new Hand for the player and a new Hand for the dealer. 
     Then we shuffle the deck and call the reset method.
     */
    public Blackjack(int reshuffleCutoff) {
        
        value = reshuffleCutoff;
        gameDeck = new Deck();
        player = new Hand();
        dealer = new Hand();
        gameDeck.shuffle();
        reset();  
    }
    /*
     We just call the other constructor so that it can get all the values from that.
     */
    public Blackjack() {
        
        this(26);
    }
    /*
    We set the parameter cutoff as the value.
     */
    public void setReshuffleCutoff(int cutoff) {
        value = cutoff;
    }
    /*
    This method returns the value.
     */
    public int getReshuffleCutoff() {
        return value;
    }

    /*
     This method takes a parameter true or false. If the parameter is true, a game is executed. If the parameter is not true, nothing is executed. At first, we reset everything by calling the reset() method,
     then we deal out two cards to both the player and dealer. After that, we use a if/else loop to see whether the player/dealer has already encountered a burst.
     If one encounters a burst, the other automatically wins the game. If both avoided a burst, we use our if/else loop to see who has the larger value and find the winner.
     If both participants have same value, then it's a tie.
     */
    public int game(boolean verbose) {
        reset();
        deal();
        if (verbose == true) {    
            if (playerTurn() == true) {
                if (dealerTurn() == true) {
                    int i1 = player.getTotalValue();
                    int i2 = dealer.getTotalValue();
                    System.out.println("Player: "+player.toString()+ ", Player total = "+ player.getTotalValue()+", " + "Dealer: "+ dealer.toString() + ", Dealer total = "+dealer.getTotalValue());
                    
                    if (i1 < i2) {
                        System.out.println("The dealer wins.");
                        return -1;

                    }
                    else if (i1 > i2) {
                        System.out.println("The player wins.");
                        return 1;
                    }
                    else {
                        System.out.println("It's a tie.");
                        return 0;
                    }  
                }

                else {
                    System.out.println("Player: "+player.toString()+ ", Player total = "+ player.getTotalValue()+", " + "Dealer: "+ dealer.toString() + ", Dealer total = "+dealer.getTotalValue());
                    System.out.println("The player wins.");
                    return 1;
                }
            }
            else {
                System.out.println("Player: "+player.toString()+ ", Player total = "+ player.getTotalValue()+", " + "Dealer: "+ dealer.toString() + ", Dealer total = "+dealer.getTotalValue());
                System.out.println("The dealer wins.");
                return -1;
            }
                
        }
        else {
            return 2;
        }
    }
    /*
    This method is almost the same as the game method. It takes the Ace rule in consideration. It also takes a parameter true or false. If the parameter is true, a game is executed. If the parameter is not true, nothing is executed. At first, we reset everything by calling the reset() method,
     then we deal out two cards to both the player and dealer. After that, we use a if/else loop to see whether the player/dealer has already encountered a burst.
     If one encounters a burst, the other automatically wins the game. If both avoided a burst, we use our if/else loop to see who has the larger value and find the winner.
     If both participants have same value, then we see whether the tie occurs at the value 21. If it occurs at 21, we check whether any participant has got a sum of 21 with just only 2 cards.
     This condition is called Blackjack. And a blackjack beats a 21 with more than 2 cards.
     */
    public int gameAce(boolean bool) {
        reset();
        deal();
        String str = player.toString();
        String str1 = dealer.toString();
        System.out.println("Player initial: "+ str+", Player initial total = "+ player.getTotalValue()+ ", " + "Dealer initial: "+ str1 + ", "+ "Dealer initial total = "+dealer.getTotalValue());
        if (bool == true) {    
            if (playerTurn() == true) {
                if (dealerTurn() == true) {
                    int i1 = player.getTotalValue();
                    int i2 = dealer.getTotalValue();
                    System.out.println("Player final: "+player.toString()+ ", "+ "Player final total = "+ player.getTotalValue()+", " + "Dealer final: "+ dealer.toString() + ", "+ "Dealer final total = "+dealer.getTotalValue());
                    
                    if (i1 < i2) {
                        
                        System.out.println("The dealer wins.");
                        return -1;

                    }
                    else if (i1 > i2) {
                        System.out.println("The player wins.");
                        return 1;
                    }
                    else if (i1 == 21) {
                        int m1 = player.size();
                        int m2 = dealer.size();
                            if (m1 == 2 && m2 != 2) {
                                System.out.println("The player wins.");
                                return 1;
                            }
                            else if (m1 != 2 && m2 == 2) {
                                System.out.println("The dealer wins.");
                                return -1;
                            }
                            else {
                                System.out.println("It's a tie.");
                                return 0;
                            }
                                
                    }
                    else {       
                        System.out.println("It's a tie.");
                        return 0;
                    }  
                }

                else {
                    System.out.println("Player final: "+player.toString()+  ", Player final total = "+ player.getTotalValue()+", " + "Dealer final: "+ dealer.toString() + ", Dealer final total = "+dealer.getTotalValue());
                    System.out.println("The player wins.");
                    return 1;
                }
            }
            else {
                System.out.println("Player final: "+player.toString()+ ", "+ "Player final total = "+ player.getTotalValue()+", " + "Dealer final: "+ dealer.toString() + ", Dealer final total = "+dealer.getTotalValue());
                System.out.println("The dealer wins.");
                return -1;
            }
            
        }
        else {
            return 2;
        }

    }

    /*
    This playerTurnInteractive() method helps us to play a game in the terminal. At first, we reset the game by calling the reset() method. Then we deal out two cards to both the dealer and
    the player by using the deal() method. Then we convert the player hand into string by calling the toString() method. We print the initial hand and the inital total.
    After that, we ask the player to take a card (Hit) or not (Stand). If the player takes a card and the new sum is greater than 21, then it's a bust and the dealer wins. If the player chooses to take
    another card, then he has that opportunity as long as he doesn't bust or stand. When the player stands, then it's the dealer turn. After taking a card, if the new sum of the cards of the dealer is more than 21,
    then it's a bust and the player wins the game. If both the contestants avoid a bust, then we compare the sum. The contestant whose sum is more is the winner. Again, if the sum is equal, then it's a tie.
    But we take the Ace rule into consideration as well in this interactive method. We described that rule in the gameAce method.
     */

    public void playerTurnInteractive() {
        reset();
        deal();
        String str = player.toString();
        System.out.println("Player initial: "+ str+", Player initial total = "+ player.getTotalValue());

        int i1 = player.getTotalValue();
        
        while (i1 <= 21) {
            
            Scanner ourObj1 = new Scanner(System.in);
            System.out.println("It's the player's turn. Player, do you want to Stand or Hit?");
            System.out.println("Enter Stand or Hit");
            String hit = "Hit";
            String stand = "Stand";
            String input = ourObj1.nextLine();
            if (input.equals(hit) == true) {
                Card c3 = gameDeck.deal();
                player.add(c3);
                i1 += c3.getValue();
                System.out.println("Player: "+ player.toString()+ ", "+ "Player total: "+player.getTotalValue());
                if (player.getTotalValue() > 21) {
                    
                    System.out.println("It's a bust. The dealer wins.");
                    break;
                }
            }
            else if (input.equals(stand) == true) {
                System.out.println("Player: "+ player.toString()+ ", "+ "Player total: "+player.getTotalValue());
                System.out.println("Now, it's the dealer's turn");
                if (dealerTurn() == true) {
                    int playerTotal = player.getTotalValue();
                    int dealerTotal = dealer.getTotalValue();
                    System.out.println("Player final: "+player.toString()+ ", "+ "Player final total = "+ player.getTotalValue()+", " + "Dealer final: "+ dealer.toString() + ", "+ "Dealer final total = "+dealer.getTotalValue());
                    
                    if (playerTotal < dealerTotal) {
                        
                        System.out.println("The dealer wins.");
                        break;
                        
        
                    }
                    else if (playerTotal > dealerTotal) {
                        System.out.println("The player wins.");
                        break;
                        
                    }
                    else if (playerTotal == 21) {
                        int m1 = player.size();
                        int m2 = dealer.size();
                            if (m1 == 2 && m2 != 2) {
                                System.out.println("The player wins.");
                                break;
                                
                            }
                            else if (m1 != 2 && m2 == 2) {
                                System.out.println("The dealer wins.");
                                break;
                                
                            }
                            else {
                                System.out.println("It's a tie.");
                                break;
                                
                            }
                                
                    }
                    else {       
                        System.out.println("It's a tie.");
                        break;
                        
                    }  
                }
        
                else {
                    System.out.println("Player final: "+player.toString()+  ", Player final total = "+ player.getTotalValue()+", " + "Dealer final: "+ dealer.toString() + ", Dealer final total = "+dealer.getTotalValue());
                    System.out.println("The player wins.");
                    break;
        
                }
            }

        }
          
    }
    /*
    Here, we first get the total value of player hand. If it's less than 16, then we take a card. We do it as long as the sum is less than 16. If the sum exceeds 21, we return false, that indicates that the player has lost.
     */

    public boolean playerTurn() {

        int i1 = player.getTotalValue();
        while (i1 < 16) {
            Card c2 = gameDeck.deal();
            player.add(c2);
            i1 += c2.getValue();
        }
        int i2 = player.getTotalValue();
        if (i2 > 21) {
            return false;
        }
        else {
            return true;
        }
    }
    /*
    Here, we first get the total value of dealer hand. If it's less than 17, then we take a card. We do it as long as the sum is less than 17. If the sum exceeds 21, we return false, that indicates that the dealer has lost.
     */
    public boolean dealerTurn() {
        int i1 = dealer.getTotalValue();
        while (i1 < 17) {
            Card c2 = gameDeck.deal();
            dealer.add(c2);
            i1 += c2.getValue();
        }

        if (dealer.getTotalValue() > 21) {
            return false;
        }
        else {
            return true;    
        } 
    }
    /*
    We call the reset() method from the Hand class and reset the player and dealer hands. Then we check the deck size. If it is less than our reshufflecutoff value, then we shuffle the deck.
     */
    public void reset() {
        player.reset();
        dealer.reset();
        if (gameDeck.size() < value) {
            gameDeck.shuffle();
        }
    }

    /*
    The purpose of the deal() method is to add two cards to each of the player and dealer hands.
     */
    public void deal() {
        for (int i=0; i<2; i++) {
            Card c2 = gameDeck.deal();
            player.add(c2);
        }
        for (int i=0; i<2; i++) {
            Card c4 = gameDeck.deal();
            dealer.add(c4);
        }  
    }

    /*
    The toString() method converts the player and dealer hands into strinf and returns the string.
     */
    public String toString() {
        String s1 = player.toString(); 
        String s2 = "Player total: ";
        s2 += player.getTotalValue();

        String s3 = dealer.toString(); 
        String s4 = "Dealer total: ";
        s4 += dealer.getTotalValue();

        return s1 + s2 + " "+ s3 + s4 + " ";   
    }

    /*
    Our main method implements three Blackjack games. To do this, we assign myObj as a new Blackjack(), and then call myObj.game(true) three times, which provides us the result.
     */
    public static void main(String[] args) {

        Blackjack myObj = new Blackjack();
        myObj.game(true);
        myObj.game(true);
        myObj.game(true);

    }


}