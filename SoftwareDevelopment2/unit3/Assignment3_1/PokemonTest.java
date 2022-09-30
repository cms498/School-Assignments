/**
 * This program houses all of the test cases for the pokemon class
 * 
 * Author: Chris Shepard
 */

package Assignment3_1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class PokemonTest {
    @Test
    public void toStringTest(){//tests the ability to properly print a pokemon
        //setup
        String name = "Charizard";
        PokemonType pokemonType = PokemonType.FIRE;
        int level = 42;
        String expected = "Pokemon {name = Charizard, type = FIRE, level = 42}";
        //invoke
        Pokemon test = new Pokemon(name, pokemonType, level);
        String actual = test.toString();
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void pokemonNotEqual(){//tests if two pokemon are not equal to eachother
        //invoke
        Pokemon p1 = new Pokemon("Squirtle", PokemonType.WATER, 34);
        Pokemon p2 = new Pokemon("Squirtle", PokemonType.WATER, 35);
        boolean expected = false;
        //setup
        boolean actual = p1.equals(p2);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void pokemonEqual(){//tests if two pokemon are equal to eachother
        //invoke
        Pokemon p1 = new Pokemon("Squirtle", PokemonType.WATER, 34);
        Pokemon p2 = new Pokemon("Wartortle", PokemonType.WATER, 34);
        boolean expected = true;
        //setup
        boolean actual = p1.equals(p2);
        //analyze
        assertEquals(expected, actual);
    }
    @Test
    public void levelUpTest(){//tests the levelUp function
        //invoke
        Pokemon p1 = new Pokemon("Squirtle", PokemonType.WATER, 34);
        int expected = 35;
        //setup
        p1.levelUp();
        int actual = p1.getLevel();
        //analyze
        assertEquals(expected, actual);
    }
}