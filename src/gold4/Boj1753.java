package gold4;

import java.io.*;
import java.util.*;

public class Boj1753 {
    // Node 클래스: 각 정점과 해당 가중치(거리)를 나타냅니다.
    static class Node implements Comparable<Node> {
        int vertex, weight;

        // 생성자: 정점과 가중치를 초기화
        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        // compareTo 메서드: 우선순위 큐에서 가중치 기준으로 정렬하도록 정의
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight; // 가중치(거리) 오름차순으로 정렬
        }
    }

    static int V; // 정점의 개수
    static final int INF = Integer.MAX_VALUE; // 무한대를 나타내는 상수

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream(new File("./res/input1753.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 정점(V)과 간선(E)의 수를 파싱
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        // 시작 정점을 파싱
        int k = Integer.parseInt(br.readLine());

        // 그래프를 저장할 인접 리스트 초기화
        List<Node>[] link = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            link[i] = new ArrayList<>();
        }

        // 모든 간선 정보를 읽어서 인접 리스트에 저장
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작 정점 u
            int v = Integer.parseInt(st.nextToken()); // 도착 정점 v
            int w = Integer.parseInt(st.nextToken()); // 간선의 가중치 w
            link[u].add(new Node(v, w)); // 인접 리스트에 간선 추가
        }

        // 거리 배열을 무한대로 초기화
        int[] dp = new int[V+1];
        Arrays.fill(dp, INF);

        // 우선순위 큐를 사용한 다익스트라 알고리즘 구현
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(k, 0)); // 시작 정점 k에서 출발

        // 다익스트라 알고리즘으로 최단 경로를 찾기
        while (!que.isEmpty()) {
            Node u = que.poll(); // 가장 짧은 거리의 정점을 꺼냅니다.
            for (Node v : link[u.vertex]) {
                int sum = u.weight + v.weight; // 새로운 거리 계산
                if (dp[v.vertex] > sum) { // 더 짧은 경로를 발견하면
                    dp[v.vertex] = sum; // 거리 갱신
                    que.offer(new Node(v.vertex, sum)); // 갱신된 정점을 큐에 추가
                }
            }
        }

        // 최종적으로 최단 경로를 출력합니다.
        for (int i = 1; i <= V; i++) {
            if (i == k) {
                sb.append(0 + "\n"); // 자기 자신으로의 거리는 0
            } else if (dp[i] == INF) {
                sb.append("INF\n"); // 경로가 존재하지 않으면 "INF" 출력
            } else {
                sb.append(dp[i] + "\n"); // 그 외에는 최단 거리 출력
            }
        }

        br.close();
        System.out.println(sb);
    }
}