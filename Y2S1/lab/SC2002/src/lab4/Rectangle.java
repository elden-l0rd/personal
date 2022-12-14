package lab4;

public class Rectangle extends Shape {
    private double length;
    private double breadth;

    public Rectangle(double l, double b) {
        this.length=l;
        this.breadth=b;
    }
    public Rectangle() {
    }

    @Override
    public double area() {
        return length*breadth;
    }

    public double getLength() {
        return this.length;
    }
    public double getBreadth() {
        return this.breadth;
    }
}
