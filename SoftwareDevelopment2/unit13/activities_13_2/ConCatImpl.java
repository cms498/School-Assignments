package activities_13_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConCatImpl implements Concatenator, Iterable<String>{
    private List<String> values;
    public ConCatImpl(){
        values = new ArrayList<>();
    }

    @Override
    public void add(String a) {
        values.add(a);
    }

    @Override
    public void remove(String s) {
        values.remove(s);
    }

    @Override
    public String combine(List<String> values) {
        String string = "";
        for(int i = 0; i < values.size(); i++){
            string += values.get(i);
        }
        return string;
    }

    @Override
    public Iterator<String> iterator() {
        return new CatIterator<String>(values);
    }

    public static void main(String[] args) {
        ConCatImpl conCatImpl = new ConCatImpl();
        conCatImpl.add("a");
        conCatImpl.add("b");
        conCatImpl.add("c");
        conCatImpl.add("d");
        conCatImpl.add("e");
        conCatImpl.add("f");

        for(String value : conCatImpl){
            System.out.println(value);
        }
    }
}