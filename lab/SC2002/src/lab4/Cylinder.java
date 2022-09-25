package lab4;

public class Cylinder extends Cuboid {
    private double radius;

    public Cylinder() {
    }
    public Cylinder(double r, double h) {
        super(h); //stores height
        this.radius=r;
    }

    @Override
    public double area() {
        return 2.0*pi*this.radius*super.getHeight()+
                2.0*pi*Math.pow(this.radius, 2);
    }

    @Override
    public double vol() {
        return pi*Math.pow(this.radius, 2)*super.getHeight();
    }

    @Override
    public double getHeight() {
        return super.getHeight();
    }

    public double getRadius() {
        return this.radius;
    }
}
