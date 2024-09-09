package gold2;

import java.util.*;
import java.io.*;

public class Boj3109 {
	static char[][] map;
	static boolean[][] v;
	static int MaxPipe, R, C;
	static int[] dr = { -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("./res/input3109.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		MaxPipe = 0;
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			dfs(i, 0);
		}

		v = new boolean[R][C];
		System.out.println(MaxPipe);
	}

	static boolean dfs(int r, int c) {
		if (c == C - 1) {
			MaxPipe++;
			return true;
		}
		for (int d = 0; d < 3; d++) {
			int lr = r + dr[d];
			int lc = c + 1;
			if (0 <= lr && lr < R && map[lr][lc] == '.') {
				map[lr][lc] = '-';
				if (dfs(lr, lc)) {
					return true;
				}
			}
		}
		return false;
	}
}
