/**
 * This program creates two maps, one used to encryption and one used for decryption
 * the key value pairs in one are the opposite in the other.
 * It also provides implemenation to encrypt and decrypt strings of values
 * 
 * Author: Chris Shepard
 */

package endec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstitutionEncryptorDecryptor implements Encrypter, Decrypter {
    private static Map<Character,Character> encryptMap;
    private static Map<Character,Character> decryptMap;

    /**
     * This static call initialized the maps and fills them
     * with the proper values
     */
    static {
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        encryptMap = new HashMap<Character,Character>();
        decryptMap = new HashMap<Character, Character>();

        for(int i = 32; i < 127; i++){
            list1.add((char)i);
            list2.add((char)i);
        }

        Collections.shuffle(list1);
        Collections.shuffle(list2);
        
        for(int i = 0; i < list1.size(); i++){
            encryptMap.put(list1.get(i), list2.get(i));
            decryptMap.put(list2.get(i), list1.get(i));
        }
    }

    /**
     * This method will reverse the process of encryption
     * it uses the decrypt map to do so
     */
    @Override
    public String decrypt(String encryptedText) {
        String[] tokens = encryptedText.split("");
        String result = "";
        for(String s : tokens){
            char[] chars = s.toCharArray();
            result += decryptMap.get(chars[0]);
        }
        return result;
    }

    /**
     * This method will encrypt a string and it uses
     * the encrypt map
     */
    @Override
    public String encrypt(String plainText) {
        String[] tokens = plainText.split("");
        String result = "";
        for(String s : tokens){
            char[] chars = s.toCharArray();
            result += encryptMap.get(chars[0]);
        }
        return result;
    }
}