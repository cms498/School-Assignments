/**
 * This program implements a binary search tree, it has the ability to insert nodes into the tree
 * as well as search if items are already in the tree, it is generic and can be printed
 * 
 * Author: Chris Shepard
 */

public class BinarySearchTree <E extends Comparable<E>>{
    private BinaryNode<E> root;
    private int size;

    /**
     * Basic constructor, creates a new binary node called root
     * @param initialValue initial value of root
     */
    public BinarySearchTree(E initialValue){
        this.root = new BinaryNode<>(initialValue);
        this.size = 1;
    }

    /**
     * Prints out the string in infix traversal order
     */
    @Override
    public String toString(){
        return root.infixTraversal();
    }

    /**
     * getter method for the size of the tree
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * private method which searhes a binary tree from a starting node looking
     * for a target value
     * @param node
     * @param target
     * @return true if found, false if not
     */
    private boolean search(BinaryNode<E> node, E target){
        if(node.getValue().equals(target)){
            return true;
        } else if (target.compareTo(node.getValue()) < 0){
            if(node.getLeft() != null){
                return node.getLeft().search(target);
            } else {
                return false;
            }
        } else {
            return node.getRight() != null ? node.getRight().search(target) : false;
        }
    }

    /**
     * public method, calls the private search function
     * @param target
     * @return
     */
    public boolean search(E target){
        return search(root, target);
    }

    /**
     * private method, given a node and a value, it will insert 
     * it into the tree maintain an order
     * @param node
     * @param value
     */
    private void insert(BinaryNode<E> node, E value){
        if(value.compareTo(node.getValue()) < 0){
            if(node.getLeft() != null){
                insert(node.getLeft(), value);
            } else {
                node.setLeft(new BinaryNode<E>(value));
                size++;
            }
        } else {
            if(node.getRight() != null){
                insert(node.getRight(), value);
            } else {
                node.setRight( new BinaryNode<E>(value));
                size++;
            }
        }
    }

    /**
     * Public method insert, calls the private method, where root is the starting node
     * @param value
     */
    public void insert(E value){
        insert(root, value);
    }

    /**
     * main method used for testing purposes
     * @param args
     */
    public static void main(String[] args) {
        BinarySearchTree<Pokemon> BST = new BinarySearchTree<Pokemon>(new Pokemon("Charizard", 50));
        BST.insert(new Pokemon("Meowth", 18));
        BST.insert(new Pokemon("Bulbasaur", 99));
        Pokemon pikachu = new Pokemon("Pikachu", 12);
        BST.insert(pikachu);
        BST.insert(new Pokemon("Dragonite", 56));
        BST.insert(new Pokemon("Chikorita", 1));
        BST.insert(new Pokemon("TalonFlame", 73));
        BST.insert(new Pokemon("Aipom", 49));

        System.out.println(BST);

        System.out.println("Size = " + BST.getSize());

        System.out.println("Should be False = " + BST.search(new Pokemon("Charizard", 18)));
        System.out.println("Should be False = " + BST.search(new Pokemon("Random", 73)));
        System.out.println("Should be True = " + BST.search(pikachu));
    }
}