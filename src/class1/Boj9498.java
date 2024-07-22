package class1;

import java.io.*;
import java.util.*;

public class Boj9498 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int score = Integer.parseInt(br.readLine()) / 10;
		char result;
		switch (score) {
		case 10:
		case 9:
			result = 'A';
			break;
		case 8:
			result = 'B';
			break;
		case 7:
			result = 'C';
			break;
		case 6:
			result = 'D';
			break;
		default:
			result = 'F';
			
		}
		bw.write(result);
		br.close();
		bw.flush();
		bw.close();
	}
}
