/**
 * This program utilizes the elements in the Cache class, it selects a victim at random
 * to replace in the cache if the query is found in the file
 * 
 * Author: Chris Shepard
 */

package caches;

import java.util.Random;

public class RandomCache extends Cache{
    private static Random RNG = new Random();

    /**
     * Basic constructor for the RandomCache class, takes in a filename and length of the cache
     * All functionality can be seen in Cache constructor
     * @param cacheLength
     * @param filename
     */
    public RandomCache(int cacheLength, String filename){
        super(cacheLength, filename);
    }

    /**
     * This method must be include due as it is an abstract method in the Cache class
     * A victim is chose at random and replace in the cache
     * @oaram target
     */
    public void updateCache(String target){
        int spot = RNG.nextInt(getCache().length);
        String[] cache = getCache();
        cache[spot] = target;
    }

    /**
     * Main method where the functionality of the RandomCache is tested
     * @param args
     */
    public static void main(String[] args) {
        int cacheLength = 3;
        Cache RandomCache = new RandomCache(cacheLength, "caches/letters.txt");
        String[] queries = {"A", "E", "A", "H", "G", "E"};
        System.out.println("Testing Random Cache ...");
        for(int i = 0; i < queries.length; i++){
            String target = queries[i];
            RandomCache.search(target);
            System.out.println("\nAfter search target " + target + ":"); 
            System.out.println(RandomCache); 
        }
    }
}