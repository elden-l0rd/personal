import java.util.*;

public class sorting {

    public void InsertionSort(int slot[], int n) {
        for (int i=1; i<n; i++) {
            for (int j=i; j>0; j--) {
                if (slot[j] < slot[j-1])
                    slot[j] = slot[j]^slot[j-1]^(slot[j-1]=slot[j]); //swap
                else break;
            }
        }
    }

    public void mergeSort(int n, int m) {
        int mid = (n+m)/2;
        if (m-n<=0)
            return;
        else if (m-n>1) {
            mergeSort(n, mid);
            mergeSort(mid+1, m);
        }
        merge(n,m); // NOT DONE!
    }

    public void merge(int n, int m, int slot[]) {
        int mid = (n+m)/2;
        int a=n, b=mid+1, i, tmp;
        if (m-n<0)
            return;
        while (a<=mid && b<=m) {
            int cmp = Integer.compare(slot[a], slot[b]);
            if (cmp>0)

            else if (cmp<0) {
                a++;
            }
            else {
                if (a==mid && b==m)
                    break;
                tmp = slot[b++];
                a++;
                for (i=++mid; i>a; i--) {
                    slot[i] = slot[i-1];
                }
                slot[a++]=tmp;
            }
        }
    }

}