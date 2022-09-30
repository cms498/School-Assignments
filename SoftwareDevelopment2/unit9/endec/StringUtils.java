/**
 * This program performs a tranposition encryption, where every other element is
 * swapped so the string abcd becomes badc
 * 
 * Author: Chris Shepard
 */

package endec;

public class StringUtils {
    /**
     * This is the transposition algorithm, it swaps characters given a string passed in
     * @param text
     * @return result string
     */
    public static String transposeChars(String text){
        String result = "";
        String[] tokens = text.split("");
        for(int i = 0; i < tokens.length; i += 2){
            if(i != tokens.length - 1){
                String temp = tokens[i];
                tokens[i] = tokens[i + 1];
                tokens[i + 1] = temp;
                result += tokens[i];
                result += tokens[i + 1];
            } else {
                result += tokens[i];
            }
        }
        return result;
    }
}