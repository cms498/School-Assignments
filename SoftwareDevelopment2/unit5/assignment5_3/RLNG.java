/**
 * This program simulates creating a Random Number Generator
 * 
 * Author: Chris Shepard
 */

package assignment5_3;

import java.util.Iterator;
import java.util.Random;

public class RLNG implements Iterable<Integer>, Iterator<Integer> {
    private int seed;
    private Random RNG;
    private int x;
    private static final long MOD = Integer.MAX_VALUE + 1L;
    private long A = 123L;
    private long B = 456789L;
    private int index = 1;
    private int previous = 0;

    /**
     * First basic constructor for the RLNG class
     * @param seed sets the random seed
     */
    public RLNG(int seed){
        this.seed = seed;
        RNG = new Random(this.seed);
        this.x = 1;
    }

    /**
     * Second basic constructor for the RLNG class
     * uses the system time for a seed
     */
    public RLNG(){
        this.seed = (int)(java.time.LocalDateTime.now().getNano());
        RNG = new Random(this.seed);
        this.x = 1;
    }

    /**
     * Used if a seed if a bound is given, 
     * @param bound
     * @return a random number between 0 and bound - 1 inclusive
     */
    public Integer next(int bound){
        return RNG.nextInt(bound);
    }

    /**
     * only allows the iterator to loop over 1000 times
     */
    @Override
    public boolean hasNext() {
        return index < 1000;
    }

    /**
     * This is where the random number formula is implemented
     * returns the int value of x at the end of each iteration
     */
    @Override
    public Integer next() {
        if(index == 1){
            this.x = (int) ((A * (this.seed) + B) % MOD );
        } else {
            this.x = (int) ((A * (previous) + B) % MOD);
        }
        previous = this.x;
        index ++;
        return this.x;
    }

    /**
     * Creates a basic iterator for integers
     */
    @Override
    public Iterator<Integer> iterator() {
        return new RLNG();
    }

    /**
     * Main method where everything is tested and printed
     * @param args
     */
    public static void main(String[] args) {
        RLNG rng = new RLNG(1);
        RLNG no_seed = new RLNG();
        System.out.println(rng.next());
        System.out.println(rng.next(10));
        System.out.println(rng.next());
        System.out.println(rng.next(20));
        System.out.println(rng.next()); 
        System.out.println(rng.next());     

        for(int num : no_seed){
            System.out.println(num);
        }

        while(rng.hasNext()){
            System.out.println(rng.next());
        }
    }
}