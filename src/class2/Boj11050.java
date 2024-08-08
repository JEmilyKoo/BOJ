package class2;

import java.io.*;
import java.util.*;

public class Boj11050 {

	static int[] arr;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("./res/input10828.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		arr[0] = 1;
		
		System.out.println(fac(N) / fac(K) / fac(N-K));
	}
	

	static int fac (int n) {
		if( n < 2) {
			return 1;
		}
		
		if(arr[n] == 0) {
			arr[n] = n * fac(n-1);
		}
		return arr[n];
	}
}
