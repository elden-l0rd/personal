package lab.SC2001.labProject3;

public class test {
    public static void main(String[] args) {
        int[] w = new int[] {2,3,4,5};
        int[] p = new int[] {1,2,5,6};
        final int C = 8;
        int n = w.length;
        test part_1 = new test();
       
        System.out.println("Recursive approach: \n"+"(1) "+part_1.knapsack(w,p,C,n)+"\n");
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