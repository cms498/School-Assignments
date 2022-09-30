/**
 * This program uses a greedy algorithm approach to determine the 
 * maximum number of tasks you can fit into a specifc time frame
 * 
 * The algorithm loops over the list of tasks and finds the shortest
 * one, it adds it to the subset and repeats until the time is essentially full
 * this will get the correct answers everytime, however it is quite innefficient
 * 
 * Author: Chris Shepard
 */

package assignment13_1;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String name;
    private int time;

    /**
     * Basic constructor for a task, it initilizes values
     * @param name
     * @param time
     */
    public Task(String name, int time){
        this.name = name;
        this.time = time;
    }

    /**
     * This method is where the logic for the algorithm is
     * @param tasks
     * @param maxTime
     * @return subset of the maximum number of tasks
     */
    public static List<Task> sort(List<Task> tasks, int maxTime){
        List<Task> subset = new ArrayList<>();
        int smallestTime = (int)Double.POSITIVE_INFINITY;
        Task lowest = new Task("fake", 9);
        for(int i = 0; i < tasks.size(); i++){
            for(int j = 0; j < tasks.size(); j++){
                if(tasks.get(j).getTime() < smallestTime){
                    smallestTime = tasks.get(j).getTime();
                    lowest = tasks.get(j);
                }
            }
            smallestTime = (int)Double.POSITIVE_INFINITY;
            tasks.remove(lowest);
            subset.add(lowest);
            int totalTime = 0;
            for(int k = 0; k < subset.size(); k++){
                totalTime += subset.get(k).getTime();
            }
            if(totalTime > maxTime){
                subset.remove(subset.size() - 1);
                break;
            }
        }
        return subset;
    }

    /**
     * getter method for the tasks name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getter method for the tasks time
     * @return time
     */
    public int getTime() {
        return time;
    }

    /**
     * Allows for printing of the tasks object
     */
    @Override
    public String toString(){
        return name + "(" + time + " hour)";
    }
}