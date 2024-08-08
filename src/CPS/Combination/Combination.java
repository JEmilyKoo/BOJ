package CPS.Combination;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Combination {
	/*
	 * 조합을 뽑는 것
	 * m이 클 경우 재귀를 사용하는 게 좋음
	 * 중복 X
	 * */
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	static int  count;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("./res/inputcps.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		System.out.println("N : " + N + " M : " + M);
		arr = new int [N];
		output = new int [M];
		count = 0;
		visited = new boolean [N];
		c1(0, 0, M);
		System.out.println("count" + count);
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void c1 (int start, int d, int r) {
		if(d == r) {
			for(int i = 0 ; i < output.length; i ++ ) {
				count++;
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start ; i < arr.length ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[d] = i+1;
				c1(i+1, d+1, r);
				visited[i] = false;
			}
		}
	}
}
