package class3;

import java.io.*;
import java.util.*;

public class Boj1463 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("./res/input1463.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		while (N > 6) {
			int n = N % 6;
			if (n == 0 || n == 3) {
				N /= 3;
			} else if (n == 1 || n == 5) {
				N--;
			} else {
				N /= 2;
			}
			cnt++;
		}

		if (N == 2 || N == 3) {
			cnt++;
		} else if (N == 4 || N == 6) {
			cnt += 2;
		} else if (N == 5) {
			cnt += 3;
		}
		System.out.println(cnt);
	}
}
