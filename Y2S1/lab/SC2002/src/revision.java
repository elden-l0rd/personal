import java.util.*;
import java.lang.*;

public class revision {

    // public static void main(String[] args) {
    //     revision ex1 = new revision();
    //     ArrayList<Integer> list = new ArrayList<Integer>(10);
    //     for (int i=0; i<10; i++) {
    //         list.add((int)(Math.pow(-1, i))*(i*i*i+3));
    //     }
    //     System.out.println("Original list:"+list);
    //     ex1.insertionSortIter(list, 10);
    //     System.out.println("After sorting:"+list);
    //     return;
    // }

    // public static void main(String[] args) {
    //     revision ex2 = new revision();
    //     int[] arr = {2,1,5,8,3,4,9,3,5,43,5,7,234,-1,56,23,83,95,0,63,52,28,382};
    //     System.out.println("Before sorting: "+Arrays.toString(arr));
    //     ex2.mergeSort(arr, 0, arr.length-1);
    //     System.out.println("After sorting: "+Arrays.toString(arr));
    //     return;
    // }

        public static void main(String[] args) {
            revision ex3 = new revision();
            int[] arr = {2,1,5,8,3,4,-256,14,3,5,43,5,7,234,-1,56,23,83,95,0,63,52,28,382,7};
            System.out.println("Before sorting: "+Arrays.toString(arr));
            ex3.quickSort(arr, 0, arr.length-1);
            System.out.println("After sorting: "+Arrays.toString(arr));
            return;
        }

    void insertionSortIter(ArrayList<Integer> ALIST, int n) {
    //     Integer[] slot = new Integer[n];
    //     slot = (Integer[])(ALIST.toArray());
    //     for (int i=0; i<n; i++) {
    //         for (int j=i; j>0; j--) {
    //             if (slot[j-1] > slot[j]) {
    //                 slot[j] = slot[j]^slot[j-1]^(slot[j-1]=slot[j]);
    //             }
    //         }
    //     }
    // }

        for (int i=0; i<n; i++) {
            int tmp;
            for (int j=i; j>0; j--) {
                if (ALIST.get(j-1) > ALIST.get(j)) {
                    tmp = ALIST.get(j);
                    ALIST.set(j, j-1);
                    ALIST.set(j-1, tmp);
                }
            }
        }
    }

    void mergeSort(int[] arr, int n, int m) {
        int mid = (n+m)/2;
        if (m-n<=0) return;
        else if (m-n>1) {
            mergeSort(arr, n, mid);
            mergeSort(arr, mid+1, m);
        }
        merge(arr,n,m);
    }

    void merge(int[] arr, int n, int m) {
        int mid = (n+m)/2;
        int a=n, b=mid+1, tmp;
        if (m-n<=0) return;
        while (a<=mid && b<=m) {
            int cmp = compare(arr[a], arr[b]);
            if (cmp==0) {
                if (a==mid && b==m) break;
                tmp = arr[b++];
                a++;
                for (int i=++mid; i>a; i--) {
                    arr[i] = arr[i-1];
                }
                arr[a++] = tmp;
            }
            else if (cmp>0) {
                tmp = arr[b++];
                for (int i=++mid; i>a; i--) {
                    arr[i] = arr[i-1];
                }
                arr[a++] = tmp;
            }
            else {
                //cmp<0
                a++;
            }
        }
        return;
    }

    int compare(int a, int b) {
        if (a==b) return 0;
        else if (a>b) return 1;
        else return -1;
    }

    void quickSort(int[] arr, int n, int m) {
        int pivot_pos;
        if (n>=m) return;
        pivot_pos = partition(arr, n, m);
        quickSort(arr, n, pivot_pos-1);
        quickSort(arr, pivot_pos+1, m);
    }

    int partition(int[] arr, int low, int high) {
        int last_small, pivot;
        int mid = (low+high)/2;
        arr[low] = arr[low]^arr[mid]^(arr[mid]=arr[low]);
        pivot = arr[low];
        last_small = low;

        for (int i=low+1; i<=high; i++) {
            if (arr[i]<pivot) {
                arr[++last_small] = arr[last_small]^arr[i]^(arr[i]=arr[last_small]);
            }
        }
        arr[last_small] = arr[last_small]^arr[low]^(arr[low]=arr[last_small]);
        return last_small;
    }
}
