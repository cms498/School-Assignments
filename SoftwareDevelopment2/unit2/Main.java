import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Object[] object = new Object[5];
        object[0] = "String";
        object[1] = 123;
        object[2] = false;
        object[3] = 123.45;
        object[4] = new Year(2021);
        System.out.println(Arrays.toString(object));
    }
}
