package lab4;

public class Cone extends Pyramid {

    public Cone(double r, double h) {
        super(r,h); //previous length becomes radius
    }

    @Override
    public double vol() {
        return pi*Math.pow(super.getLength(),2)*(super.getHeight()/3.0);
    }

    @Override
    public double area() {
        double x = Math.sqrt(Math.pow(super.getHeight(), 2)+
                            Math.pow(super.getLength(), 2));
        return (pi*getLength()*(super.getLength()+x))/2.0;
    }

    @Override
    public double getHeight() {
        return super.getHeight();
    }

    public double getRadius() {
        return super.getLength();
    }
}