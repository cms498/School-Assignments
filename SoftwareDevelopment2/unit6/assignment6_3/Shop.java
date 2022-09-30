/**
 * This program is the main method for the Sushi shop, it allows the customer to order types of sushi
 * place the sushi into a bag and allow the customer to eat the sushi in the end
 * 
 * Author: Chris Shepard
 */

package assignment6_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Shop {
    /**
     * This method creates a HashMap where the key is the sushi number
     * and the value is the sushi object with that number
     * @return the "display"
     */
    public static HashMap<Integer, Sushi> makeDisplay(){
        HashMap<Integer, Sushi> display = new HashMap<>();
        for(int i = 0; i < 25; i ++){
            display.put(i, new Sushi(i));
        }
        return display;
    }

    /**
     * This method creates a set of values that customer wants from a int array
     * @param input 
     * @return the HashSet of choices
     */
    public static HashSet<Integer> wantedList(int[] input){
        HashSet<Integer> choices = new HashSet<>();
        for(int i = 0; i < input.length; i++){
            choices.add(input[i]);
        }
        return choices;
    }

    /**
     * This method makes an order given a map and set
     * loops through the set and sees if that value is in the map
     * if it is, add that value to the bag and remove from the display
     * @param display
     * @param customerList
     * @return order
     */
    public static Order makeOrder(HashMap<Integer, Sushi> display, HashSet<Integer> customerList){
        PriorityQueue<Sushi> bag = new PriorityQueue<>();
        for(Integer value : customerList){
            if(display.containsKey(value)){
                bag.add(display.get(value));
                display.remove(value);
            }
        }
        Order order = new Order(bag);
        return order;
    }

    /**
     * method for eating the sushi, takes in a order
     * loops until the bag is empty
     * @param order
     */
    public static void eatSushi(Order order){
        PriorityQueue<Sushi> bag = order.getBag();
        while(bag.peek() != null){
            System.out.println("Eating Sushi " + bag.remove() + " ... yum!");
        }
    }

    /**
     * Main method where the scanner is used as well as dialogue is printed
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Shinji's Sushi Shop! Place your order with numbers between 0 - 24");
        HashMap<Integer, Sushi> display = makeDisplay();

        System.out.print("The cashier takes your order: ");
        String line = scanner.nextLine();
        String[] sinput = line.split(" ");
        int[] input = new int[sinput.length];
        for(int i = 0; i < input.length; i++){
            input[i] = Integer.parseInt(sinput[i]);
        }

        HashSet<Integer> customerList = wantedList(input);

        scanner.close();

        System.out.println("The cashier prepares your order.");

        Order order = makeOrder(display, customerList);
        System.out.println("That will be $" + order.getCost());

        System.out.println("Here is your order, please come again.");
        System.out.println("Back at your apartment, you take out your sushi and eat it ...");

        eatSushi(order);
    }
}