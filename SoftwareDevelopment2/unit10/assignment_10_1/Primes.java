/**
 * This program uses lambdas given a list to print out all of the prime number inside of it
 * 
 * Author: Chris Shepard
 */

package assignment_10_1;

import java.util.ArrayList;
import java.util.List;

public class Primes{
    /**
     * This method performs a brute force algorithm to compute if the 
     * given number is prime
     * @param n
     * @return true is prime, false if not
     */
    public static boolean isPrime(int n){
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * main method where the list and lambda printing are created
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < 51; i++){
            list.add(i);
        }
        list.stream().filter(number -> isPrime(number)).forEach(System.out::println);
    }
}