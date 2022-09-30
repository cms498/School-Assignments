/**
 * This program comptues the fibonacci numbers up to a n value given as a parameter
 * 
 * Author: Chris Shepard
 */

public class IterativeFib {
    public static int fib(int n) {
        int initial = 0;
        int next = 1;
        int next_2 = 1;
        if (n < 1){
            return -1;
        }
        if (n == 1){
            return 0;
        }
        for(int i = 2; i < n; i++){
            next_2 = next + initial;
            initial = next;
            next = next_2;
        }
        return next_2;
    }
    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
