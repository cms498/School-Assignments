import java.util.Iterator;

public class StringIterator implements Iterator<String> {
    private int index;
    private String[] words;
    
    public StringIterator(String string) {
        this.index = 0;
        words = string.split(" ");
    }

	@Override
    public String next(){
        if (index >= words.length) {
            throw new IndexOutOfBoundsException("I'm at a loss for words!");
        }
        
        int temp = this.index;
        this.index += 1;
        return words[temp];
    }

	@Override
    public boolean hasNext() {
        return index < words.length;
    }
}