package countLeapYear;

import java.util.*;

public class CountLeapYear {
	public static void start() {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		YearItem[] alist = new YearItem[n];
		for (int i = 0; i < n; i++) {
			String[] lineStr = input.nextLine().split("\\s");
			int startYear = Integer.parseInt(lineStr[0]);
			int endYear = Integer.parseInt(lineStr[1]);
			alist[i] = new YearItem(startYear, endYear);
		}
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = alist[i].startYear; j <= alist[i].endyear; j++) {
				if (isLeap(j)) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

	public static boolean isLeap(int n) {

		return (n % 4 == 0 && n % 100 != 0) || n % 400 == 0;
	}
}

class YearItem {
	public int startYear;
	public int endyear;

	public YearItem(int startYear, int endYear) {
		this.startYear = startYear;
		this.endyear = endYear;
	}
}