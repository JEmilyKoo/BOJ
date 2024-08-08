package nm;

import java.io.*;
import java.util.StringTokenizer;

public class Boj15651 {
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("./res/inputcps.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int [N];
		output = new int [M];
		visited = new boolean [N];
		p(0,0,M);
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void p (int s, int d, int r) {
		if(d==r) {
			for(int i = 0; i < output.length; i ++) {
				sb.append(Integer.toString(output[i]));
				
				if(i != output.length-1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0 ; i < arr.length ; i ++) {
			output[d] = i+1;
			p(s+1,d +1,r);
		}
	}
}
