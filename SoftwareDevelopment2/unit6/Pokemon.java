import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pokemon implements Comparable<Pokemon>{
    private String name;
    private int number;

    public Pokemon(String name, int number){
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString(){
        return this.number + ": " + this.name;
    }

    @Override
    public int compareTo(Pokemon other) {
        return this.number - other.number;
    }

    public static void main(String[] args) {
        List<Pokemon> list = new ArrayList<Pokemon>();
        list.add(new Pokemon("Meowth", 18));
        list.add(new Pokemon("Bulbasaur", 99));
        list.add(new Pokemon("Pikachu", 12));

        Collections.sort(list);
        System.out.println("By number = " + list);

        Collections.sort(list, new PokemonComparator());
        System.out.println("By name = " + list);
    }
}