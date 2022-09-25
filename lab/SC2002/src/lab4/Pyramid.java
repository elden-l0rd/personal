package lab4;

public class Pyramid extends Square{
    private double height;

    public Pyramid(double l, double h) {
        super(l);
        this.height=h;
    }

    @Override
    public double area() {
        return (float)super.area()+
                (float)2.0*super.getLength()*(float)Math.sqrt((float)Math.pow(super.getLength()/2.0, 2)+(float)Math.pow(height/2.0, 2));
    }

    public double vol() {
        return super.area()*height/3.0;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public double getLength() {
        return super.getLength();
    }
}
