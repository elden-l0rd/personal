package lab4;

public class Square extends Shape {
    private double length;

    public Square(double l) {
        this.length=l;
    }

    public double area() {
        return Math.pow(length,2);
    }

    public double getLength() {
        return this.length;
    }
}