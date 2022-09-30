package heaps;

import java.util.Arrays;

public class ArrayHeap implements Heap {
    private int[] array;
    private int size;

    public ArrayHeap(){
        this.array = new int[3];
        this.size = 0;
    }

    @Override
    public void add(int value) {
        if(size == array.length){
            int[] bigger = Arrays.copyOf(array, size * 2);
            array = bigger;
        }
        array[size] = value;
        int child = size;
        int parent = (child - 1) / 2;
        while(array[parent] > array[child]){
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
        size++;
    }

    @Override
    public int remove() {
        int value = array[0];
        size--;
        array[0] = array[size];
        array[size] = 0;

        int parent = 0;
        while(parent < size){
            int left = (parent * 2) + 1;
            int right = (parent * 2) + 2;
            int dest = parent;
            if(left < size){
                dest = left;
            }
            if(right < size && array[right] < array[left]){
                dest = right;
            }
            if(array[dest] < array[parent]){
                swap(dest, parent);
                parent = dest;
            } else {
                break;
            }
        }
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        return Arrays.toString(this.array) + ", " + this.size;
    }

    private void swap(int source, int dest){
        int tmp = array[dest];
        array[dest] = array[source];
        array[source] = tmp;
    }

    public static void main(String[] args) {
        Heap heap = new ArrayHeap();
        System.out.println("Size = " + heap.size());
        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);
        System.out.println(heap);
        while(heap.size() > 0){
            System.out.println(heap.remove());
            System.out.println(heap);
        }
    }
}