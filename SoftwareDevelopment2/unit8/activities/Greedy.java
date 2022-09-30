package activities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import knapsack.Item;
import knapsack.ItemSets;
import knapsack.Knapsack;

public class Greedy {
    public static List<Currency> makeChange(double price, double payment){
        // let remaining be the difference between price and payment
        double remaining = payment - price;
        // create an empty list of currency
        List<Currency> coins = new ArrayList<>();
        // as long as remaining is > 0, determine the largest currency
        while(remaining > 0){
            // add to the list, subtract from remaining
            if(remaining >= Currency.DOLLAR.getValue()){
                coins.add(Currency.DOLLAR);
                remaining -= Currency.DOLLAR.getValue();
            } else if(remaining >= Currency.QUARTER.getValue()){
                coins.add(Currency.QUARTER);
                remaining -= Currency.QUARTER.getValue();
            } else if(remaining >= Currency.DIME.getValue()){
                coins.add(Currency.DIME);
                remaining -= Currency.DIME.getValue();
            } else if(remaining >= Currency.NICKEL.getValue()){
                coins.add(Currency.NICKEL);
                remaining -= Currency.NICKEL.getValue();
            } else {
                coins.add(Currency.PENNY);
                remaining -= Currency.PENNY.getValue();
            }
        }
        // return the list
        return coins;
    }

    public static Knapsack packItems(Knapsack sack, List<Item> items){
        //start with the first value in the items list, try every item in the set, using the items
        // sorted by the ratio of price and weight - make a new comparator
        // if it exceeds the sacks weight, try the next combo, hold onto the best sack
        //remove the item from the items list and add it to the sack - continue while the list is not empty
        // return the sack
        Collections.sort(items, new PPPComparator());
        while(items.size() > 0){
            Item next = items.remove(0);
            sack.pack(next);
        }
        return sack;
    }

    public static void main(String[] args) {
        // double price = 15.37;
        // double payment = 20.00;
        // List<Currency> change = makeChange(price, payment);
        // System.out.println(change);
        Knapsack sack = new Knapsack(10);
        packItems(sack, ItemSets.electronicsSet());
        System.out.println(sack);
    }
}