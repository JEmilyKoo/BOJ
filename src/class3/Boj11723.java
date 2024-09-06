package class3;

import java.io.*;
import java.util.*;

public class Boj11723 {

	static void add(int a) {
		arr[a] = true;
	}

	static void remove(int a) {
		arr[a] = false;
	}

	static int check(int a) {
		return arr[a]? 1: 0;
	}

	static void toggle(int a) {
		if(check(a)==1) {
			remove(a);
		}else {
			add(a);
		}
	}

	static void all() {
		for(int i = 1; i < 21 ; i++) {
			arr[i] = true;
		}
	}
	static void empty() {
		arr = new boolean[21];
	}

	static boolean[] arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("./res/input11723.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		empty();
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			if (command.equals("all")) {
				all();
				continue;
			} else if (command.equals("empty")) {
				empty();
				continue;
			}

			int num = Integer.parseInt(st.nextToken());

			if (command.equals("add")) {
				add(num);
			} else if (command.equals("remove")) {
				remove(num);
			} else if (command.equals("check")) {
				sb.append(check(num)).append('\n');
			} else if (command.equals("toggle")) {
				toggle(num);
			}
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
