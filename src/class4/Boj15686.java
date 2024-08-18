package class4;

import java.io.*;
import java.util.*;

public class Boj15686 {
	static void subs(int cnt, int d, int r) {
		if (cnt > M) {
			return;
		}
		if (d == r) {
			if (cnt == 0) return;
			int chickenDistance = 0;
			for (int i = 0; i < hList.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int v = 0; v < visited.length; v++) {
					if (visited[v]) {
						min = Math.min(min, arr[i][v]);
					}
				}
				chickenDistance += min;
			}
			minChickenDistance = Math.min(chickenDistance, minChickenDistance);
			return;
		}

		visited[d] = true;
		subs(cnt + 1, d + 1, r);
		visited[d] = false;
		subs(cnt, d + 1, r);

	}

	static int[] output;
	static int[][] arr;
	static int[][] map;
	static int N;
	static int M;
	static boolean[] visited;
	static List<int[]> cList;
	static List<int[]> hList;
	static int minChickenDistance;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("./res/input15686.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		minChickenDistance = Integer.MAX_VALUE;
		hList = new ArrayList<int[]>();
		cList = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					cList.add(new int[] { i, j });
				} else if (map[i][j] == 1) {
					hList.add(new int[] { i, j });
				}
			}
		}
		output = new int[M];
		visited = new boolean[cList.size()];
		arr = new int[hList.size()][cList.size()];

		for (int i = 0; i < hList.size(); i++) {
			for (int j = 0; j < cList.size(); j++) {
				arr[i][j] = Math.abs(hList.get(i)[0] - cList.get(j)[0]) + Math.abs(hList.get(i)[1] - cList.get(j)[1]);
			}
		}

		subs(0, 0, cList.size());
		br.close();
		System.out.println(minChickenDistance);
	}
}
