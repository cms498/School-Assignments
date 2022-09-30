package activities;

public class Euclid {
    public static int gcd(int a, int b){
        // use a while loop for a != b
        while(a != b){
            // if a > b, set a = a-b
            if(a > b){
                a = a - b;
            } else {
                // else set b = b - a
                b = b - a;
            }
        }
        // after loop ends return the a value
        return a;
    }
    public static void main(String[] args) {
        System.out.println(gcd(100, 15));
        System.out.println(gcd(2, 4));
        System.out.println(gcd(4, 5));
        System.out.println(gcd(5, 4));
    }
}