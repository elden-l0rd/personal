package lab1;

import java.util.*;
public class P2 {
	private int merit;
	private int salary;

	public static void main(String[] args) {
		P2 ob = new P2();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter salary: ");
		ob.salary = sc.nextInt();
		//System.out.flush();
		System.out.println("Enter merit ");
		ob.merit = sc.nextInt();
		//System.out.flush();
		ob.grade(ob.merit, ob.salary);
		sc.close();
	}
	
	void grade(int m, int s) {
		if (s>=700 && s<900)
			if (m<20)
				System.out.printf("salary: $"+s+", merit: "+m+" - Grade B%n");
			else
				System.out.printf("salary: $"+s+", merit: "+m+" - Grade A%n");
		else if (s>=600 && s<800)
			if (m<10)
				System.out.printf("salary: $"+s+", merit: "+m+" - Grade C%n");
			else
				System.out.printf("salary: $"+s+", merit: "+m+" - Grade B%n");
		else if (s>=500 && s<600)
			//System.out.printf("\nsalary: $%d, merit: %d -Grade C", s,m);
			System.out.printf("salary: $"+s+", merit: "+m+" - Grade C%n");
			
	}

}