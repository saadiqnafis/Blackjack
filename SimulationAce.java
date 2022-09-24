/*
File name: SimulationAce.java
Author: Nafis Saadiq Bhuiyan
Colby ID: 778267
Last modified: 09/19/2022
Course: CS231B
Lab Section: CS231LC
Project 1 
 
*/

public class SimulationAce {
    /* In our main method, we assign three variables to count the number of player wins, dealer wins and tie.
     Then we call Blackjack from the Blackjack class and assign a new Blackjack named 'game'. We use a for loop for running the game 1000 times.
     After that, we call the gameAce method that returns -1,0,1 on the basis of who wins and also prints our result.
     We keep the count of wins by using the if/else loop.
     After finishing counting, we convert the numbers into percentages and print them.
     */
    public static void main(String[] args) {

        int playerWin = 0;
        int dealerWin = 0;
        int push = 0;
        //int something = 0;
        for (int i=0; i<1000; i++) {
            Blackjack game = new Blackjack(26);
            int i1 = game.gameAce(true);
            if (i1 == 0) {
                push +=1;

            }
            else if (i1 == 1) {
                playerWin += 1;

            }

            else if (i1 == -1) {
                dealerWin +=1;

            }
            
        }


        double i3 = (playerWin / 1000.00)*100;
        double i4 = (dealerWin / 1000.00)*100;
        double i5 = (push / 1000.00)*100;
        System.out.println("Player win: "+ playerWin+" games, "+i3+"%");
        System.out.println("Dealer win: "+dealerWin+ " games, " + i4+ "%");
        System.out.println("Push: "+push+ " games, " + i5+ "%");
    }
        
    
    
    
}
