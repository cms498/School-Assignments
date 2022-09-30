public class HelloWorld{
    public static void helloName(String first, String last){
        String fullname = first + " " + last;
        System.out.println("Hello, " + fullname + "!");
    }
    public static void main(String[] args){
        System.out.println("Hello World");
        helloName("Chris", "Shepard");
    }
}