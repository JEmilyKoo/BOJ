package gold5;

import java.io.*;
import java.util.*;

public class Boj14503 {

	public static void main(String[] args) throws Exception {
		// �Է� ������ ���� (���� ȯ�濡�� �׽�Ʈ�� ���� ���)
		System.setIn(new FileInputStream(new File("./res/input14503.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ù ��° �ٿ��� ���� ũ�� (N x M) �Է� �ޱ�
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		// �� ��° �ٿ��� �κ� û�ұ��� �ʱ� ��ġ (r, c) �� ���� (d) �Է� �ޱ�
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		// ���� ���¸� �Է� �޾Ƽ� 2���� �迭�� ����
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// û���� ĭ�� ���� ����� ����
		int clean = 0, lr, lc, ld;
		boolean isClean = true;

		// ��(0), ��(1), ��(2), ��(3) ���⿡ ���� ��� ���� �̵� ��ȭ��
		int[] dr = {-1, 0, 1, 0}; // ��, ��, ��, ��
		int[] dc = {0, 1, 0, -1};

		while (true) {
			// ���� ��ġ�� û�ҵ��� ���� ĭ�̶�� û�� ����
			if (map[r][c] == 0) {
				map[r][c] = 2; // û�ҵ� ĭ�� 2�� ǥ��
				clean++;
			}

			// ���� ��ġ �ֺ� 4ĭ�� Ȯ���Ͽ� û�ҵ��� ���� ĭ�� �ִ��� Ȯ��
			isClean = true;
			for (int i = 0; i < 4; i++) {
				lr = r + dr[i];
				lc = c + dc[i];

				// ��ȿ�� ���� ������ û�ҵ��� ���� ĭ�� �߰��ϸ� isClean�� false�� ����
				if (0 <= lr && lr < N && 0 <= lc && lc < M && map[lr][lc] == 0) {
					isClean = false;
					break;
				}
			}

			// ���� ������ �������� ����(�ݽð� 90��) �Ǵ� ����(�ݴ� ����)���� ���� ��ȯ
			ld = (d + (isClean ? 2 : 3)) % 4;
			lr = r + dr[ld];
			lc = c + dc[ld];

			// ���� ������ �Ұ����ϰų� ���� �ε����� �ݺ� ����
			if (!(0 <= lr && lr < N && 0 <= lc && lc < M)) continue;
			if (isClean && map[lr][lc] == 1) break;
			// û�ҵ��� ���� ĭ�� �ְų� ������ �����ϸ� �̵�
			if (isClean || map[lr][lc] == 0) {
				r = lr;
				c = lc;
			}
			// û�ҵ��� ���� ĭ�� �ִٸ� �������� ȸ��
			if (!isClean) {
				d = ld;
			}
		}
		// û���� ĭ�� ���� ���
		System.out.println(clean);
	}
}
