package activities;

import java.util.Comparator;
import knapsack.Item;


public class PPPComparator implements Comparator<Item>{
    @Override
    public int compare(Item a, Item b) {
        double aPPP = (double)a.getValue() / (double)a.getWeight();
        double bPPP = (double)b.getValue() / (double)b.getWeight();
        double difference = bPPP - aPPP;
        if(difference < 0){
            return -1;
        } else if (difference > 0){
            return 1;
        } else {
            return 0;
        }
    }
}