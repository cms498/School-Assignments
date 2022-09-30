package mcf;

public class NodeQueue<E> implements Queue<E>{
    private Node<E> front;
    private Node<E> back;
    private int size;

    public NodeQueue(){
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    @Override
    public void enqueue(E value) {
        Node<E> node = new Node<>(value);
        if(this.size == 0){
            this.front = node;
            this.back = node;
        } else {
            this.back.setNext(node);
            this.back = node;
        }
        this.size++;
    }

    @Override
    public E dequeue() {
        E frontValue = this.front.getValue();
        this.front = this.front.getNext();
        this.size--;
        if(size == 0){
            this.back = null;
        }
        return frontValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        return "Queue { " + this.front + " }";
    }

    public static void main(String[] args) {
        Queue<String> q = new NodeQueue<>();
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        q.enqueue("d");
        System.out.println(q);

        while(q.size() > 0){
            String value = q.dequeue();
            System.out.println(value + ", " + q);
        }
    }
}