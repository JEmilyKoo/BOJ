package CPS.Combination.BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CombinationBackTrackingNoDuplicate {
	/*
	 * 조합을 뽑는 것 
	 * 백 트래킹을 사용 
	 * 요소 중복 X
	 */
	static int[] arr;
	static int[] output;
	static int  count;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("./res/inputcps.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		System.out.println("N : " + N + " M : " + M);
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		output = new int[M];
		c3(0, 0, M);

		System.out.println("count" + count);
		br.close();
		bw.flush();
		bw.close();
	}

	static void c3(int start, int d, int r) {
		if (d == r) {
			for (int i = 0; i < output.length; i++) {
				count++;
				System.out.print(output[i] + " ");
			}
			
			System.out.println();
			return;
		}

		for (int i = start; i < arr.length; i++) {
			output[d] = arr[i];
			c3(i + 1, d + 1, r);
		}
	}
}
