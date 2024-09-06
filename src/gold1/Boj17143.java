package gold1;

import java.io.*;
import java.util.*;

public class Boj17143 {
	static class Shark {
		boolean die;
		int r, c, s, dr, dc, z, index;

		public Shark(int r, int c, int s, int dr, int dc, int z, int index) {
			this.die = false;
			this.r = r;
			this.c = c;
			this.s = s;
			this.dr = dr;
			this.dc = dc;
			this.z = z;
			this.index = index;
		}
	}

	static int R;
	static int C;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[][] map;
	static List<Shark> sharkList;

	// d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("./res/input17143.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sharkCnt = 0;
		int king = 0;
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		sharkList = new ArrayList<Shark>();
		if (M == 0) {
			System.out.println(0);
			return;
		}

		for(int i = 0 ; i < R; i++) {
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = -1;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());

			Shark shark = new Shark(r, c, s, dr[d], dc[d], z, i);
			map[r][c] = i;
			sharkList.add(shark);
		}
		while (king < C) {
			sharkCnt += fishing(king, R);
			
			int[][] newMap = new int [R][C];

			for(int i = 0 ; i < R; i++) {
				for(int j = 0 ; j < C ; j++) {
					newMap[i][j] = -1;
				}
			}
			
			for (Shark shark : sharkList) {
				if (!shark.die) {
					move(shark, newMap);
				}
			}
			king++;
		}
		System.out.print(sharkCnt);
	}

	static int fishing(int king, int R) {
		for (int i = 0; i < R; i++) {
			int index = map[i][king];
			if (index >= 0) {
				map[i][king] = -1;
				sharkList.get(index).die = true;
				return sharkList.get(index).z;
			}
		}
		return 0;
	}

	static boolean eat(Shark shark, int r, int c, int[][]map2) {
		if (shark.r == r && shark.c == c)
			return false;
		int eater = map2[shark.r][shark.c];
		int prey = map2[r][c];

		map2[shark.r][shark.c] = -1;
		if (prey == -1) {
			map2[r][c] = eater;
			return true;
		}

		int preyZ = sharkList.get(prey).z;
		if (shark.z > preyZ) {
			sharkList.get(prey).die = true;
			map2[r][c] = eater;
			return true;
		} else {
			shark.die = true;
			return false;
		}
	}

	static void move(Shark shark, int[][] newMap) {
		int moveCnt = shark.s;
		int r = shark.r;
		int c = shark.c;
		
		
		while (--moveCnt >= 0) {
			int lr = r + shark.dr;
			int lc = c + shark.dc;
			if (0 <= lr && lr < R && 0 <= lc && lc < C) {
				r = lr;
				c = lc;
			} else {
				shark.dr *= -1;
				shark.dc *= -1;
				moveCnt++;
			}
		}

		
		if(newMap[r][c]==-1) {
			newMap[r][c] = shark.index;	
			shark.r = r;
			shark.c = c;
			return;
		}
		
		if(eat(shark, shark.r, shark.c, newMap)){
			shark.r = r;
			shark.c = c;
		}	
	}
}
