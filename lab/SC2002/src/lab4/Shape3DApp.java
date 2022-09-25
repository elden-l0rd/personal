package lab4;
import java.util.*;

public class Shape3DApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfShapes, choice;
        double l,b,h,r;

        System.out.println("Enter number of shapes:");
        noOfShapes=sc.nextInt();

        Shape[] list3d = new Shape[noOfShapes];

        for (int i=0; i<noOfShapes; i++) {
            System.out.println("Enter the shape:\n"+
                                "1. Sphere\n"+
                                "2. Cuboid\n"+
                                "3. Pyramid\n"+
                                "4. Cone\n"+
                                "5. Cylinder\n");
            choice=sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter radius of sphere:");
                    r=sc.nextInt();
                    list3d[i] = new Sphere(r);
                    break;

                case 2:
                    System.out.println("Enter length, breadth, height of cuboid");
                    l=sc.nextInt();
                    b=sc.nextInt();
                    h=sc.nextInt();
                    list3d[i] = new Cuboid(l, b, h);
                    break;

                case 3:
                    System.out.println("Enter length and height of pyramid:");
                    l=sc.nextInt();
                    h=sc.nextInt();
                    list3d[i] = new Pyramid(l, h);
                    break;

                case 4:
                    System.out.println("Enter radius and height of cone:");
                    r=sc.nextInt();
                    h=sc.nextInt();
                    list3d[i] = new Cone(r, h);
                    break;

                case 5:
                    System.out.println("Enter radius and height of cylinder");
                    r=sc.nextInt();
                    h=sc.nextInt();
                    list3d[i] = new Cylinder(r, h);
                    break;
                
                default:
                    System.out.println("Invalid value, please retry");
                    i--;
            }
            //end switch
        }

        double area=0;
        for (int i=0; i<noOfShapes; i++) {
            if (list3d[i] instanceof Square) {
                Square sq = (Square)list3d[i];
                area+=sq.area();
            }
            if (list3d[i] instanceof Cuboid) {
                Cuboid cb = (Cuboid)list3d[i];
                area+=cb.area();
            }
            if (list3d[i] instanceof Pyramid) {
                Pyramid py = (Pyramid)list3d[i];
                area+=py.area();
            }
            if (list3d[i] instanceof Cone) {
                Cone cn = (Cone)list3d[i];
                area+=cn.area();
            }
            if (list3d[i] instanceof Cylinder) {
                Cylinder cy = (Cylinder)list3d[i];
                area+=cy.area();
            }
        }
        System.out.println("Total area is "+area);

        sc.close();
    }
}