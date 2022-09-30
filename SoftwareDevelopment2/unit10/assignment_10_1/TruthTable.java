/**
 * This program computes the binary logical operators using lambdas, method refrences and anonymous classes
 * 
 * Author: Chris Shepard
 */

package assignment_10_1;

public class TruthTable {
    /**
     * this inner functional interface only houses the compute method
     * where a boolen is returned depending on the type either and, or, Xor
     */
    public interface BinaryLogicalOp{
        public boolean compute(boolean a, boolean b);
    }
    public static void main(String[] args) {
        //and computed used an anonymous class
        BinaryLogicalOp and = new BinaryLogicalOp() {
            @Override
            public boolean compute(boolean a, boolean b) {
                return a == true && b == true;
            }
        };
        //or computed using a lambda
        BinaryLogicalOp or = (a, b) -> a == true || b == true;
        //Xor computed using a method refrence
        BinaryLogicalOp Xor = Boolean::logicalXor;

        //all of the printing for the grid
        System.out.println(String.format("%-5s|%-5s|%-5s|%-5s|%-5s", "A", "B", "AND", "OR", "XOR"));
        System.out.println("-----------------------------");
        System.out.println(String.format("%-5s|%-5s|%-5s|%-5s|%-5s", "false", "false", 
            and.compute(false, false), or.compute(false, false), Xor.compute(false, false)));
        System.out.println(String.format("%-5s|%-5s|%-5s|%-5s|%-5s", "false", "true", 
            and.compute(false, true), or.compute(false, true), Xor.compute(false, true)));
        System.out.println(String.format("%-5s|%-5s|%-5s|%-5s|%-5s", "true", "false", 
            and.compute(true, false), or.compute(true, false), Xor.compute(true, false)));
        System.out.println(String.format("%-5s|%-5s|%-5s|%-5s|%-5s", "true", "true", 
            and.compute(true, true), or.compute(true, true), Xor.compute(true, true)));
    }
}