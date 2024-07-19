package Bronz4;

import java.io.*;

public class Boj28244 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Integer.parseInt(br.readLine());
		}
		br.close();
		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();
	}
}
