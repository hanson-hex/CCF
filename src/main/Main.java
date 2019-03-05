package main;


import java.security.PublicKey;

//import collideBall.CollideBall;
import joeph.Joeph;
//import publicKeyBox.PublicKeyBox;
//import publicKeyBox.Teacher;
//import studentQueue.StudentQueue;

import java.util.*;


public class Main {
	public static void main(String[] args) {
//		CollideBall.st5art();
//		Joeph.start();
//		Joeph.start2();
//		Joeph.start3();
//		PublicKeyBox.start();
//		CollideBall.start();
//		System.out.println(1/2);
		ImageRotate.start();
	}
	
}

class ImageRotate {
	public static void start() {
		Scanner input = new Scanner(System.in);
		String[] inputRC = input.nextLine().split(" ");
		int row = Integer.parseInt(inputRC[0]);
		int col = Integer.parseInt(inputRC[1]);
		int[][] matrix = new int[row][col]; 
//		System.out.print(row + " " + col);
		for (int i = 0; i < row; i++) {
			String[] rowList = input.nextLine().split(" ");
//			System.out.println(rowList.length);
			for (int j = 0; j < col; j++) {
//				System.out.print(j);
//				System.out.println( " :" + rowList[j]);
				matrix[i][j] = Integer.parseInt(rowList[j]);
			}
		}
//		printMatrix(matrix);
		printRotate(matrix, row, col);
	}
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length;j++) {
				System.out.println(matrix[i][j]);
			}
		}
	}
	public static void printRotate(int[][] matrix, int row, int col) {
		for (int i = col - 1; i >= 0; i--) {
			for (int j = 0; j < row; j++) {
				System.out.print(matrix[j][i] + " ");
			}
			System.out.println();
		}
	}
}
