package class3;

import java.io.*;
import java.util.*;

public class Boj2606 {
	static int[] cnt;
	static int[] parents;
	static int N;
	static void makeSet() {
		parents = new int[N+1];
		cnt = new int[N+1];
		
		for(int i = 1; i <= N;i++) {
			parents[i] = i;
			cnt[i] = 1;
		}
	}
	
	static int findSet(int a) {
		if(a == parents[a]) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}
	static void unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return;
		if(aRoot < bRoot) {
			parents[bRoot] = aRoot;
			cnt[aRoot]+=cnt[bRoot];
		}else {
			parents[aRoot] = bRoot;
			cnt[bRoot]+=cnt[aRoot];
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("./res/input2606.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		makeSet();
		for(int i = 0 ; i  < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			unionSet(n1, n2);
		}
		System.out.println(cnt[1]-1);
	}
}
