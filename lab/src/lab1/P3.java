package lab1;

import java.util.*;
public class P3 {
	
	public static void main(String[] args) {
		double rr=1.82;
		double r=0;
		int c=0;
		Scanner sc = new Scanner(System.in);
		// First table
		System.out.println("Enter starting value: ");
		int s = sc.nextInt();
		System.out.println("Enter ending value: ");
		int e = sc.nextInt();
		System.out.println("Enter increment value: ");
		int incre = sc.nextInt();
		double[] arr = new double[e/incre];
		for (int i=s; i<=e; i+=incre) {
			r+=rr;
			arr[c] = r;
			c++;
		}
		System.out.printf("starting: %d, ending: %d, increment: %d%n", s,e,incre);
		System.out.println("US$         S$");
		System.out.println("--------------");
		c=0;
		for (int i=s; i<=e; i+=incre) {
			System.out.printf("%d           %.2f%n",i,arr[c]);
			c++;
		}
		

		// Second table
		c=0;
		System.out.println("Enter starting value: ");
		s = sc.nextInt();
		System.out.println("Enter ending value: ");
		e = sc.nextInt();
		System.out.println("Enter increment value: ");
		incre = sc.nextInt();
		int i=s;
		double[] arr2 = new double[(e/incre)+1];
		while (i<=e) {
			arr2[c] = rr*(i);
			c++;
			i+=incre;
		}
		i=s; c=0;
		while (i<=e) {
			System.out.printf("%d           %.1f%n",i,arr2[c]);
			c++; i+=incre;
		}
		
		
		// Third table (error input)
		do {
			System.out.println("Enter starting value: ");
			s = sc.nextInt();
			System.out.println("Enter ending value: ");
			e = sc.nextInt();
			System.out.println("Enter increment value: ");
			incre = sc.nextInt();
			System.out.printf("starting: %d, ending: %d, increment: %d - Error input!!", s,e,incre);
		} while(s<e);
		
		sc.close();
	}

}