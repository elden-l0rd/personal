import java.util.*;
public class Lab2p1 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int choice;
		//Scanner sc = new Scanner(System.in);
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
				int i=0;
				System.out.println("Enter a positive integer");
				long number = sc.nextLong();
				long numbe = number;
				if (number<0)
					System.out.println("n: "+number+"- Error inputt!!\n");
				else {
					int re;
					while (number>0) {
						re = countDigits((int)(number%10));
						if (re==1)
							i++;
						number = number/10;
					}
					System.out.println("n: "+numbe);
				}
				break;
			case 5: /* add position() call */
				System.out.println("Enter a number and the specified digit after 'Enter'");
				int num = sc.nextInt();
				int digit = sc.nextInt();
				int pos = position(num, digit);
				System.out.printf("position = %d, digit: %d\n", pos, digit);
				break;
			case 6: /* add extractOddDigits() call */
				System.out.println("Enter a number");
				long newnum = sc.nextLong();
				if (newnum<0)
					System.out.println("oddDigits = Error input!!");
				System.out.printf("oddDigits = ", extractOddDigits(newnum));
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
		//Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int correct=5; int u;
		int a; int b;
		for (int i=0; i<5; i++) {
			a = rand.nextInt(20); b = rand.nextInt(20);
			int ans = a*b;
			System.out.printf("How much is %d times %d?\n", a,b);
			u = sc.nextInt();
			if (u!=ans)
				correct--;
		}
		System.out.printf("%d answers out of 5 are correct.\n", correct);
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
		if (Character.isDigit(n))
			return 1;
		else
			return 0;
	}
	
	public static int position(int n, int digit) {
		String temp = Integer.toString(n);
		int[] arr = new int[temp.length()];
		for (int i=0; i<temp.length(); i++) {
			arr[i] = temp.charAt(i);
		}
		int t=0;
		for (int i=0; i<temp.length(); i++) {
			if (arr[i]==digit)
				t=i;
		}
		if (t==99)
			return -1; // it's returning this all the time;
		else
			return t+1;
	}
	
	public static long extractOddDigits(long n) {
		long[] arr = new long[10];
		int i=0;
		while (n>0) {
			arr[i] = n%10;
			n/=10;
			i++;
		}
		long str=0;
		int k=0;
		for (int j=0; j<i; j++) {
			if (arr[j]/2 != 0) {
				str += (arr[j]*(Math.pow(10,k++)));
			}
		}
		return str;
	}
	
}