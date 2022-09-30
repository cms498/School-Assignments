public class Conditional {
    public static void evenlyDivisible(int n){
        if (n % 2 == 0){
            System.out.println("N is even");
        } else if (n % 3 == 0){
            System.out.println("N is divisible by 3");
        } else if (n % 5 == 0){
            System.out.println("N is divisible by 5");
        }else{
            System.out.println("N is odd, but not divisible by 3 or 5");
        }
    }
    public static void main(String[] args) {
        evenlyDivisible(24);
        evenlyDivisible(9);
        evenlyDivisible(25);
        evenlyDivisible(17);
    }
}
