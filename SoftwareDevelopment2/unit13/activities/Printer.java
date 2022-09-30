package activities;

public class Printer extends Thread{
    private String name;

    public Printer(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for(int i = 0; i < name.length(); i++){
            System.out.println(name.charAt(i));
        }
    }
    public static void main(String[] args) {
        Printer thread = new Printer("Christopher");
        thread.start();
    }
}