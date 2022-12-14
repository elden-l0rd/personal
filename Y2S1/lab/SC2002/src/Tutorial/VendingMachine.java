package Tutorial;
import java.util.*;

public class VendingMachine {
    public VendingMachine() {}

    public double selectDrink() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter selection:");
        double x = sc.nextDouble();
        return x;
    }

    public double insertCoins(double drinkCost) {
        double paid=0.0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please insert coins:\n"+
                            "========== Coins Input ==========\n"+
                            "|Enter 'Q' for ten cents input   |\n"+
                            "|Enter 'T' for twenty cents input|\n"+
                            "|Enter 'F' for fifty cents input |\n"+
                            "|Enter 'N' for a dollar input    |\n"+
                            "==================================");
        do {
            switch(sc.next().charAt(0)) {
                case 'Q':
                    paid+=0.10;
                    System.out.printf("Coins inserted: %.2f\n",paid);
                    break;
                case 'T':
                    paid+=0.20;
                    System.out.printf("Coins inserted: %.2f\n",paid);
                    break;
                case 'F':
                    paid+=0.50;
                    System.out.printf("Coins inserted: %.2f\n",paid);
                    break;
                case 'N':
                    paid+=1.0;
                    System.out.printf("Coins inserted: %.2f\n",paid);
                    break;
            }
        }while (paid<drinkCost);

        sc.close();
        return paid; //Coins inserted
    }

    public void checkChange(double amount, double drinkCost) {
        //System.out.printf("Coins inserted: %.2f\n",amount);
        System.out.printf("Change: $%.2f\n",(amount-drinkCost));
    }

    public void printReceipt() {
        System.out.println("Please collect your drink\n"+
                            "Thank You !!");
    }
}