package class3;

import java.io.*;
import java.util.*;

public class Boj1003 {
	static int[] fiboArr;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("./res/input1003.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		fiboArr = new int[41];
		fiboArr[1]=1;
		fiboArr[0]=0;
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				sb.append("1 0\n");
				continue;
			} else if (N == 1) {
				sb.append("0 1\n");
				continue;
			}
			fibonacci(N);
			sb.append(fiboArr[N - 1]).append(' ').append(fiboArr[N]).append('\n');
		}
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			if (fiboArr[n] == 0) {
				fiboArr[n] = fibonacci(n - 1) + fibonacci(n - 2);
			}
			return fiboArr[n];
		}
	}
}
