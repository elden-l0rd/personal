package lab4;
import java.util.*;

public class Shape2DApp {
    
    public static void main(String[] args) {
        int noOfShapes, choice; //int type;
        double l,b,h,r;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total number of shapes:");
        noOfShapes=sc.nextInt();

        Shape[] list = new Shape[noOfShapes];


        for (int i=0; i<noOfShapes; i++) {
            System.out.println("Enter the shape:\n"+
                                "1. Circle\n"+
                                "2. Triangle\n"+
                                "3. Rectangle\n"+
                                "4. Square\n");
                                
            choice=sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter radius of circle:");
                    r=sc.nextDouble();
                    list[i] = new Circle(r);
                    break;

                case 2:
                    System.out.println("Enter length and height of triangle:");
                    l=sc.nextDouble();
                    h=sc.nextDouble();
                    list[i] = new Triangle(l, h);
                    break;

                case 3:
                    System.out.println("Enter length and breadth of triangle:");
                    l=sc.nextDouble();
                    b=sc.nextDouble();
                    list[i] = new Rectangle(l, b);
                    break;

                case 4:
                    System.out.println("Enter length of square:");
                    l=sc.nextDouble();
                    list[i] = new Square(l);
                    break;
            }
        }

        // System.out.print("Chooee the type of calculation:\n"+
        //                     "1. Area\n"+
        //                     "2. Volume\n");
        // type=sc.nextInt();

        double area=0;
        for (int i=0; i<noOfShapes; i++) {
            if (list[i] instanceof Circle) {
                Circle c = (Circle)list[i];
                area += c.area();
            }
            if (list[i] instanceof Triangle) {
                Triangle t = (Triangle)list[i];
                area += t.area();
            }
            if (list[i] instanceof Rectangle) {
                Rectangle rect = (Rectangle)list[i];
                area += rect.area();
            }
            if (list[i] instanceof Square) {
                Square sq = (Square)list[i];
                area += sq.area();
            }
        }
        System.out.println("Total area is: "+area);

        sc.close();
    }
}