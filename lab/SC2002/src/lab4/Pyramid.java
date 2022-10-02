package lab4;

public class Pyramid extends Square{
    private double height;

    public Pyramid(double l, double h) {
        super(l);
        this.height=h;
    }

    @Override
    public double area() { //surface area!
        return (float)super.area()+((float)Math.sqrt(Math.pow(getLength()/2.0, 2)+Math.pow(getHeight(), 2))*getLength()
                +(float)getLength()*Math.sqrt(Math.pow(getLength()/2.0, 2)+Math.pow(getHeight(), 2)));
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
