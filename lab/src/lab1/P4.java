package lab1;

import java.util.*;
public class P4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter height: ");
		int h = sc.nextInt();
		if (h==0)
			System.out.println("height=0 - Error input!!");
		String a = "AA";
		String b = "BB";
		int i=0;
		while (i<h) {
			 
			if (i%2 == 0) {//even
				System.out.printf(a);
				for (int j=0; j<i; j++) {
					if (j%2 == 0)
						System.out.printf(b);
					else
						System.out.printf(a);
				}
			}

			else {//odd
				System.out.print(b);
				for (int j=0; j<i; j++) {
					if (j%2 == 0)
						System.out.printf(a);
					else
						System.out.printf(b);
				}
			}
			
			i++;
			System.out.println();
		}
		sc.close();
	}

}