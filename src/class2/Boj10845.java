package class2;

import java.io.*;
import java.util.*;

public class Boj10845 {	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("./res/input10845.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new ArrayDeque<Integer>();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine().trim());
		int line;
		for( int i = 0 ; i < N; i++ ) {
			line = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine().trim(), " ");
			switch (st.nextToken()) {
			case "push":
				deque.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				line = deque.isEmpty()? -1 : deque.pollLast();
				break;
			case "size":
				line = deque.size();
				break;
			case "empty":
				line = deque.isEmpty()? 1 : 0;
				break;
			case "front":
				line = deque.isEmpty()? -1 : deque.peekLast();
				break;
			default:
				line = deque.isEmpty()? -1 : deque.peekFirst();
				break;
			}
			if(line != Integer.MAX_VALUE) {
				sb.append(Integer.toString(line)).append("\n");
			}
		}		
		
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
