package parser;

public class Decrement implements Expression{
    private final Expression operand;

    public Decrement(Expression operand){
        this.operand = operand;
    }

    @Override
    public double evaluate() {
        double value = operand.evaluate();
        return value - 1;
    }

    @Override
    public String toString(){
        return "-- " + operand;
    }
}