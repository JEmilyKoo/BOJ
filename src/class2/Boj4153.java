package class2;

import java.io.*;
import java.util.*;

public class Boj4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringBuilder sb  = new StringBuilder();
		StringTokenizer st;
		List<Integer> list;
		boolean finish = false;
		while(!finish) {
			String line = br.readLine();
			st = new StringTokenizer(line, " ");
			list = new ArrayList<>();
			
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			if(list.get(0) == 0 && list.get(1) == 0 &&  list.get(2) == 0) {
				break;
			}
			Collections.sort(list, (o1, o2) -> Integer.compare(o1, o2));
			
			if(Math.pow(list.get(0), 2) + Math.pow(list.get(1), 2) == Math.pow(list.get(2), 2)) {
				sb.append("right");
			}else {
				sb.append("wrong");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
