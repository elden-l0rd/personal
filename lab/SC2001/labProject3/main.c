#include <stdio.h>

int main() {
    int n = 3+1;
    int w[n] = [0,4,6,8];
    int P[n] = [0,7,6,9];
    int static C = 14;

    int maxPrice = knapsack(w,P,C,n);
    printf("max price C = %d", maxPrice);
    return 0;
}

int knapsack(int w, int P, int C, int n) {
    int maxC=0;
    int M[n][n];
    if

    //initialise matrix
    for (int i=0; i<1; i++) {
        for (int j=0; j<1; j++) {
            M[i][j]=M[j][i]=0;
        }
    }

    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            //
        }
    }


    return maxC;
}

int max(int x, int y) {
    return (x>y)?x:y;
}