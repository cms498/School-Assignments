/**
 * This program provides a blueprint for creating a candidate, providing the ability to print them as well as 
 * check candidate equality
 * 
 * Author: Chris Shepard
 */

package Assignment2_2;

public class Candidate {
    private String name;
    private Position position;
    private Affiliation affiliation;

    public Candidate(String name, Position position, Affiliation affiliation){
        this.name = name;
        this.position = position;
        this.affiliation = affiliation;
    }

    public String getName() {
        return name;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + ", Position: " + this.position + ", Affiliation: " + this.affiliation;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Candidate){
            Candidate other = (Candidate)o;
            return this.name.equals(other.name) && this.position.equals(other.position);
        } else {
            return false;
        }
    }
}