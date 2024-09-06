package gold4;

import java.io.*;
import java.util.*;

public class Boj1753_2 { //  다익스트라 메인  // 메모리 초과

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

        int[][] g = new int[V][V]; // 그래프를 인접 행렬로 표현
        boolean[] v = new boolean[V]; // 방문 여부를 체크하는 배열
        int[] dist = new int[V]; // 시작점에서 각 정점까지의 최단 거리를 저장하는 배열

        // 최단 거리 배열 초기화: 무한대로 설정
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 그래프 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int uu = Integer.parseInt(st.nextToken()); // 시작 정점 uu
            int vv = Integer.parseInt(st.nextToken()); // 도착 정점 vv
            int ww = Integer.parseInt(st.nextToken()); // 간선의 가중치 ww
            g[uu-1][vv-1] = ww;
        }
        // 시작 정점은 0번 정점, 자기 자신까지의 거리는 0으로 설정
        dist[k-1] = 0;

        // 다익스트라 알고리즘 수행
        for (int i = 0; i < V; i++) {
            // 현재 방문하지 않은 정점 중에서 가장 가까운 정점을 찾음
            int minVertex = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < V; j++) {
                if (!v[j] && min> dist[j]) {
                				minVertex = j;
			                    min = dist[j];
                }
            }

            // 모든 정점을 방문했거나, 더 이상 연결된 정점이 없을 경우 종료
            if (minVertex == -1) break;

            // 선택된 정점을 방문 처리
            v[minVertex] = true;

            // 선택된 정점에서 다른 정점으로의 최단 거리를 갱신
            for (int j = 0; j < V; j++) {
                if (!v[j] && g[minVertex][j] != 0 && 
                    dist[j] > min + g[minVertex][j]) {
                    dist[j] = min + g[minVertex][j];
                }
            }
        }

        // 각 정점까지의 최단 거리를 출력
        for(int i = 0 ; i < V; i++) {
        	if(dist[i] == INF){
        		sb.append("INF\n");
        		continue;
        	}
        	sb.append(dist[i]).append('\n');
        }
        br.close();
        System.out.println(sb);
    }
}
