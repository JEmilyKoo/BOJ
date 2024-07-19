package class1;

import java.io.*;
import java.util.*;

public class Boj2475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int sum =0;
		while (st.hasMoreTokens()) {
			sum += Math.pow(Integer.parseInt(st.nextToken()), 2);
		}
		bw.append(Integer.toString(sum%10));
		bw.flush();bw.close();br.close();
	}
}