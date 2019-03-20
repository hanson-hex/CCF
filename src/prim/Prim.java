package prim;

import java.util.ArrayList;


public class Prim {
	public static void start() {
		int[][] G = testData();
		int[][] result = G;
		int[] vertix = new int[G.length]; // 记录那些节点以及被遍历了 -2表示已经被遍历了
		for (int i = 0; i < G.length; i++) {
			vertix[i] = i;
		}
		ArrayList<Integer> ListV = new ArrayList<Integer>();
		ListV.add(0);
		vertix[0] = -2; 
		while(ListV.size() < G.length) {
			int min = Integer.MAX_VALUE;
			int minV = 0;
			int minJ = 0;
			for (int i = 0; i < G.length; i++) {
				int v1 = ListV.get(i);
				for (int j = 0; j < G[i].length; j++) {
					if (vertix[j] != -2) {
						if (min > G[v1][j] && G[v1][j] != -1) {
							min = G[v1][j];
							minV = v1;
							minJ = j;
						}
					}
				}	
			vertix[minV] = -2;
			result[minV][minJ] = 0;
			result[minJ][minV] = 0;
			ListV.add(minJ);
			}
		}
		
	}
	public static int[][] testData() {
		int[][] data = {{-1,3,-1,-1,6,5},
                {3,-1,1,-1,-1,4},
                {-1,1,-1,6,-1,4},
                {-1,-1,6,-1,8,5},
                {6,-1,-1,8,-1,2},
                {5,4,4,5,2,-1}};;
		return data;
	}
	public static void display(int[] result) {
		for (int i = 0;i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println("");
	}
}
