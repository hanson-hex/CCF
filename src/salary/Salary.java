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
		double[] tax = {0, 1500, 3000, 4500, 26000, 20000, 25000};
		double[] rate = {0.03, 0.1, 0.2, 0.25, 0.3, 0.35, 0.45};
		double[] rank_money = new double[tax.length];
		for (int i = 1; i < rank_money.length; i++) {
			double temp = tax[i] * rate[i - 1];
			rank_money[i] = rank_money[i - 1] + temp;
		}
		// 
		int[] mon = {0, 1500, 4500, 9000, 35000, 55000, 80000};
		if (n <= 3500) {
			return n;
		} else {
			for (int i = 3600;;i += 100) {
					double a = i - 3500;
					double s = 0;
					for (int j = mon.length - 1; j >= 0; j--) {
						if (a >= mon[j]) {
							s += (a - mon[j]) * rate[j] + rank_money[j];
							break;
						}
					}
					if (i - s == n) {
						return i;
					}
			}
		}
	}
	public static void display(double[] arrayList)  {
		for (int i = 0; i < arrayList.length; i++) {
			System.out.print(arrayList[i] + " ");
		}
		System.out.println(" ");
	}
}
