package class1;

import java.io.*;
import java.util.*;

public class Boj1330 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		String answer = a > b ? ">" : a < b ? "<" : "==";
		bw.write(answer);
		bw.flush();
		bw.close();
		br.close();
	}
}
