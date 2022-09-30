/**
 * This program reads lines from a file and puts each of the lines into a list
 * 
 * Author: Chris Shepard
 */

package endec;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileEncryptorDecryptor {
    /**
     * This method takes in a file and puts every line into a list
     * @param filename
     * @return a list of strings
     * @throws IOException
     */
    public static List<String> getLines(String filename) throws IOException{
        List<String> lines = new ArrayList<>();
        FileReader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = bufferedReader.readLine();

        while(line != null){
            lines.add(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        reader.close();
        return lines;
    }
}