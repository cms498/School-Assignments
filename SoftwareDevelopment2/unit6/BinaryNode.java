public class BinaryNode<E>{
    private E value;
    private BinaryNode<E> leftNode;
    private BinaryNode<E> rightNode;

    public BinaryNode(E value){
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public BinaryNode<E> getLeft() {
        return leftNode;
    }

    public BinaryNode<E> getRight() {
        return rightNode;
    }

    public void setLeft(BinaryNode<E> left) {
        this.leftNode = left;
    }

    public void setRight(BinaryNode<E> right) {
        this.rightNode = right;
    }

    @Override
    public String toString(){
        return "BinaryNode{value=" + this.value + ", left=" + this.leftNode + ", right=" + this.rightNode + "}";
    }

    public String infixTraversal(){
        String order = "";
        if(leftNode != null){
            order += leftNode.infixTraversal();
        } 
        order += value + " ";
        if(rightNode != null){
            order += rightNode.infixTraversal();
        }
        return order;
    }

    public boolean search(E target){
        boolean result = false;
        result = value == target;
        if(result == true){
            return result;
        }
        if(leftNode != null){
            result = leftNode.search(target);
        }
        if(result == true){
            return result;
        }
        if(rightNode != null){
            result = rightNode.search(target);
        }
        return result;
    }

    public static void main(String[] args) {

        //BinaryNode<Integer> root = new BinaryNode<>(9);
        // root.binaryInsert(3);
        // root.binaryInsert(4);
        // root.binaryInsert(2);
        // root.binaryInsert(1);
        // root.binaryInsert(7);
        // root.binaryInsert(6);

        // System.out.println(root);
        // System.out.println(root.infixTraversal());
        // System.out.println(root.search(2));
        // System.out.println(root.search(8));
        // System.out.println(root.search(6));
        // System.out.println(root.search(4));
        // System.out.println(root.search(5));
        // System.out.println(root.search(7));
        // System.out.println(root.search(13));

        // System.out.println("BS = " + root.binarySearch(7));
        // System.out.println("BS = " + root.binarySearch(13));
        // System.out.println("BS = " + root.binarySearch(0));
    }
}