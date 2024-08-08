package CPS.Permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PermutationRecursiveNoDuplicate {
	/*
	 * 순열을 뽑는 것
	 * 논리버
	 * m이 클 경우 재귀를 사용하는 게 좋음
	 * 중복 X
	 * */
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("./res/inputcps.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int [N];
		output = new int [N];
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	static void c () {
		
	}
}