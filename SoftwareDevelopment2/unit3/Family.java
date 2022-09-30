public class Family {
    
    public static void printParent(Parent parent){
        System.out.println(parent);
    }

    public static void printChild(Child child){
        System.out.println(child);
    }

    public static void main(String[] args) {
        Parent p1 = new Parent("Bob");
        Child c1 = new Child("Ryan", 11);
        printParent(p1);
        printParent(c1);
        //printChild(p1); - can't print a parent as a child
        printChild(c1);

        Parent p2 = (Parent)c1;
        printParent(p2);
        //printChild(p2); - can't print a parent as a child

        Child c2 = (Child)p1;
        printParent(c2);
        printChild(c2);
    }
}