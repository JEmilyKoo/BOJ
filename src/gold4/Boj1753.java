package gold4;

import java.io.*;
import java.util.*;

public class Boj1753 {
    // Node Ŭ����: �� ������ �ش� ����ġ(�Ÿ�)�� ��Ÿ���ϴ�.
    static class Node implements Comparable<Node> {
        int vertex, weight;

        // ������: ������ ����ġ�� �ʱ�ȭ
        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        // compareTo �޼���: �켱���� ť���� ����ġ �������� �����ϵ��� ����
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight; // ����ġ(�Ÿ�) ������������ ����
        }
    }

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

        // �׷����� ������ ���� ����Ʈ �ʱ�ȭ
        List<Node>[] link = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            link[i] = new ArrayList<>();
        }

        // ��� ���� ������ �о ���� ����Ʈ�� ����
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // ���� ���� u
            int v = Integer.parseInt(st.nextToken()); // ���� ���� v
            int w = Integer.parseInt(st.nextToken()); // ������ ����ġ w
            link[u].add(new Node(v, w)); // ���� ����Ʈ�� ���� �߰�
        }

        // �Ÿ� �迭�� ���Ѵ�� �ʱ�ȭ
        int[] dp = new int[V+1];
        Arrays.fill(dp, INF);

        // �켱���� ť�� ����� ���ͽ�Ʈ�� �˰��� ����
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(k, 0)); // ���� ���� k���� ���

        // ���ͽ�Ʈ�� �˰������� �ִ� ��θ� ã��
        while (!que.isEmpty()) {
            Node u = que.poll(); // ���� ª�� �Ÿ��� ������ �����ϴ�.
            for (Node v : link[u.vertex]) {
                int sum = u.weight + v.weight; // ���ο� �Ÿ� ���
                if (dp[v.vertex] > sum) { // �� ª�� ��θ� �߰��ϸ�
                    dp[v.vertex] = sum; // �Ÿ� ����
                    que.offer(new Node(v.vertex, sum)); // ���ŵ� ������ ť�� �߰�
                }
            }
        }

        // ���������� �ִ� ��θ� ����մϴ�.
        for (int i = 1; i <= V; i++) {
            if (i == k) {
                sb.append(0 + "\n"); // �ڱ� �ڽ������� �Ÿ��� 0
            } else if (dp[i] == INF) {
                sb.append("INF\n"); // ��ΰ� �������� ������ "INF" ���
            } else {
                sb.append(dp[i] + "\n"); // �� �ܿ��� �ִ� �Ÿ� ���
            }
        }

        br.close();
        System.out.println(sb);
    }
}