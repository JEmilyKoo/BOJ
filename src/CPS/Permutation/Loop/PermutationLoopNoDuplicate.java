package CPS.Permutation.Loop;

import java.io.*;
import java.util.*;

public class PermutationLoopNoDuplicate {
	/*
	 * 순열은 순서를 뽑는 것
	 * 논리버
	 * m이 3 이하일 경우 3중 for문을 돌리는 게 좋음
	 * 중복 X
	 * */
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("./res/inputcps.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 1 ;  i <= N ; i++) {
			for (int j = 1; j <= N ; j++) {
				if(i == j) continue;
				for( int k = 1; k <= N; k++) {
					if(j == k || i == k) continue;
					System.out.println( i+ " " + j + " " + k );
				}
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
