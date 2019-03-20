package dijkstra;

public class Dijkstra {
	public static void start() {
		int[][] G = testData();
		int[] result = getResult(G);
		display(result);
	}
	public static void display(int[] result) {
		for (int i = 0;i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println("");
	}
	public static int[] getResult(int[][] G) {
		boolean[] Vertix = new boolean[G.length]; // 记录是否被访问过
		int[] result = new int[G.length];
		for (int i = 1; i < G.length; i++) {
			result[i] = G[0][i];
			Vertix[i] = false;
		}
		Vertix[0] = true;
		for (int i = 1; i < G.length; i++) {
			int k = 0;
			int min = Integer.MAX_VALUE;
			for (int j = 1; j < G.length; j++) {
				if (!Vertix[j] && min > result[j] && result[j] != -1) {
					min = result[j];
					k = j;
				}
			}
			Vertix[k] = true;
			for (int t = 1; t < G.length; t++) {
				if (!Vertix[t]) {
					if (G[k][t] != -1 && (G[k][t] + min < result[t] || result[t]  == -1)) {
						result[t] = min + G[k][t];
					}
				}
			}
		}
		return result;
		
	}

	public static int[][] testData() {
		int[][] data = {{0,6,3,-1,-1,-1},
                {6,0,2,5,-1,-1},
                {3,2,0,3,4,-1},
                {-1,5,3,0,2,3},
                {-1,-1,4,2,0,5},
                {-1,-1,-1,3,5,0}};
		return data;
	}
}
