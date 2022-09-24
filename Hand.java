/*
File name: Hand.java
Author: Nafis Saadiq Bhuiyan
Colby ID: 778267
Last modified: 09/19/2022
Course: CS231B
Lab Section: CS231LC
Project 1 
 
*/

import java.util.ArrayList;

public class Hand {

    
    private ArrayList<Card> hand;

    /**
     * Creates an empty hand as an ArrayList of Cards.  
     */
    public Hand() {
        hand = new ArrayList<Card>();
        
    }

    /**
     * Removes any cards currently in the hand. 
     */
    public void reset(){
        
        for (int i=0; i < hand.size(); i++) {
            
            hand.remove(i);
        }

    }

    /**
     * Adds the specified card to the hand.
     * @param card the card to be added to the hand
     */
    public void add(Card card) {
            
        hand.add(card);
    }

    /**
     * Returns the number of cards in the hand.
     * @return the number of cards in the hand
     */
    public int size(){
        return hand.size();
    }

    /**
     * Returns the card in the hand specified by the given index. 
     * @param index the index of the card in the hand.
     * @return the card in the hand at the specified index.
     */
    public Card getCard(int index){
        return hand.get(index);
    }

    /**
     * Returns the summed value over all cards in the hand.
     * @return the summed value over all cards in the hand
     */
    public int getTotalValue(){
        int sum = 0;
        for (int i=0; i<hand.size(); i++) {

            Card n1 = hand.get(i);
            int n2 = n1.getValue();
            sum += n2;
            
        }
        return sum;
        
    }

    /**
     * Returns a string representation of the hand.
     * @return a string representation of the hand
     */
    public String toString(){
        
        String s = "Cards in hand = " ;
        
        for (int i=0; i<hand.size(); i++) {
        
            if (i == 0) {
                s += hand.get(i).getValue();
            }
            else {
                s += ", " + hand.get(i).getValue();
            }
           
            
        }
        return s ;
    }

    public static void main(String[] args) {
        Hand test = new Hand();
        Card tCard = new Card(3);
        Card nCard = new Card(6);
        Card gCard = new Card(9);
        test.add(tCard);
        test.add(nCard);
        test.add(gCard);
        System.out.println(test.toString());
        

    }    
} 
    

