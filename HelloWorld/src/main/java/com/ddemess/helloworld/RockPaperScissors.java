/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.helloworld;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author mawidemess
 */
public class RockPaperScissors {
    public static void main(String[] args) {
        boolean loop = true;
        while(loop){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("how many rounds you want to play with the computer?");

            int numRounds = myObj.nextInt();  // Read user input
            if (numRounds<1  && numRounds>10){
                System.out.println("Too big or too small of a round");
                System.exit(0);          
            } 
            int userPt =0 ;
            int computerPt =0 ;
            int numTies = 0;
            for(int i=0; i<numRounds;i++){
                Scanner newObj = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Rock = 1 or Paper = 2 or Scissors = 3");
                int userChoice = newObj.nextInt();
                Random rand = new Random();
                int computerChoice = rand.nextInt((3 - 1) + 1) + 1;
                if (computerChoice == userChoice){
                    System.out.println("This round was a draw");
                    numTies+=1;
                    //tie
                }
                else if ((userChoice==1 && computerChoice == 3)||(userChoice==3 && computerChoice == 2) || (userChoice==2 && computerChoice == 1) ){
                    System.out.println("You won this round!");
                    userPt+=1;
                }
                else{
                    System.out.println("You lost this round!");
                    computerPt+=1;
                }


            }
            System.out.println ("Number of ties: " + numTies + "\nNumber of User win: " + userPt + "\nNumber of Computer win: " + computerPt);
            if (userPt == computerPt){
                System.out.println ("The game ended in a draw");
            }
            else if (userPt>computerPt){
                System.out.println(" The winner of this game is : YOU");
            }
            else{
                System.out.println("The winner of the game is : the computer ");
            }
            Scanner ob = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Do you want to play again : Yes or No");
            String playAgain = ob.nextLine();
            if (playAgain.equals("No")){
                System.out.println("Thanks for playing!");
                loop = false;
            }
        
    }
    }
}
