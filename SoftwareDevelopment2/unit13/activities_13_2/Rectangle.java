package activities_13_2;

public class Rectangle implements Shape{
    private String name;
    private double sideLength1;
    private double sideLength2;

    public Rectangle(String name, double sideLength1, double sideLength2){
        this.name = name;
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
    }

    @Override
    public String Name() {
        return this.name;
    }

    @Override
    public double Area() {
        return sideLength1 * sideLength2;
    }

    @Override
    public double Perimeter() {
        return 2 * (sideLength1 + sideLength2);
    }
}