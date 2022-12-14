package Tutorial;

public class Circle{
    protected int radius;
    protected Point center;

    public Circle(int r, Point center) {
        this.center = center;
        this.radius = r;
    }

    public String toString() {
        return "the circle has the radius of " + this.radius + "; its center is located at " 
				+ center.toString() + "; and its area is " + area();
    }

    public void setRadius(int x) {
        this.radius=x;
    }

    public double area() {
        return Math.PI*Math.pow(getRadius(), 2);
    }

    public int getRadius() {
        return this.radius;
    }
}
