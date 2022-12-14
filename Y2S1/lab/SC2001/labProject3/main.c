#include <stdio.h>
#define C 14

int main() {
    int n = 3+1;
    int w[4] = {0,4,6,8};
    int P[4] = {0,7,6,9};

    int maxPrice = knapsack(w,P,C,n);
    printf("max price C = %d", maxPrice);
    return 0;
}

int knapsack(int w[], int P[], int C, int n) {
    int maxC=0;
    int M[4][4];
    if (C==0) return 0;

    //initialise matrix
    for (int i=0; i<4; i++) {
        M[0][i]=0;
    }
    for (int i=1; i<C; i++) {
        M[i][0]=0;
    }

    for (int i=1; i<C; i++) {
        for (int j=1; j<4; j++) {
            M[i][j] = M[i][j-1];
            if (w[j]<=i) {
                if (M[i][j] < M[i-w[j]][j-1]+P[j]) {
                    M[i][j] = P[4-w[j]][j-1]+P[j];
                }
            }
        }
    }

    return maxC;
}

int max(int x, int y) {
    return (x>y)?x:y;
}