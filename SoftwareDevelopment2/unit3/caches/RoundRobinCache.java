/**
 * This program utilizes the methods in the Cache class, victims are selected in order,
 * once the end cache element has been replaced the first element is next, Round robin
 * style
 * 
 * Author: Chris Shepard
 */

package caches;

public class RoundRobinCache extends Cache{
    private int spot = 0;

    /**
     * Basic constructor for the RoundRobinCache class, takes in a filename and length of the cache
     * All functionality can be seen in Cache constructor
     * @param cacheLength
     * @param filename
     */
    public RoundRobinCache(int cacheLength, String filename){
        super(cacheLength, filename);
    }

    /**
     * This function replaces the cache elements in order from start to finish and then
     * back to the first element again
     * @param target
     */
    public void updateCache(String target){
        String[] cache = getCache();
        if(spot >= getCache().length){
            spot = 0;
        } 
        cache[spot] = target;
        spot++;
    }
    
    /**
     * Main method where the functionality of the RoundRobinCache is tested
     * @param args
     */
    public static void main(String[] args) {
        int cacheLength = 3;
        Cache RoundRobinCache = new RoundRobinCache(cacheLength, "caches/letters.txt");
        String[] queries = {"A", "E", "A", "E", "G", "E"};
        System.out.println("Testing Random Cache ...");
        for(int i = 0; i < queries.length; i++){
            String target = queries[i];
            RoundRobinCache.search(target);
            System.out.println("\nAfter search target " + target + ":"); 
            System.out.println(RoundRobinCache); 
        }
    }
}