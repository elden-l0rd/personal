package lab4;

public class Sphere extends Circle {

    public Sphere(double r) {
        super(r);
    }

    @Override
    public double area() {
        return 2*super.area();
    }

    public double vol() {
        return (1.333333333)*pi*Math.pow(super.getRadius(), 3);
    }

    @Override
    public double getRadius() {
        return super.getRadius();
    }
}