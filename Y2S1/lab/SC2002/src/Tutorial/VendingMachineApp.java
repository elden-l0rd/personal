package Tutorial;

public class VendingMachineApp {
    public VendingMachineApp() {}

    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        System.out.println("====== Vending Machine ======\n"+
                            "|1. Buy Beer ($3.00)        |\n"+
                            "|2. Buy Coke ($1.00)        |\n"+
                            "|3. Buy Green Tea ($5.00)   |\n"+
                            "|============================");
        double d=vm.selectDrink();
        double paid;
        switch((int)d) {
            case 1:
                d=3.0;
                paid=vm.insertCoins(d);
                vm.checkChange(paid, d);
                vm.printReceipt();
                break;
            case 2:
                d=1.0;
                paid=vm.insertCoins(d);
                vm.checkChange(paid, d);
                vm.printReceipt();
                break;
            case 3:
                d=5.0;
                paid=vm.insertCoins(d);
                vm.checkChange(paid, d);
                vm.printReceipt();
                break;
        }
    }
}