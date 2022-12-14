package lab4;

public class Cuboid extends Rectangle{
    private double height;

    public Cuboid(double l, double b, double h) {
        super(l,b);
        this.height=h;
    }

    public Cuboid(double h) {
        this.height=h;
    }

    public Cuboid() {
    }

    @Override
    public double area() {
        double x = super.getLength()*height;
        double y = super.getBreadth()*super.getLength();
        double z = super.getBreadth()*height;
        return 2*(x+y+z);
    }

    public double vol() {
        return super.area()*height;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public double getLength() {
        return super.getLength();
    }

    @Override
    public double getBreadth() {
        return super.getBreadth();
    }
}
