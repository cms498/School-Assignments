/**
 * This program houses all of the tests cases for creating a candidate, as well as testing all of the enumerations
 * 
 * Author: Chris Shepard
 */

package Assignment2_2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class CandidateTest {
    @Test
    public void candidateToString(){
        //setup
        String name = "Chris";
        Position position = Position.MAYOR;
        Affiliation affiliation = Affiliation.DEMOCRAT;
        String expected = "Name: Chris, Position: Mayor, Affiliation: Democrat";
        //invoke
        Candidate test = new Candidate(name, position, affiliation);
        String actual = test.toString();
        //analyze
        assertEquals(expected, actual);
    }

    @Test
    public void candidateNotEqual(){
        //setup
        Candidate c1 = new Candidate("Chris", Position.JUDGE, Affiliation.INDEPENDENT);
        Candidate c2 = new Candidate("Bob", Position.JUDGE, Affiliation.INDEPENDENT);
        boolean expected = false;
        //invoke
        boolean actual = c1.equals(c2);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void candidateEqual(){
        //setup
        Candidate c1 = new Candidate("Chris", Position.JUDGE, Affiliation.INDEPENDENT);
        Candidate c2 = new Candidate("Chris", Position.JUDGE, Affiliation.DEMOCRAT);
        boolean expected = true;
        //invoke
        boolean actual = c1.equals(c2);
        //analyze
        assertEquals(expected, actual);
    }

    @Test
    public void getCandidateName(){
        //setup
        Candidate c1 = new Candidate("Joe", Position.ASSEMBLY_MEMBER, Affiliation.WORKING_FAMILY);
        String expected = "Joe";
        //invoke
        String actual = c1.getName();
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void getCandidatePosition(){
        //setup
        Candidate c1 = new Candidate("Joe", Position.ASSEMBLY_MEMBER, Affiliation.WORKING_FAMILY);
        Position expected = Position.ASSEMBLY_MEMBER;
        //invoke
        Position actual = c1.getPosition();
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void getCandidateAffiliation(){
        //setup
        Candidate c1 = new Candidate("Joe", Position.ASSEMBLY_MEMBER, Affiliation.WORKING_FAMILY);
        Affiliation expected = Affiliation.WORKING_FAMILY;
        //invoke
        Affiliation actual = c1.getAffiliation();
        //analyze
        assertEquals(expected, actual);
    }
}
