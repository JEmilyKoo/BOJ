package CPS.Combination.Loop;

import java.io.*;
import java.util.*;

public class CombinationLoop {
	/*
	 * 조합을 뽑는 것
	 * 리버
	 * m이 3 이하일 경우 3중 for문을 돌리는 게 좋음
	 * 중복  O
	 * */
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("./res/inputcps.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		
		for (int i = 1 ;  i <= N ; i++) {
			for (int j = i ; j <= N ; j++) {
				for( int k =  j ; k <= N; k++) {
					count++;
					System.out.println( i+ " " + j + " " + k );
				}
			}
		}

		System.out.println("count" + count);
		br.close();
		bw.flush();
		bw.close();
	}
}
