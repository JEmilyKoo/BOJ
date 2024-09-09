package class3;

import java.io.*;
import java.util.*;

public class Boj1012 {

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int M;
	static int N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("./res/input1012.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][M];
			boolean[][] v = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!v[i][j] && map[i][j] == 1) {
						bfs(i, j, map, v);
						count++;
					}
				}
			}
			sb.append(count).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static void bfs(int r, int c, int[][] map, boolean[][] v) {
		ArrayDeque<Point> dq = new ArrayDeque<>();
		dq.offer(new Point(r, c));
		while (!dq.isEmpty()) {
			Point cur = dq.poll();
			if(v[cur.r][cur.c]) continue; 
			v[cur.r][cur.c] = true;

			for (int d = 0; d < 4; d++) {
				int lr = cur.r + dr[d];
				int lc = cur.c + dc[d];

				if (0 <= lr && lr < N && 0 <= lc && lc < M && !v[lr][lc]) {
					if(map[lr][lc] == 1) {
						dq.offer(new Point(lr, lc));
					}
				}
			}
		}
	}
}
