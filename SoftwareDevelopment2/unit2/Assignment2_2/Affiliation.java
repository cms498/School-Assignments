/**
 * This program houses the enumeration for the Candidates Affiliation
 * 
 * Author: Chris Shepard
 */

package Assignment2_2;

public enum Affiliation {
    REPUBLICAN ("Republican"),
    DEMOCRAT ("Democrat"),
    WORKING_FAMILY ("Working Family"),
    LIBERTARIAN ("Libertarian"),
    INDEPENDENT ("Independent");

    private String affiliation;

    private Affiliation(String affiliation){
        this.affiliation = affiliation;
    }

    @Override
    public String toString(){
        return this.affiliation;
    }
}
