package gold4;

import java.io.*;
import java.util.*;
public class Boj17144 {
	static void circulate(int[] dr, int[] dc, int Ar, int Ac) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {Ar,Ac,0, 0});
		map[Ar][Ac] = 0;
		while(!dq.isEmpty()) {
			int [] t = dq.poll();
			
			int lr = t[0] + dr[t[2]];
			int lc = t[1] + dc[t[2]];
			if(t[2]!=0 && lr == Ar && lc == Ac) {
				map[t[0]][t[1]] = 0;
				map[Ar][Ac] = -1;
				break;
			}
			if(0>lr || lr >= R || 0>lc || lc>= C) {
				dq.offer(new int [] {t[0], t[1], (t[2] + 1)%4});
				continue;
			}
			
			if(t[2]==2 && lr == Ar) {
				dq.offer(new int [] {lr, lc, (t[2] + 1)%4});
				map[lr][lc] = map[t[0]][t[1]]; 
				continue;
			}
			else {
				dq.offer(new int [] {lr, lc, t[2]});
				map[t[0]][t[1]] = map[lr][lc];
			}
		}
		


		System.out.println("------------");
		for(int[] a : map) System.out.println(Arrays.toString(a));
		
	}
	
	static int[] dr1 = { -1, 0, 1, 0 }; // ¡è¡æ¡é¡ç
	static int[] dc1 = { 0, 1, 0, -1 }; // ¡è¡æ¡é¡ç
	static int[] dr2 = { 1, 0, -1, 0 }; // ¡é¡æ¡è¡ç
	static int[] dc2 = { 0, 1, 0, -1 }; // ¡é¡æ¡è¡ç
	static int R;
	static int C;
	static int T;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("./res/input17144.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int [R][C];
		
		int A1r = 0;
		int A1c = 0;
		int A2r = 0;
		int A2c = 0;
		boolean A1 = true;
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1 && A1) {
					A1r = i;
					A1c = j;
					A1 = false;
				}
				else if (map[i][j] == -1) {
					A2r = i;
					A2c = j;
				}
			}
		}
		circulate(dr1, dc1, A1r, A1c);
		circulate(dr2, dc2, A2r, A2c);
	}
}
