package lab4;

public class Circle extends Shape {
    private double radius;

    public Circle(double r) {
        this.radius=r;
    }
    
    @Override
    public double area() {
        return pi*Math.pow(radius,2);
    }

    public double getRadius() {
        return this.radius;
    }
}
