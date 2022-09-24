package lab4;

public class Triangle extends Shape {
    private double length;
    private double height;

    public Triangle(double l, double h) {
        this.length=l;
        this.height=h;
    }

    @Override
    public double area() {
        return 0.5*length*height;
    }

    public double getLength() {
        return this.length;
    }
    public double getHeight() {
        return this.height;
    }
}
