import java.util.Arrays;

public class Miscellany {
   public static String reverseChars(String string) {
       String reversed = "";
       for(int i = 0; i < string.length(); i ++){
            reversed = string.charAt(i) + reversed;
       }
       return reversed;
   }

   public static int[] squares(int n) {
       int[] square = new int[n];
       for(int i = 0; i < square.length; i++){
           square[i] = i * i;
       }
       return square;
   }
   public static void main(String[] args) {
       System.out.println(reverseChars(("abcd")));
       System.out.println(Arrays.toString(squares(10)));
   }
}
