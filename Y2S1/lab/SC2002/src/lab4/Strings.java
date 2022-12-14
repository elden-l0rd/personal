package lab4;

import java.util.*;
public class Strings{
// --------------------------------------------
// Reads in an array of integers, sorts them,
// then prints them in sorted order.
// --------------------------------------------
    public static void main (String[] args) {
        Comparable[] stringList;
        int size;
        Scanner scan = new Scanner(System.in);
        System.out.print ("\nHow many letters do you want to sort? ");
        size = scan.nextInt();
        stringList = new Comparable[size];
        System.out.println ("\nEnter the letters...");
        for (int i = 0; i < size; i++)
            stringList[i] = scan.next();
            Sorting.insertionSort(stringList);
            System.out.println ("\nYour letters in sorted order...");
        for (int i = 0; i < size; i++)
            System.out.print(stringList[i] + " ");
        System.out.println ();
        }
}