package silver2;

import java.util.*;
import java.io.*;

public class Boj1260 {
	static void dfs(int V, int cnt, int r) {
		v[V] = true;
		sb.append(V).append(' ');
		if(cnt == r) return;
		
		for(int i = 0 ; i< edgeList.get(V).size(); i++) {
			int j = edgeList.get(V).get(i);
			if(v[j]) continue;
			dfs(j, cnt+1, r);
		}
	}
	
	static void bfs(int V) {
		Deque<Integer> deque = new ArrayDeque<>();
		deque.offer(V);
		v[V] = true;
		while(!deque.isEmpty()) {
			int node = deque.poll();
			sb.append(node).append(' ');
			for(int i = 0 ; i< edgeList.get(node).size(); i++) {
				int j = edgeList.get(node).get(i);
				if(v[j]) continue;
				v[j] = true;
				deque.offer(j);
			}
		}
	}

	static int V;	
	static int Limit;
	static List<LinkedList<Integer>> edgeList;
	static boolean[] v;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("./res/input1260.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		Limit = Math.min(N, M);
		edgeList = new ArrayList<LinkedList<Integer>>();
		v = new boolean[N+1];

		for (int i = 1; i <= N+1; i++) {
			edgeList.add(new LinkedList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			edgeList.get(n1).push(n2);
			edgeList.get(n2).push(n1);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(edgeList.get(i));
		}
		
		v[V] = true;
		dfs(V, 0 , Limit);
		sb.append('\n');
		v = new boolean[N+1];
		bfs(V);
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}
