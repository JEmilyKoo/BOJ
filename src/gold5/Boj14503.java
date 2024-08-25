package gold5;

import java.io.*;
import java.util.*;

public class Boj14503 {

	public static void main(String[] args) throws Exception {
		// 입력 파일을 설정 (로컬 환경에서 테스트를 위해 사용)
		System.setIn(new FileInputStream(new File("./res/input14503.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 첫 번째 줄에서 방의 크기 (N x M) 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		// 두 번째 줄에서 로봇 청소기의 초기 위치 (r, c) 및 방향 (d) 입력 받기
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		// 방의 상태를 입력 받아서 2차원 배열에 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 청소한 칸의 수를 기록할 변수
		int clean = 0, lr, lc, ld;
		boolean isClean = true;

		// 북(0), 동(1), 남(2), 서(3) 방향에 따른 행과 열의 이동 변화량
		int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
		int[] dc = {0, 1, 0, -1};

		while (true) {
			// 현재 위치가 청소되지 않은 칸이라면 청소 수행
			if (map[r][c] == 0) {
				map[r][c] = 2; // 청소된 칸을 2로 표시
				clean++;
			}

			// 현재 위치 주변 4칸을 확인하여 청소되지 않은 칸이 있는지 확인
			isClean = true;
			for (int i = 0; i < 4; i++) {
				lr = r + dr[i];
				lc = c + dc[i];

				// 유효한 범위 내에서 청소되지 않은 칸을 발견하면 isClean을 false로 설정
				if (0 <= lr && lr < N && 0 <= lc && lc < M && map[lr][lc] == 0) {
					isClean = false;
					break;
				}
			}

			// 현재 방향을 기준으로 왼쪽(반시계 90도) 또는 후진(반대 방향)으로 방향 전환
			ld = (d + (isClean ? 2 : 3)) % 4;
			lr = r + dr[ld];
			lc = c + dc[ld];

			// 만약 후진이 불가능하거나 벽에 부딪히면 반복 종료
			if (!(0 <= lr && lr < N && 0 <= lc && lc < M)) continue;
			if (isClean && map[lr][lc] == 1) break;
			// 청소되지 않은 칸이 있거나 후진이 가능하면 이동
			if (isClean || map[lr][lc] == 0) {
				r = lr;
				c = lc;
			}
			// 청소되지 않은 칸이 있다면 왼쪽으로 회전
			if (!isClean) {
				d = ld;
			}
		}
		// 청소한 칸의 수를 출력
		System.out.println(clean);
	}
}
