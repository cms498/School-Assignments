public class Casting {
    public static void main(String[] args) {
        int x = 1234;
        long y = (long)x;
        System.out.println(y);

        long y2 = 40000001231234l;
        int x2 = (int)y2;
        System.out.println(x2);

        char a = 'a';
        int a1 = (int)a;
        System.out.println(a1);

        int c1 = 34;
        char c2 = (char)c1;
        System.out.println(c2);

        // boolean b = false; -- > not possible
        // int b1 = (boolean)b;
    }
}
