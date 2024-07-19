package class1;

import java.io.*;
import java.util.*;

public class Boj10950 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int a;
		int b;

		for (int tc = 1; tc < T + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			sb.append(Integer.toString(a + b)).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
