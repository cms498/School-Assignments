package activities_13_2;

public class Circle implements Shape{
    private String name;
    private double radius;

    public Circle(String name, double radius){
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String Name() {
        return name;
    }

    @Override
    public double Area() {
        return Math.PI * (radius * radius);
    }

    @Override
    public double Perimeter() {
        return 2 * Math.PI * radius;
    }
}