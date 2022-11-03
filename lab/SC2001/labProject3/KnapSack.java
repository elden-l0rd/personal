package lab.SC2001.labProject3;

public class KnapSack {
    public static void main(String[] args) {
        int[] w = new int[] {4,6,8};
        int[] p = new int[] {7,6,9};
        final int C = 14;
        int n = w.length;
        KnapSack part_1 = new KnapSack();
        KnapSack part_2 = new KnapSack();
        int[] w2 = new int[] {5,6,8};
        int[] p2 = new int[] {7,6,9};
        int n2 = w2.length;
        System.out.println("Recursive approach: \n"+"(1) "+part_1.knapsack(w,p,C,n)+"\n" +
                            "(4) "+part_2.knapsack(w2,p2,C,n2));
    }

    public int knapsack(int[] w, int[] p, int C, int n) {
        if (n==0 || C==0) {
            return 0;
        }
        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if (w[n-1] > C) {
            return knapsack(w,p,C,n-1);
        }
        else {
            return max(p[n-1]+knapsack(w,p,C-w[n-1],n-1), knapsack(w,p,C,n-1));
        }
    
    }

    public int max(int a, int b) {
        return (a>b)?a:b;
    }
}
