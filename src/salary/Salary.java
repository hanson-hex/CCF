package salary;

import java.util.Scanner;



public class Salary {
	public static void start() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int bn = beforeTax(n);
		System.out.println(bn);
		}
	public static int beforeTax(int n) {
		int a = n - 3500;
		int more = 0;
		if (a <= 0) {
			return n;
		} else if (a <= 1500 + 45) {
			more = (int)(a / (1 + 0.03));
		} else if (a <= 4500 + 45 + 300) {
			a = a - 45;
			more = (int)((a - 1500) / (1 + 0.1));
			return 3500 + 1500 + more;
		} else if (a <= 9000 + 45 + 300 + 900) {
			a = a - 45 - 300;
			more = (int)((a - 4500) / (1 + 0.2));
			return 3500 + 4500 + more;
		}  else if (a <= 35000 + 45 + 300 + 900 + 6500) {
			a = a - 45 - 300 - 900;
			more = (int)((a - 9000) / (1 + 0.25));
			return 3500 + 9000 + more;
		} else if (a <= 55000 + 45 + 300 + 900 + 6500 + 6000) {
			a = a - 45 - 300 - 900 - 6500;
			more = (int)((a - 35000) / (1 + 0.3));
			return 3500 + 35000 + more;
		} else if (a <= 80000 + 45 + 300 + 900 + 6500 + 6000 + 8750) {
			a = a - 45 - 300 - 900 - 6500 - 6000;
			more = (int)((a - 55000) / (1 + 0.35));
			return 3500 + 55000 + more;
		} else {
			a = a - 45 - 300 - 900 - 6500 - 6000 - 8750;
			more = (int)((a - 80000) / (1 + 0.45));
			return 3500 + 80000 + more;
		}
	}
}
