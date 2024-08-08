package nm;

import java.io.*;
import java.util.*;

public class Boj15649 {
	static int [] arr; 
	static int [] output;
	static boolean [] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("./res/input15649.txt")));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		arr = new int[N];
		visited = new boolean[N];
		for(int i = 0 ; i < N ; i++ ) {
			arr[i] = i+1;
		}
		output = new int[M];
		c(0, 0, M);
		
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	static void c (int start, int d, int r) {
		if( d==r) {
			for(int i = 0 ; i < output.length; i++) {
				sb.append(Integer.toString(output[i]));
				if(i != output.length -1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0 ; i < arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[d] = arr[i];
				c(i+1 , d+1, r);
				visited[i] = false;
			}
		}
		
	}
	
}
