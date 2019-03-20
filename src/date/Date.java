package date;

import java.util.Scanner;
// 50分
public class Date {
	public static void start() {
		Scanner input = new Scanner(System.in);
		int mouth = input.nextInt();
		int num = input.nextInt();
		int week = input.nextInt();
		int startYear = input.nextInt();
		int endYear = input.nextInt();
		for (int i = startYear; i <= endYear; i++) {
			int sum = 0;
			for (int k = 1850; k < i; k++) {
				sum += addOneyear(k);
			}
			int[] mouthList = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			if (isSu(i)) {
				mouthList[2] = 29;
			}
			for (int j = 1; j < mouth; j++) {
				sum += mouthList[j];
			}
			int week2 = sum % 7;
			week2 = week2 + 2;
			if (week2 > 7) {
				week2 = week2 - 7;
			}
			int day = 7 * (num - 1) + Math.abs(week2 - week) + 1;
			if (day > mouthList[mouth]) {
				System.out.println("none");
				continue;
			}
			StringBuilder result = new StringBuilder();
			result.append(i);
			result.append('/');
			if (mouth < 10) {
				result.append(0);
			}
			result.append(mouth);
			result.append('/');
			if (day < 10) {
				result.append(0);
			}
			result.append(day);
			System.out.println(result.toString());
		}
	}

	public static int addOneyear(int i) {
		if (isSu(i)) {
			return 366;
		} else {
			return 365;
		}
	}

	public static boolean isSu(int year) {
		return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
	}
}
