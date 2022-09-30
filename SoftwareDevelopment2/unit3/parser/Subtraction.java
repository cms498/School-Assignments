package parser;

public class Subtraction implements Expression{
    private final Expression left;
    private final Expression right;

    public Subtraction(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        double value = left.evaluate();
        double value2 = right.evaluate();
        return value - value2;
    }
    
    @Override
    public String toString(){
        return "- " + left + " " + right;
    }
}