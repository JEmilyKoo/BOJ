package class1;

import java.io.*;
import java.util.*;

public class Boj2739 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1 ; i < 10 ; i++) {
			sb.append(N).append(" * ").append(i).append(" = ").append(i*N).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
