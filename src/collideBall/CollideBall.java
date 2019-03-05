package collideBall;
/**
数轴上有一条长度为L（L为偶数)的线段，左端点在原点，右端点在坐标L处。有n个不计体积的小球在线段上，开始时所有的小球都处在偶数坐标上，速度方向向右，速度大小为1单位长度每秒。
当小球到达线段的端点（左端点或右端点）的时候，会立即向相反的方向移动，速度大小仍然为原来大小。
当两个小球撞到一起的时候，两个小球会分别向与自己原来移动的方向相反的方向，以原来的速度大小继续移动。
现在，告诉你线段的长度L，小球数量n，以及n个小球的初始位置，请你计算t秒之后，各个小球的位置。

提示:

因为所有小球的初始位置都为偶数，而且线段的长度为偶数，可以证明，不会有三个小球同时相撞，小球到达线段端点以及小球之间的碰撞时刻均为整数。

 　　同时也可以证明两个小球发生碰撞的位置一定是整数（但不一定是偶数）。

输入格式：输入的第一行包含三个整数n, L, t，用空格分隔，分别表示小球的个数、线段长度和你需要计算t秒之后小球的位置。

第二行包含n个整数a1, a2, …, an，用空格分隔，表示初始时刻n个小球的位置。

输出格式：输出一行包含n个整数，用空格分隔，第i个整数代表初始时刻位于ai的小球，在t秒之后的位置。

样例输入：

3 10 5
4 6 8

样例输出：7 99

样例说明

初始时，三个小球的位置分别为4, 6, 8。

一秒后，三个小球的位置分别为5, 7, 9。

两秒后，第三个小球碰到墙壁，速度反向，三个小球位置分别为6, 8, 10。

三秒后，第二个小球与第三个小球在位置9发生碰撞，速度反向（注意碰撞位置不一定为偶数），三个小球位置分别为7, 9, 9。

四秒后，第一个小球与第二个小球在位置8发生碰撞，速度反向，第三个小球碰到墙壁，速度反向，三个小球位置分别为8, 8, 10。

五秒后，三个小球的位置分别为7, 9, 9。

数据规模和约定：对于所有评测用例，1 ≤ n ≤ 100，1 ≤ t ≤ 100，2 ≤ L ≤ 1000，0 < ai < L。L为偶数。
保证所有小球的初始位置互不相同且均为偶数。
**/
import java.util.Scanner;

public class CollideBall {
	public CollideBall () {
	}
	public static void start() {
		Scanner input = new Scanner(System.in);
		String inputNk = input.nextLine();
		String[] arrNLT = inputNk.split("\\s");
		int n = Integer.parseInt(arrNLT[0]);
		int l = Integer.parseInt(arrNLT[1]);
		int t = Integer.parseInt(arrNLT[2]);
		String[] arrBallStr = input.nextLine().split("\\s");
		int[][] arrBalls = new int[n][2];
		for (int i = 0; i < n; i++) {
			arrBalls[i][0] = Integer.parseInt(arrBallStr[i]);
			arrBalls[i][1] = 1;
		}
		for (int i = 0; i < t; i++) {
			ballMove(l, arrBalls);
			printBall(arrBalls);
		}
//		printBall(arrBalls);
	}
	public static void printBall(int[][] arrBalls) {
		for (int i = 0; i < arrBalls.length;i++) {
			System.out.print(arrBalls[i][0] + " ");
		}
		System.out.println("");
	}
	public static void ballMove(int l, int[][] arrBalls) {
		for (int i = 0; i < arrBalls.length;i++) {
			arrBalls[i][0] = arrBalls[i][0] + arrBalls[i][1];
			checkBoundary(i, arrBalls);
		}
		checkCollide(l, arrBalls);
		
	}
	public static void checkBoundary(int i, int[][] arrBalls) {
		if (arrBalls[i][0] == 10) {
			arrBalls[i][1] = -1;
		} else if(arrBalls[i][0] == 0) {
			arrBalls[i][1] = 1;
		} 
	}
	public static void checkCollide(int l, int[][] arrBalls) {
		for (int i = 0; i < arrBalls.length - 1; i++) {
			if (arrBalls[i][0] == arrBalls[i + 1][0]) {
				arrBalls[i][1] = -1 * arrBalls[i][1];
				arrBalls[i + 1][1] = -1 * arrBalls[i + 1][1];
			}
		}
	}
}
