package imageRotate;

import java.util.Scanner;

public class ImageRotate {
	public static void start() {
		Scanner input = new Scanner(System.in);
		String[] inputRC = input.nextLine().split(" ");
		int row = Integer.parseInt(inputRC[0]);
		int col = Integer.parseInt(inputRC[1]);
		int[][] matrix = new int[2][3]; 
		for (int i = 0; i < row; i++) {
			String[] rowList = input.nextLine().split(" ");
			for (int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(rowList[j]);
			}
		}
		printRotate(matrix, row, col);
	}
	public static void printRotate(int[][] matrix, int row, int col) {
		for (int i = col - 1; i >= 0; i--) {
			for (int j = 0; j < row; j++) {
				System.out.print(matrix[j][i] + " ");
			}
			System.out.println("");
		}
	}
}
