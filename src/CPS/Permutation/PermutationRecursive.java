package CPS.Permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PermutationRecursive {
	/*
	 * 순열을 뽑는 것
	 * 논리버
	 * m이 클 경우 재귀를 사용하는 게 좋음
	 * 중복 O
	 * */
	static int[] arr;
	static int[] output;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("./res/inputcps.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int [N];
		output = new int [M];
		
		pr(0, M);
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	static void pr (int d, int r) {
		if(d == r) {
			for(int i = 0; i < output.length; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0 ; i < arr.length; i++) {
			output[d] = i + 1;
			pr(d+1, r);
		}
	}
}