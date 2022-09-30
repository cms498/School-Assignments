package activities_13_2;

public class Car {
    private String liscense;
    private String color;
    private int tireCount;

    //now there is no default constructor now to be called
    public Car(String liscense, String color, int tireCount){
        this.liscense = liscense;
        this.color = color;
        this.tireCount = tireCount;
    }

    public void drive(){
        System.out.println("VROOOOMMMMM");
    }

    public void stop(){
        System.out.println("SCCCRRRREEEECCCCHHHHHH");
    }

    public void paintJob(String color){
        this.color = color;
        System.out.println("The cars new color is " + this.color);
    }

    public void crash(){
        this.tireCount--;
        System.out.println("The car has " + this.tireCount + " left");
    }

    public String getLiscense() {
        return liscense;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString(){
        return "Liscense: " + this.liscense + "\nTirecount: " + this.tireCount + "\nColor: " + this.color;
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Car){
            Car otherCar = (Car)other;
            return otherCar.color == this.color && otherCar.liscense == this.liscense && otherCar.tireCount == this.tireCount;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }
}
