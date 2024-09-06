package gold4;

import java.io.*;
import java.util.*;

public class Boj1753_2 { //  ���ͽ�Ʈ�� ����  // �޸� �ʰ�

    static int V; // ������ ����
    static final int INF = Integer.MAX_VALUE; // ���Ѵ븦 ��Ÿ���� ���
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream(new File("./res/input1753.txt")));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();

        // ����(V)�� ����(E)�� ���� �Ľ�
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // ���� ������ �Ľ�
        int k = Integer.parseInt(br.readLine());

        int[][] g = new int[V][V]; // �׷����� ���� ��ķ� ǥ��
        boolean[] v = new boolean[V]; // �湮 ���θ� üũ�ϴ� �迭
        int[] dist = new int[V]; // ���������� �� ���������� �ִ� �Ÿ��� �����ϴ� �迭

        // �ִ� �Ÿ� �迭 �ʱ�ȭ: ���Ѵ�� ����
        Arrays.fill(dist, Integer.MAX_VALUE);

        // �׷��� �Է�
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int uu = Integer.parseInt(st.nextToken()); // ���� ���� uu
            int vv = Integer.parseInt(st.nextToken()); // ���� ���� vv
            int ww = Integer.parseInt(st.nextToken()); // ������ ����ġ ww
            g[uu-1][vv-1] = ww;
        }
        // ���� ������ 0�� ����, �ڱ� �ڽű����� �Ÿ��� 0���� ����
        dist[k-1] = 0;

        // ���ͽ�Ʈ�� �˰��� ����
        for (int i = 0; i < V; i++) {
            // ���� �湮���� ���� ���� �߿��� ���� ����� ������ ã��
            int minVertex = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < V; j++) {
                if (!v[j] && min> dist[j]) {
                				minVertex = j;
			                    min = dist[j];
                }
            }

            // ��� ������ �湮�߰ų�, �� �̻� ����� ������ ���� ��� ����
            if (minVertex == -1) break;

            // ���õ� ������ �湮 ó��
            v[minVertex] = true;

            // ���õ� �������� �ٸ� ���������� �ִ� �Ÿ��� ����
            for (int j = 0; j < V; j++) {
                if (!v[j] && g[minVertex][j] != 0 && 
                    dist[j] > min + g[minVertex][j]) {
                    dist[j] = min + g[minVertex][j];
                }
            }
        }

        // �� ���������� �ִ� �Ÿ��� ���
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
