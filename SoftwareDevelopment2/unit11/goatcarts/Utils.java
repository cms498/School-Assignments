package goatcarts;

import java.util.*;

/**
 * A class that provides some useful utilities for implementing the Goat 
 * Carts simulation.
 */
public class Utils {
    /**
     * A random number generator.
     */
    private static final Random RNG = new Random();

    /**
     * A collection of common goat first names.
     */
    private static final String[] FIRST_NAMES = {
            "Goaty", "Goat", "Dale", "Richard", "Kyle", "Bleaty", "Bleats",
            "Beauregard", "Darrell", "Harold", "Jessica", "Bobby", "Cale",
            "David", "Janet", "Danica", "Jim", "Randall", "Goatbert", "Tippy",
            "Hairy", "Kurt", "Hairold", "Beardy", "Kiddo", "Chase"
    };

    /**
     * A collection of common goat last names.
     */
    private static final String[] LAST_NAMES = {
        "McGoatface", "Bleaterson", "Bleater", "Bahramewe", "Goathardt",
        "Sharma", "Goatson", "McGoat", "O'Goater", "Bush", "Allison",
        "Spiner", "Stewart", "McBleater", "Waltrip", "Fisher", "Petty",
        "Goaton", "Reynolds", "Hairybutt", "McHoof", "McHairy", "O'Horns"
    };

    /**
     * A collection of common goat suffixes.
     */
    private static final String[] SUFFIXES = {
            "Esq.", "Jr.", "Sr.", "III", "IV"
    };

    /**
     * Returns a random number between min and max (exclusive).
     *
     * @param min The minimum possible value.
     * @param max The maximum possible value.
     * @return A number between min and max (inclusive).
     */
    public static int getRandomNumber(int min, int max) {
        return RNG.nextInt(max - min) + min + 1;
    }

    /**
     * Returns a double between 0.0 and 1.0 (inclusive).
     *
     * @return A double between 0.0 and 1.0 (inclusive).
     */
    public static double getRandomDouble() {
        return RNG.nextDouble();
    }

    /**
     * Makes and returns a random goat name.
     *
     * @return A randomly generated goat name.
     */
    public static String makeGoatName() {
        String name = FIRST_NAMES[RNG.nextInt(FIRST_NAMES.length)];
        String last = " " + LAST_NAMES[RNG.nextInt(LAST_NAMES.length)];

        double suffixChance = 0.10d;

        if(getRandomDouble() < 0.25d) {
            char middleInitial = (char)(getRandomNumber(65, 90));
            name += " " + middleInitial + ".";
            suffixChance = 0.75d;

        }

        name += " " + last;

        if(getRandomDouble() < suffixChance) {
            name += " " + SUFFIXES[RNG.nextInt(SUFFIXES.length)];
        }


        return name;
    }

    /**
     * Tests goat name generation.
     *
     * @param args Ignored.
     */
    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            System.out.println(makeGoatName());
        }
    }
}
