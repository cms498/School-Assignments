package activities_13_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cat implements Comparable<Cat>{
    private String name;
    private String furColor;
    private int evilRating;

    public Cat(String name, String furColor, int evilRating){
        this.name = name;
        this.furColor = furColor;
        this.evilRating = evilRating;
    }

    public int getEvilRating() {
        return evilRating;
    }

    public String getFurColor() {
        return furColor;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Cat o) {
        int value = this.name.compareTo(o.name);
        if(value == 0){
            return 0;
        } else if (value < 0){
            return -1;
        }
        return 1;
    }

    @Override
    public String toString(){
        return this.name + " " + this.furColor + " " + this.evilRating;
    }

    public static void main(String[] args) {
        Cat c1 = new Cat("A Name", "Brown", 2);
        Cat c2 = new Cat("B Name", "Green", 10);
        Cat c3 = new Cat("D Name", "Orange", 6);
        Cat c4 = new Cat("C Name", "Blue", 3);
        Cat c5 = new Cat("E Name", "Blue", 6);

        List<Cat> myCats = new ArrayList<>();

        myCats.add(c1);
        myCats.add(c2);
        myCats.add(c3);
        myCats.add(c4);
        myCats.add(c5);

        Collections.sort(myCats);

        System.out.println(myCats);

        Collections.sort(myCats, new CatComparator());

        System.out.println(myCats);
    }
}