package gold4;
import java.io.*;
import java.util.*;

public class Boj3055 {
	public static class Cell implements Comparable<Cell> {
		int r, c, water;
		Cell(int r, int c, int water) {
			this.r = r;
			this.c = c;
			this.water = water;
		}

		@Override
		public int compareTo(Cell o) {
			return this.water - o.water;
		}
	}

	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("./res/input3055.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];

		PriorityQueue<Cell> water = new PriorityQueue<>();
		ArrayDeque<Cell> sonic = new ArrayDeque<>();
		int[][] waterMap = new int[R][C];
		boolean[][] waterV = new boolean[R][C];
		boolean[][] v = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '*')
					water.offer(new Cell(i, j, 0));
				else if (map[i][j] == 'S')
					sonic.offer(new Cell(i, j, 0));
			}
		}

		while (!water.isEmpty()) {
			Cell cell = water.poll();
			if (waterV[cell.r][cell.c])
				continue;
			waterV[cell.r][cell.c] = true;
			waterMap[cell.r][cell.c] = cell.water;
			for (int d = 0; d < 4; d++) {
				int lr = cell.r + dr[d];
				int lc = cell.c + dc[d];
				if (0 <= lr && lr < R && 0 <= lc && lc < C && !waterV[lr][lc] && map[lr][lc] == '.') {
					water.offer(new Cell(lr, lc, cell.water + 1));
				}
			}
		}

		int result = -1;
		while (!sonic.isEmpty()) {
			Cell cell = sonic.poll();
			if (v[cell.r][cell.c])
				continue;
			v[cell.r][cell.c] = true;
			if (0 != waterMap[cell.r][cell.c] && cell.water >= waterMap[cell.r][cell.c])
				continue;
			if (map[cell.r][cell.c] == 'D') {
				result = cell.water;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int lr = cell.r + dr[d];
				int lc = cell.c + dc[d];
				if (0 <= lr && lr < R && 0 <= lc && lc < C && !v[lr][lc]
						&& (map[lr][lc] == '.' || map[lr][lc] == 'D')) {
					sonic.offer(new Cell(lr, lc, cell.water + 1));
				}
			}
		}
		System.out.println(result == -1 ? "KAKTUS" : result);

		br.close();
	}
}
