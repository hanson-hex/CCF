package studentQueue;

import java.util.Scanner;

public class StudentQueue {
	public static void start() {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		int k = Integer.parseInt(input.nextLine());
		int[][] orders = new int[k][2];
		for (int i = 0; i < k; i++) {
			String[] inputStr = input.nextLine().split(" ");
			orders[i][0] = Integer.parseInt(inputStr[0]);
			orders[i][1] = Integer.parseInt(inputStr[1]);
		}
		int[] studentQueue = new int[n];
		for (int i = 0; i < studentQueue.length; i++) {
			studentQueue[i] = i + 1;
		}
		sendOrder(orders, studentQueue);
		printOrder(studentQueue);
	}
	public static void sendOrder(int[][] orders, int[] queue) {
		for (int i = 0; i < orders.length; i++) {
			int num = orders[i][0]; // 学号
			int index = findByNum(num, queue); // 在队列中的序号
			int step = orders[i][1]; // 命令步骤
			if (step >= 0) {
				int lastIndex = index + step; // 最后一个学生需要移动的序号
				int j = index;
				for (;j < lastIndex; j++) {
					queue[j] = queue[j + 1];
				}
				queue[j] = num;
			} else {
				int startIndex = index + step;
				int j = index;
				for (; j > startIndex; j--) {
					queue[j] = queue[j - 1];
				}
				queue[j] = num;
			}
		}
	}
	public static int findByNum(int num, int[] queue) {
		for (int i = 0; i < queue.length; i++) {
			if (queue[i] == num) {
				return i;
			}
		}
		return -1;
	}
	public static void printOrder(int[] queue) {
		for (int i = 0; i < queue.length;i++)
			System.out.print(queue[i] + " ");
		System.out.println("");
	}
}
