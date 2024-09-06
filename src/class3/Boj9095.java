package class3;

import java.io.*;
import java.util.*;

public class Boj9095 {
	static int cnt;
	static void subs(int r, int sum) {
		if(sum > r) return;
		if(sum == r) {
			cnt++;
			return;
		}
		
		subs(r, sum+1);
		subs(r, sum+2);
		subs(r, sum+3);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("./res/input9095.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			cnt = 0;
			subs(Integer.parseInt(br.readLine()), 0);
			sb.append(cnt).append('\n');
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
