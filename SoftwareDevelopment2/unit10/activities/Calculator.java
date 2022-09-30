package activities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator{
    public interface Operation{
        public double execute(double left, double right);
    }
    public static Operation getOperation(String op){
        if(op.equals("+")){
            return new Operation(){
                @Override
                public double execute(double left, double right) {
                    return left + right;
                }
            };
        } else if(op.equals("-")){
            return (left, right) -> left - right;
        } else if(op.equals("*")){
            return (left, right) -> left * right;
        } else if(op.equals("/")){
            return (left, right) -> left / right;
        } else if(op.equals("^")){
            return Math::pow;
        }
        throw new UnsupportedOperationException();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Enter an operation <double operator double>: ");
            try{
                double left = scanner.nextDouble();
                String operator = scanner.next();
                double right = scanner.nextDouble();
                Operation operation = getOperation(operator);
                double result = operation.execute(left, right);
                System.out.println(result);
            } catch (InputMismatchException e){
                break;
            } catch (UnsupportedOperationException u){
                System.out.println("Unsupported Operator: " + u.getMessage());
            }
        }
        scanner.close();
    }
}