package mcf;

import java.util.Arrays;

public class ArrayQueue implements Queue<String>{
    private String[] elements;
    private int front;
    private int back;
    private int size;

    public ArrayQueue(){
        this.elements = new String[2];
        this.front = 0;
        this.back = 0;
        this.size = 0;
    }

    @Override
    public void enqueue(String value) {
        if(this.size == this.elements.length){
            String[] bigger = new String[this.size * 2];
            for(int destination = 0; destination < this.size; destination ++){
                int source = (this.front + destination) % size;
                bigger[destination] = this.elements[source];
            }
            this.elements = bigger;
            this.front = 0;
            this.back = size;
        }
        this.elements[back] = value;
        this.back ++;
        if(this.back == this.elements.length){
            back = 0;
        }
        this.size ++;
    }

    @Override
    public String dequeue() {
        String frontValue = this.elements[front];
        this.elements[front] = null;
        this.front ++;
        if(front == this.elements.length){
            front = 0;
        }
        this.size --;
        return frontValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        return "Queue { " + Arrays.toString(this.elements) + " }";
    }

    public static void main(String[] args) {
        Queue q = new ArrayQueue();
        q.enqueue("a");
        q.enqueue("b");

        System.out.println(q.dequeue());
        q.enqueue("c");
        q.enqueue("d");
        q.enqueue("e");
        q.enqueue("f");
        System.out.println(q);
    }
}