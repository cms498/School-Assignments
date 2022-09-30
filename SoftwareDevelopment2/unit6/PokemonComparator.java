import java.util.Comparator;

public class PokemonComparator implements Comparator<Pokemon>{
    @Override
    public int compare(Pokemon p1, Pokemon p2) {
        String p1Name = p1.getName().toLowerCase();
        String p2Name = p2.getName().toLowerCase();
        return p1Name.compareTo(p2Name);
    }
}