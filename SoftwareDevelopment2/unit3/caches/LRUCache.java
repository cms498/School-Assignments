/**
 * This program utilizes the elements in the Cache class, a victim is chosen
 * based on the Least Recently Used model, where the more common hits
 * stay in the cache
 * 
 * Author: Chris Shepard
 */

package caches;

import java.util.Arrays;

public class LRUCache extends Cache{
    private int[] counts;
    /**
     * Basic constructor for the LRUCache class, takes in a filename and length of the cache
     * All functionality can be seen in Cache constructor
     * @param cacheLength
     * @param filename
     */
    public LRUCache(int cacheLength, String filename, int[] counts){
        super(cacheLength, filename);
        this.counts = counts;
    }

    /**
     * This method must be include due as it is an abstract method in the Cache class
     * A victim is chosen based on the LRU model
     * @oaram target
     */
    public void updateCache(String target){
        int[] counts = getCounts();
        String[] cache = getCache();
        int least = 0;
        int indexCount = 0;
        for(int i = 0; i < counts.length - 1; i++){
            if(counts[i] > least){
                indexCount++;
            } else {
                least = counts[i];
            }
        }
        cache[indexCount] = target;
        counts[indexCount] = 1;
    }

    public int[] getCounts() {
        return counts;
    }

    @Override
    public String toString(){
        return "Cache = " + Arrays.toString(getCache()) + "\nCount = " + Arrays.toString(getCounts()) +"\n#Hits = " + getHitCount() 
        + "\n#Misses = " + getMissCount();
    }
    
    /**
     * Main method where the functionality of the LRUCache is tested
     * @param args
     */
    public static void main(String[] args) {
        int cacheLength = 3;
        int[] counts = new int[cacheLength];
        Cache LRUCache = new LRUCache(cacheLength, "caches/letters.txt", counts);
        String[] queries = {"A", "E", "A", "H", "G", "E"}; 
        System.out.println("Testing LRU cache ..."); 

        for(int i = 0; i < queries.length; i++){
            String target = queries[i];
            for(int j = 0; j < LRUCache.getCache().length; j++){
                if(LRUCache.getCache()[j].equals(target)){
                    counts[j] ++;
                }
            }
            LRUCache.search(target);
            System.out.println("\nAfter search target " + target + ":"); 
            System.out.println(LRUCache);
        }

    }
}