/**
 * This program uses backtracking in order to solve a hangman game, it implements the
 * configuration interface, it has the ability to the printed at the end as well
 * the phrase being guessed it imported by the user
 * 
 * Author: Chris Shepard
 */

package assignment13_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import backtracker.Backtracker;
import backtracker.Configuration;

public class HangmanSolver implements Configuration{
    private Hangman game;
    private char guess;

    /**
     * Basic constructor, initilizes the values
     * @param game
     * @param guess
     */
    public HangmanSolver(Hangman game, char guess){
        this.game = game;
        this.guess = guess;
    }

    /**
     * Generates the list of successors from the given state
     * it just picks the letters from a to z
     */
    @Override
    public Collection<Configuration> getSuccessors() {
        List<Configuration> successors = new ArrayList<>();
        for(char c = 'a'; c <= 'z'; c++){
            Hangman deepCopy = new Hangman(this.game);
            HangmanSolver successor = new HangmanSolver(deepCopy, c);
            successors.add(successor);
        }
        return successors;
    }

    /**
     * Determines if the current decisions is possible
     */
    @Override
    public boolean isValid() {
        if(this.game.guess(this.guess) == true && this.game.getStatus() != Hangman.Status.LOST){
            return true;
        }
        return false;
    }

    /**
     * Determines if the goal is reached and game has been solved
     */
    @Override
    public boolean isGoal() {
        return this.game.getStatus().equals(Hangman.Status.WON);
    }
    
    /**
     * Allows for printing of the game and final state
     */
    @Override
    public String toString(){
        return this.game.getGuesses() + ", " + this.game.revealed();
    }

    /**
     * Main method where the user input is, as well as where the backtracker
     * is solved
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a secret phrase: ");
        String phrase = scanner.nextLine();
        Hangman game = new Hangman(phrase);
        HangmanSolver solver = new HangmanSolver(game, ' ');
        Backtracker backtracker = new Backtracker(false);
        HangmanSolver solution = (HangmanSolver)backtracker.solve(solver);
        if(solution != null){
            System.out.println(solution);
        } else {
            System.out.println("No Solution ...");
        }
        scanner.close();
    }
}