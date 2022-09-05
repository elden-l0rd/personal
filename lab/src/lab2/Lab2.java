package lab2;

import java.util.*;
public class Lab2 {
	//static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int choice; int re=0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Perform the following methods:");
			System.out.println("1: multiplication test");
			System.out.println("2: quotient using division by subtraction");
			System.out.println("3: remainder using division by subtraction"); 
			System.out.println("4: count the number of digits");
			System.out.println("5: position of a digit");
			System.out.println("6: extract all odd digits");
			System.out.println("7: quit");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1: /* add mulTest() call */
				mulTest();
				break;
			case 2: /* add divide() call */
				int m; int n; int r;
				System.out.println("Enter m and n values (press enter after each)");
				m = sc.nextInt();
				n = sc.nextInt();
				r = divide(m,n);
				System.out.println(m+"/"+n+" = "+r);
				break;
			case 3: /* add modulus() call */
				int mm; int nn; int rr;
				System.out.println("Enter m and n values (press enter after each)");
				mm = sc.nextInt();
				nn = sc.nextInt();
				rr = modulus(mm,nn);
				System.out.println(mm+" % "+nn+" = "+rr);
				break;
			case 4: /* add countDigits() call */
				System.out.println("Enter a positive integer");
				long number = sc.nextLong();
				long numbe = number;
				if (number<0)
					System.out.println("n: "+number+"- Error inputt!!\n");
				else {
					while (number>0) {
						if (countDigits((int)(number%10))==1) {
							re++;
						}
						number = number/10;
					}
					System.out.println("n: "+numbe+" - count = "+re);
					re=0;
				}
				break;
			case 5: /* add position() call */
				System.out.println("Enter a number and the specified digit after 'Enter'");
				int num = sc.nextInt();
				int digit = sc.nextInt();
				int pos = position(num, digit);
				System.out.printf("position = %d\n", pos);
				break;
			case 6: /* add extractOddDigits() call */
				System.out.println("Enter a number");
				long newnum = sc.nextLong();
				if (newnum<0) {
					System.out.println("oddDigits = Error input!!\n");
					break;
				}
				else extractOddDigits(newnum);
				break;
			case 7:
				System.out.println("Program terminating....");
				sc.close();
			}	
		} while(choice<7);
		sc.close();
	}
	
	/* add method code here */
	public static void mulTest() {
		Scanner scM = new Scanner(System.in);
		Random rand = new Random();
		int correct=5; int u;
		int a; int b;
		for (int i=0; i<5; i++) {
			a = rand.nextInt(20); b = rand.nextInt(20);
			int ans = a*b;
			System.out.printf("How much is %d times %d?\n", a,b);
			u = scM.nextInt();
			if (u!=ans)
				correct--;
		}
		System.out.printf("%d answers out of 5 are correct.\n", correct);
		//scM.close();
	}
	
	public static int divide(int m, int n) {
		int r=1; int i=0;
		if (m<n)
			return 0;
		else if (m==n)
			return 1;
		else {
			r=m;
			while (r>0) {
				if (r<n)
					return i;
				r = r-n;
				i++;
			}
			return i;
		}
	}
	
	public static int modulus(int m, int n) {
		if (m==n)
			return 0;
		else if (m<n)
			return m;
		else
			return m%n;
	}
	
	public static int countDigits(int n) {
		if (n==(int)n)
			return 1;
		else
			return 0;
	}
	
	public static int position(int n, int digit) {
		String temp = Integer.toString(n);
		String d = Integer.toString(digit);
		int count=0;
		for (int i=temp.length()-1; i>=0; i--) {
			if (temp.charAt(i)==d.charAt(0)) //String.valueOf()
				return count+1;
			count++;
		}
		return -1;
	}
	
	public static long extractOddDigits(long n) {
		if (n%2==0) {
			System.out.println("oddDigits = -1\n");
			return -1;
		}
		String a = Long.toString(n);
		long[] arr = new long[a.length()];
		int j = a.length();
		for (int k=0; k<j; k++) {
			arr[k]=0;
		}
		for (int i=a.length()-1; i>=0 && j>=0; i--) {
			if (n%2==1) {
				arr[j-1]=n%10;
				j--;
			}
			n=n/10;
		}
		for (int i=0; i<a.length(); i++) {
			if (arr[i]!=0)
				System.out.print(arr[i]);
		}
		System.out.println();
		return 0;
	}

}