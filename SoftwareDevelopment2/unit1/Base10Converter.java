/**
 * This program uses the properties of the base and endiness to convert chars to ints
 * It also asks the user for an input file and in turn sees if the left column is equivalent to the right
 * 
 * Author: Chris Shepard
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Base10Converter{

    public static int charToInteger(char digit){
        //Converts a digit as a char to an integer
        return (int)digit - 48;
    }

    public static int arrayToInteger(char[] digits, int base, boolean encoding){
        //Converts a digit array to an integer based on parameter base and endiness
        int total = 0;
        int power = 1;
        if (encoding == true){
            for(int i = 0; i < digits.length; i++){
                total += charToInteger(digits[i]) * Math.pow(base , digits.length - power);
                power ++;
            }
        } else {
            for(int i = digits.length - 1; i >= 0; i--){
                total += charToInteger(digits[i]) * Math.pow(base , digits.length - power);
                power ++;
            }
        }
        return total;
    }

    public static void main(String[] args){
        //Prompts the user for a file and prints the results if the conversions are a match or mismatch
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        File file = new File(scanner.nextLine());

        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            System.out.println("base: " + line);

            //obtains the base for conversion later on, if the char at zero is a 1, that means the base is 10
            int base = charToInteger(line.charAt(0));
            if (base == 1){
                base = 10;
            }
            
            line = bufferedReader.readLine();
            System.out.println("endianness: " + line);

            boolean encoding = line.equals("big-endian");//true or false, used later on for arrayToInteger for first number

            line = bufferedReader.readLine();
            
            while(line != null){
                String[] values = line.split(" ");//break into two seperate strings

                //loops through the chars in the first string, adds them to a char array, calcultes the base 10 equivilent
                char[] characters_first = new char[values[0].length()];
                for(int i = 0; i < values[0].length(); i++){
                    characters_first[i] = values[0].charAt(i);
                }
                int first_num = arrayToInteger(characters_first, base, encoding);
                
                //same as above but for the second number, **might not be needed as the value doesn't change**
                char[] characters_standard = new char[values[1].length()];
                for(int i = 0; i < values[1].length(); i++){
                    characters_standard[i] = values[1].charAt(i);
                }
                int second_num = arrayToInteger(characters_standard, 10, true);


                //logic for determining if the first num now in base ten is the same as the second
                if (first_num == second_num){
                    System.out.println(values[0] + ": " +  second_num + " (match)");
                } else{
                    System.out.println(values[0] + ": " +  first_num + " (mismatch " + second_num + ")");
                }

                line = bufferedReader.readLine();
            }

            //closes everything at the end and checks for file not found
            fileReader.close();
            bufferedReader.close();
        } catch (IOException ioe){
            System.err.println(ioe.getMessage());
        }
        scanner.close();
    }
}