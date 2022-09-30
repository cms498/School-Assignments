/**
 * This program houses the information to create a pokemon, with the ability to levelup, be printed
 * and see if two pokemon are equal to each other
 */

package Assignment3_1;

public class Pokemon {
    private String name;
    private PokemonType pokemonType;
    private int level;

    /**
     * This is a constructor for the Pokemon object
     * @param name
     * @param pokemonType
     * @param level
     */
    public Pokemon(String name, PokemonType pokemonType, int level){
        this.name = name;
        this.pokemonType = pokemonType;
        this.level = level;
    }

    /**
     * This is the second constructor for the Pokemon object
     * @param name
     * @param pokemonType
     */
    public Pokemon(String name, PokemonType pokemonType){
        this (name, pokemonType, 1);
    }

    /**
     * Getter method for Pokemon name
     * @return pokemon name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for pokemon name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter method for pokemon type
     * @return pokemon type
     */
    public PokemonType getPokemonType() {
        return pokemonType;
    }

    /**
     * Getter method for pokemon level
     * @return pokemon level
     */
    public int getLevel() {
        return level;
    }

    /**
     * The method increases the pokemon level by one, max level is 100
     */
    public void levelUp(){
        this.level ++;
        if(this.level > 100){
            this.level = 100;
        }
    }

    /**
     * gives the ability to print out a pokemon
     */
    @Override
    public String toString(){
        return "Pokemon {name = " + this.name + ", type = " + this.pokemonType + ", level = " + this.level + "}";
    }

    /**
     * Two pokemon are equal if they are the same level and type, overrides the equal method
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof Pokemon){
            Pokemon other = (Pokemon)o;
            return this.level == other.level && this.pokemonType.equals(other.pokemonType);
        } else {
            return false;
        }
    }
}