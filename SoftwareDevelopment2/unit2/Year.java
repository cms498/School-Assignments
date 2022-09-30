/**
 * Program represents a year, has the ability to print and compares two years
 * 
 * Author: Chris Shepard
 */

import java.util.Arrays;
import java.util.Random;

public class Year {
    public static final int DAYS_IN_YEAR = 365;
    private final int yearNumber;
    public static final Random RNG = new Random();

    public Year(int yearNumber){
        this.yearNumber = yearNumber;
    }

    /**
     * @return current year number
     */
    public int getYearNumber() {
        return yearNumber;
    }

    /**
     * @return number of days in a year
     */
    public int numberOfDays() {
        return daysinYear(this.yearNumber);
    }

    /**
     * Computes and returns the number of days in year
     * 
     * @param year
     * @return Calculated number of the days in year
     */
    public static int daysinYear(int year) {
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            return DAYS_IN_YEAR + 1;
        }
        return DAYS_IN_YEAR;
    }

    public static Year[] parseYears(String years){
        String[] tokens = years.split(" ");
        Year[] y = new Year[tokens.length];
        for(int i = 0; i < tokens.length; i++){
            int yearNumber = Integer.parseInt(tokens[i]);
            Year year = new Year(yearNumber);
            y[i] = year;
        }
        return y;
    }

    public static Year getRandomYear(){
        int upperBound = 2021 - 1900 + 1;
        int random = RNG.nextInt(upperBound);
        int actual = random + 1900;
        Year year = new Year(actual);
        return year;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Year){
            Year other = (Year)o;
            return this.yearNumber == other.yearNumber;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return "Year{yearNumber=" + this.yearNumber + ", days=" + this.numberOfDays()+ "}"; 
    }
    public static void main(String[] args) {
        int years = daysinYear(2021);
        System.out.println("Days in 2021: " + years);
        years = daysinYear(2000);
        System.out.println("Days in 2000: " + years);

        Year y2k = new Year(2000);
        System.out.println(y2k.numberOfDays());

        Year y2k2 = new Year(2000);
        System.out.println(y2k.numberOfDays());

        Year y2100 = new Year(2100);
        System.out.println(y2100.numberOfDays());

        System.out.println(y2k.equals(y2k2));
        System.out.println(y2k.equals(y2100));

        System.out.println(y2100);

        Year[] yearArray = parseYears("2021 2000 2100");
        System.out.println(Arrays.toString(yearArray));

        System.out.println(getRandomYear());
        System.out.println(getRandomYear());
        System.out.println(getRandomYear());
    }
}