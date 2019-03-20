package isbnCode;

import java.util.Scanner;


public class ISBN {
	public static void start() {
		Scanner input = new Scanner(System.in);
		String inputLine = input.nextLine();
		inputLine = inputLine.replace("-", "");
		char[] inputArray = inputLine.toCharArray();
		int sum = 0;
		int i;
		for (i = 0;i < 9; i++) {
			sum += (inputArray[i] - 48) * (i + 1);
		}
		int mod = sum % 11;
		
//		String[] code = new String[13];
//		for (int i = 0; i < 13; i++) {
//			code[i] = input.next();
//		}
	
	}
	public static void display(String code) {
//		System.out.println("进入了打印");
		for (int i = 0; i < code.length(); i++) {
//			System.out.print("打印序号" + i + "的数据");
			System.out.println(code.charAt(i));
		}
	}
}
