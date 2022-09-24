
/*
File name: Card.java
Author: Nafis Saadiq Bhuiyan
Colby ID: 778267
Last modified: 09/19/2022
Course: CS231B
Lab Section: CS231LC
Project 1 
 
*/
public class Card {

    /**
     * The value of the card.
     */
    private int value;

    /**
     * Constructs a card with the specified value.
     * @param val
     */
    public Card(int val) {
        
        value = val;
        
    }

    /**
     * Returns the value of the card.
     * @return the value of the card
     */
    public int getValue() {
        
        return value;
    }
    
    /**
     * Returns a string representation of this card.
     * @return a string representation of this card
     */
    public String toString() {
          
        String s = String.valueOf(value);

        
        return s ;
    }
}