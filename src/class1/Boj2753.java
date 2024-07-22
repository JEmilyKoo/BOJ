package class1;

import java.io.*;
import java.util.*;

public class Boj2753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int year = Integer.parseInt(br.readLine());
		
		String answer = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)? "1" : "0";
		
		bw.write(answer);
		br.close();
		bw.flush();
		bw.close();
	}
}
