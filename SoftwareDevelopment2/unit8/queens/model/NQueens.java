package queens.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import backtracker.Configuration;

public class NQueens implements Configuration {
    private final int n; // number of queens
    private final Queen[] queens;

    public NQueens(int n){
        this (n, null);
    }

    public NQueens(int n, Queen[] queens){
        this.n = n;
        if(queens == null){
            this.queens = new Queen[0];
        } else {
            this.queens = queens;
        }
    }

    @Override
    public Collection<Configuration> getSuccessors() {
        int length = queens.length;
        List<Configuration> successors = new ArrayList<>();
        int row = length;
        if(row < n){
            for(int col = 0; col < n; col++){
                Queen[] copy = Arrays.copyOf(queens, length + 1);
                copy[length] = new Queen(row, col);
                NQueens successorConfig = new NQueens(n, copy);
                successors.add(successorConfig);
            }
        }
        return successors;
    }

    @Override
    public boolean isValid() {
        int length = queens.length;
        if(length < 2){
            return true;
        }
        Queen last = queens[length - 1];
        for(int i = 0; i < length - 1; i++){
            if(last.canAttack(queens[i])){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isGoal() {
        return isValid() && queens.length == n;
    }

    @Override
    public String toString(){
        return "N = " + n  + ": "+ Arrays.toString(this.queens);
    }

    public Queen[] getQueens() {
        return queens;
    }

    public static void main(String[] args) {
        NQueens queens = new NQueens(4);
        System.out.println(queens);
        Collection<Configuration> successors = queens.getSuccessors();
        for(Configuration config : successors){
            System.out.println(config);
        }
        System.out.println("Valid Config: " + queens.isValid());
        System.out.println("Finished : " + queens.isGoal());
    }
}