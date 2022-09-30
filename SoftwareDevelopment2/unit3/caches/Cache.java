/**
 * This program houses the abstract Cache class, it provide the blueprint for all other
 * Cache based classes, it has the ability to search through the cache and file for target,
 * as well as update the cache, and finally print out the cache
 */

package caches;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public abstract class Cache {
    private int hitCount;
    private int missCount;
    private String filename;
    private String[] cache;

    /**
     * When a Cache is initlized it will read through the file and fill the Cache up to its length
     * It will also set all of the counts to zero
     * @param cacheLength
     * @param filename
     */
    public Cache(int cacheLength, String filename){
        this.hitCount = 0;
        this.missCount = 0;
        this.cache = new String[cacheLength];
        this.filename = filename;

        File file = new File(filename);
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            for(int i = 0; i < cacheLength; i++){
                cache[i] = line;
                line = bufferedReader.readLine();
            }
            fileReader.close();
            bufferedReader.close();

        } catch (IOException ioe){
            System.err.println(ioe);
        }
    }

    /**
     * This function searches through the cache for the specified target parameter
     * If it is found it returns true, else it will call the searchFile function
     * @param target
     * @return if target is found in the cache
     */
    public boolean search(String target){
        boolean found = false;
        for(int i = 0; i < this.cache.length; i++){
            if(cache[i].equals(target)){
                found = true;
                hitCount++;
                break;
            }
        }
        if(found == false){
            return searchFile(target);
        } else {
            return true;
        }
    }

    /**
     * This function searches the file for the target
     * If found it will call update cache, and increase the miss count by one
     * else it will return false
     * @param target
     * @return if the target is found in the file
     */
    public boolean searchFile(String target){
        boolean found = false;
        File file = new File(this.filename);
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while(line != null){
                if(line.equals(target)){
                    found = true;
                    missCount++;
                    break;
                }
                line = bufferedReader.readLine();
            }
            fileReader.close();
            bufferedReader.close();

        } catch (IOException ioe){
            System.err.println(ioe);
        }
        if(found == true){
            updateCache(target);
            return true;
        } else {
            return false;
        }
    }

    /**
     * This abstract class is used in the children class to Cache, it has no direct implementation
     * It updates the cache if the target is found in the file
     * @param target
     */
    abstract void updateCache(String target);

    /**
     * Getter method for hit count
     * @return hit count
     */
    public int getHitCount() {
        return hitCount;
    }

    /**
     * getter method for miss count
     * @return miss count
     */
    public int getMissCount() {
        return missCount;
    }

    /**
     * getter method for the cache
     * @return the cache
     */
    public String[] getCache() {
        return cache;
    }

    /**
     * This to string method provides the ability to print out the cache as well as the miss and hit counts
     */
    @Override
    public String toString(){
        return "Cache = " + Arrays.toString(this.cache) + "\n#Hits = " + this.hitCount + "\n#Misses = " + this.missCount;
    }
}