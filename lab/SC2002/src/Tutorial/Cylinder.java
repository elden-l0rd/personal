package Tutorial;

public class Cylinder extends Circle {
    protected int height;

    public Cylinder(int x, int y, Point c) {
        super(x, c);
        this.height=y;
    }

    @Override
    public String toString() {
        return "the cylinder has the radius of " + this.radius + "; its center is located at " 
				+ center.toString() + "; and its area is " + area();
    }

    public double area() {
        return 0.0; /* insert vol of cylinder */
    }

    public double vol() {
        return super.area()*(double)(getHeight());
    }

    public void setHeight(int x) {
        this.height=x;
    }
    
    public int getHeight() {
        return this.height;
    }
}
