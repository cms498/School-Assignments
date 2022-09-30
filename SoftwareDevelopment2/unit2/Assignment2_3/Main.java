/**
 * This program is where the roulette game will run and display the total amount won
 * 
 * Author: Chris Shepard
 */
package Assignment2_3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final Random RNG = new Random();

    /**
     * Prompts the user to enter their string for betting
     * @return the inputted string
     */
    public static String betString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your bets ($ #/R/B, $ #/R/B, ...): ");
        String string = scanner.nextLine();
        scanner.close();
        return string;
    }

    /**
     * Given a string, an array of bet objects is created
     * @param input
     * @return an array of bet objects
     */
    public static Bet[] makeAllBets(String input) {
        String[] tokens = input.split(", ");
        Bet[] bets = new Bet[tokens.length];
        for(int i = 0; i < tokens.length; i++){
            String[] splitted = tokens[i].split(" ");
            int bet = Integer.parseInt(splitted[0]);
            String location = splitted[1];
            Bet b = new Bet(bet, location);
            bets[i] = b;
        }
        return bets;
    }

    /**
     * calculates the total winnings of the players
     * @param bets
     * @param location
     * @return total winnings
     */
    public static int calculateWinnings(Bet[] bets, String location, String color){
        int total = 0;
            for(int i = 0; i < bets.length; i++){
                if(bets[i].getLocation().charAt(0) == color.charAt(0)){
                    total += bets[i].getBet() * 2;
                } else if (bets[i].getLocation().equals(location)){
                    total+= bets[i].getBet() * 36;
                }
            }
        return total;
    }
    
    /**
     * Game "loop" where all of the functions are called and a round of roulette is played
     * @param args
     */
    public static void main(String[] args) {
        int location = RNG.nextInt(37);

        Color color;
        if (location == 0){
            color = Color.GREEN;
        } else if (location % 2 == 0){
            color = Color.BLACK;
        } else {
            color = Color.RED;
        }
        String locationString = location + "";
        String colorString = color + "";

        String betString = betString();
        Bet[] bets = makeAllBets(betString);
        int total = calculateWinnings(bets, locationString, colorString);

        System.out.println("The Wheel Spins...");
        System.out.println("It lands on " + location + " " + colorString + "!");
        System.out.println("You won $" + total);
    }
}