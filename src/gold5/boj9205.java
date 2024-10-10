package gold5;
import java.io.*;
import java.util.*;

public class boj9205 {
	public static int [][] distance;  
	public static int maxBeer;
	public static int max =65534;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("./res/input9205.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		maxBeer = 50 * 20;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int [][] map = new int [N+2][2];
			for (int i = 0 ; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int [][] distance = new int [N+2][N+2];  //노드 별 거리 
			for (int i = 0 ; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {  // 도착지
                    distance[i][j] = Math.abs(map[i][0] - map[j][0]) + Math.abs(map[i][1]- map[j][1]);
                    if(distance[i][j]>maxBeer) {
                    	distance[i][j] = max;
                    }
                }
			}
			
	        for (int k = 0; k < N+2; k++) { 
	            for (int i = 0; i < N+2; i++) { 
	                if (i == k) continue;
	                for (int j = 0; j < N+2; j++) {  
	                    if (j == i || j == k) continue;
	                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
	                }
	            }
	        }
			boolean go = distance[N+1][0] < max ;
			sb.append(go? "happy" : "sad").append('\n');
		}
		
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
