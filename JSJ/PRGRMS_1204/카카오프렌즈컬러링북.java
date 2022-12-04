package PRGRMS_1204;

import java.util.LinkedList;
import java.util.Queue;

// 컬러링북 난이도 -> 영역이 많을수록 높음
// 영역 : 상하좌우로 연결된 색상이 같은 공간
// 영역의 개수, 가장 큰 영역의 넓이를 계산하시오
// 0 : 색칠 x

// 풀이
// 1. 같은 영역 찾기 -> 방문 영역 체크
// 2. 해당 색 영역 최대값 구하기

public class 카카오프렌즈컬러링북 {

	static int areaCnt, maxArea, cnt = 0;
	static boolean[][] visited;
	static int[][] drc = { { -1, 1, 0, 0 }, { 0, 0, -1, 1 } };

	public int[] solution(int m, int n, int[][] picture) {
		int[] answer = new int[2];

		areaCnt = 0;
		maxArea = 0;
		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0 && !visited[i][j]) {
					areaCnt++; // 영역 개수 갱신
					dfs(m, n, i, j, picture);
//					bfs(m, n, i, j, picture);
				}

				maxArea = Math.max(maxArea, cnt); // 최대값 갱신
				cnt = 0; // 영역당 cnt 초기화
			}
		}

		answer[0] = areaCnt;
		answer[1] = maxArea;

		return answer;
	}

	// dfs
	public static void dfs(int m, int n, int x, int y, int[][] picture) {

		if (visited[x][y])
			return;

		visited[x][y] = true;
		cnt++;

		for (int d = 0; d < 4; d++) {
			int cx = x + drc[0][d];
			int cy = y + drc[1][d];

			if (cx >= 0 && cx < m && cy >= 0 && cy < n && picture[x][y] == picture[cx][cy] && !visited[cx][cy]) {
				dfs(m, n, cx, cy, picture);
			}
		}
	}

	// bfs
	public static void bfs(int m, int n, int x, int y, int[][] picture) {
		Queue<int[]> q = new LinkedList<>();
		visited[x][y] = true;
		q.add(new int[] { x, y });

		cnt++;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			for (int d = 0; d < 4; d++) {
				int cx = tmp[0] + drc[0][d];
				int cy = tmp[1] + drc[1][d];

				if (cx >= 0 && cx < m && cy >= 0 && cy < n && picture[tmp[0]][tmp[1]] == picture[cx][cy]
						&& !visited[cx][cy]) {
					cnt++;
					visited[cx][cy] = true;
					q.add(new int[] { cx, cy });
				}
			}
		}
	}
}