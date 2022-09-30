import java.util.Iterator;

public class IterableString implements Iterable<String>{
    private String s;
    
    public IterableString(String s) {
        this.s = s;
    }

	@Override
    public Iterator<String> iterator() {
        // return new StringIterator(s);
        return new Iterator<String>() {
            private int index = 0;
            private String[] words = s.split(" ");

            @Override
            public boolean hasNext(){
                return index < words.length;
            }

            @Override
            public String next(){
                String word = words[index];
                index++;
                return word;
            }
        };
    }

    public static void main(String[] args) {
        IterableString string = new IterableString("Hello, this is a test. Bye!");
        for (String word : string) {
            System.out.println(word);
        }
    }
}