package parser;

public class Main {
    
    public static void main(String[] args) {
        Expression constant = new Constant(10);
        Expression increment = new Increment(constant);
        Expression decrement = new Decrement(increment);

        Expression subtraction = new Subtraction(decrement, new Constant(5));
        Expression addition = new Addition(new Constant(15) , subtraction);
        System.out.println(addition);
        System.out.println(addition.evaluate());
    }
}