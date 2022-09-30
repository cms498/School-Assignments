public class Parent {
    private String name;

    public Parent(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Parent {name = " + this.name + "}";
    }
}
