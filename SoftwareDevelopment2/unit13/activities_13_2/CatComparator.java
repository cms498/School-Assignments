package activities_13_2;

import java.util.Comparator;

public class CatComparator implements Comparator<Cat>{
    @Override
    public int compare(Cat c1, Cat c2) {
        int value = c1.getFurColor().compareTo(c2.getFurColor());
        if(value < 1){
            return -1;
        } else if (value > 1){
            return 1;
        } else {
            return c1.getEvilRating() - c2.getEvilRating();
        }
    }
}