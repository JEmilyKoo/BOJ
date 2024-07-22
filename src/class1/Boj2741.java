package class1;

import java.io.*;
import java.util.*;

public class Boj2741 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1 ; i <= N ; i++) {
			sb.append(i).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
