/**
 * This program houses the enumeration for the Candidates Position
 * 
 * Author: Chris Shepard
 */

package Assignment2_2;

public enum Position {
    MAYOR ("Mayor"),
    SHERIFF("Sheriff"),
    JUDGE("Judge"),
    ASSEMBLY_MEMBER("Assembly Member");

    private String position_name;

    private Position(String position_name){
        this.position_name = position_name;
    }

    @Override
    public String toString(){
        return this.position_name;
    }
}
