/**
 * This program houses the practice problem method for unit 1
 * 
 * Author: Chris Shepard
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Practice01{
    //method converts an integer array to a string
    public static String arrayToString(int[] numbers){
        String result = "[";
        for(int i = 0; i < numbers.length; i++){
            result += numbers[i];
            if(result.length() < numbers.length * 3 - 1){
                result += ", ";
            } else{
                break;
            }
        }
        return result + "]";
    }

    //prints all of the lines in a file that start with the letter given, returns the total
    public static int printLines(String filename, char letter) {
        File file = new File(filename);
        int total = 0;
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            
            //if the line is empty, read the next line and end current iteration, else check char 0 with letter
            while(line != null){
                if (line.length() == 0){
                    line = bufferedReader.readLine();
                    continue;
                } else {
                    String lowered = line.toLowerCase();
                    char first = lowered.charAt(0);
                    if(first == letter){
                        System.out.println(line);
                        total++;
                    }
                }
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException ioe){
            System.err.println(ioe);
        }
        return total;
    }

    public static void main(String[] args){
        System.out.println(printLines("data/alice.txt", 'a'));
    }
}