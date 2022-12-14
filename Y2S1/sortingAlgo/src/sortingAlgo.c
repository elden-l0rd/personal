#include <stdio.h>

////////////////////////////////////////////////////////////////
void insertionSort(int slot[500], int n);

void mergeSort(int n, int m);
void merge(int n, int m);

void quickSort(int n, int m);
int partition(int low, int high);

int heapSort(array,n);
void deleteMax(H);
void fixHeap(H,k);
void constructHeap(array,H);
void heapifying(H);
////////////////////////////////////////////////////////////////s

typedef struct Slots{
    int key;
} slot;
int main() {
    slot arr[500];
    return 1;
}

////////////////////////////////////////////////////////////////
void insertionSort(int arr[500], int n) {
    for (int i=1; i<n; i++) {
        for (int j=i; j>0; j--) {
            if (arr[j].key < arr[j-1].key) {
                arr[j] = arr[j]^arr[j-1]^(arr[j-1]=arr[j]);
            /*  swap(slot[j], slot[j-1]);   #same thing^#       */
            }
            else break;
        }
    }
}
////////////////////////////////////////////////////////////////
void mergeSort(int n, int m) {
    int mid = (n+m)/2;
    if (m-n <= 0)
        return;
    else if (m-n > 1) {
        mergeSort(n, mid);
        mergeSort(mid+1, m);
    }
    merge(n,m);
}
void merge(int n, int m) {
    int mid = (n+m)/2;
    int a=n, b=mid+1, i, tmp;
    if (m-n <= 0)
        return;
    while (a<=mid && b <= m) {
        cmp = compare(slot[a], slot[b]);
        if (cmp > 0) { // slot[a] > slot[b]
            tmp = slot[b++];
            for (i = ++mid; i>a; i--) {
                slot[i] = slot[i-1];
                slot[a++] = tmp;
            }
        }
        else if (cmp < 0)
            a++;
        else {
            if (a==mid && b==m)
                break;
            tmp = slot[b++];
            a++;
            for (i= ++mid; i>a; i--) {
                slot[i] = slot[i-1];
            }
            slot[a++]=tmp;
        }
    }
}
////////////////////////////////////////////////////////////////
void quickSort(int n, int m) {
    int pivot_pos;
    if (n>=m)
        return;
    pivot_pos = partition(n,m);
    quickSort(n, pivot_pos-1);
    quickSort(pivot_pos+1, m);
}
int partition(int low, int high) {
    int i, last_small, pivot;
    int mid = (low+high)/2;
    //swap(low,mid);
    high = high^low^(low=high);
    pivot = slot[low];
    last_small = low;

    for(i=low+1; i<=high; i++) {
        if (slot[i] < pivot)
            swap(++last_small, i);
    }
    swap(low, last_small);
    return last_small;

}
////////////////////////////////////////////////////////////////
int heapSort(array,n) {
    for (i=n; i>=1; i--) {
        curMax = getMax(H); // H = heap with n elements
        deleteMax(H);
        array[i] = curMax;
    }
}
void deleteMax(H) {
    /*
    copy rightmost element at the lowest level to k;
    delete the rightmost element at the loweset level;
    */
   fixHeap(H,k);
}
// RECURSIVE ALGO //
//void fixHeap(H,k) {
    if (H is a leaf)
        insert k in root of H;
    else {
        compare left child & right child;
        largerSubHeap = the larger child of H;
	    if ( k >= key of root(largerSubHeap) )
	        insert k in root of H;
	else {
	    insert root(largerSubHeap) in root of H;
	    fixHeap(largerSubHeap, k);
	}

    }
}
// ITERATIVE ALGO //
void fixHeap(H,k) {
    int j=1, cj=2;
    while (cj <= currentSize) {
        // cj should be the larger child of j
        if (cj<currentSize && H[cj]<H[cj+1])
            //former condition to make sure is not right node
            //prevents segmentation fault;
            cj++;
        if (k>=H[cj])
            break;
        H[j] = H[cj];
        j=cj;
        cj = 2*j;
    }
    H[j]=k;
}
void constructHeap(array,H) {
    //put all elemnts of arr into H in arbitary order;
    heapifying(H);
}
void heapifying(H) {
    if (H is not a leaf) {
        heapifying(left subtree of H);
        heapifying(right subtree of H);
        k = root(H);
        fixHeap(H,k);
    }
}
////////////////////////////////////////////////////////////////