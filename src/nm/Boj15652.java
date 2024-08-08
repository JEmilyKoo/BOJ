package nm;

import java.io.*;
import java.util.StringTokenizer;

public class Boj15652 {

	static int[] arr;
	static int[] output;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("./res/inputcps.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();

		arr = new int[N];
		output = new int[M];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		c(0, 0, M);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();

	}

	static void c(int s, int d, int r) {
		if (d == r) {
			for (int i = 0; i < output.length; i++) {
				sb.append(Integer.toString(output[i]));

				if (i != output.length - 1) {
					sb.append(" ");
				}

			}
			sb.append("\n");
			return;
		}

		for (int i = s; i < arr.length; i++) {
			output[d] = arr[i];
			c(i, d + 1, r);
		}
	}

}
