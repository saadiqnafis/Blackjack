/*
File name: Deck.java
Author: Nafis Saadiq Bhuiyan
Colby ID: 778267
Last modified: 09/19/2022
Course: CS231B
Lab Section: CS231LC
Project 1 
 
*/

import java.util.ArrayList;
import java.util.Random;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

public class Deck {

    ArrayList<Card> deck;

    /**
     * Creates the underlying deck as an ArrayList of Card objects. 
     * Calls build() as a subroutine to build the deck itself.
     */
    public Deck() {

        deck = new ArrayList<Card>();
        build();
        //shuffle();
    }

    /**
     * Builds the underlying deck as a standard 52 card deck. 
     * Replaces any current deck stored. 
     */
    public void build() {
        Card c1 = new Card(2);
        int a1 = c1.getValue();
        while (a1 <10) {
            for (int i=0; i<4; i++) {
                deck.add(c1);
            }
            a1++; 
            c1 = new Card(a1);  
            
        }
        for (int i=0; i<4; i++) {
            c1 = new Card(11);
            deck.add(c1);
        }
        for (int i=0; i<16; i++) {
            c1 = new Card(10);
            deck.add(c1);
           
        }

       
        
    }

    /**
     * Returns the number of cards left in the deck. 
     * @return the number of cards left in the deck
     */
    public int size() {
        return deck.size();
    }

    /**
     * Returns and removes the first card of the deck.
     * @return the first card of the deck
     */
    public Card deal() {
        Card c3 = deck.get(0);
        
        deck.remove(deck.get(0));
        return c3;

    }

    /**
     * Shuffles the cards currently in the deck. 
     */
    public void shuffle() {
        
        Random r = new Random();
        for (int i = deck.size()-1; i > 0; i--) {
              
            
            int j = r.nextInt(i);
            Card b1 = deck.get(i);
            Card b2 = deck.get(j);
            deck.set(i, b2);
            deck.set(j, b1);
        }
            
    }

    /**
     * Returns a string representation of the deck.
     * @return a string representation of the deck
     */
    public String toString() {
        String s = String.valueOf(deck);
        
        return s ;
    }
}