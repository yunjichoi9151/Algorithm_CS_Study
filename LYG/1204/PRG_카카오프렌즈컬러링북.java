package prg.lv2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PRG_카카오프렌즈컬러링북 {
    public static void main(String[] args) {
        int m = 13;
        int n = 16;
        int[][] picture = {{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
                {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(m, n, picture)));

    }

    static boolean[][] visited;
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int[] dr;
    static int[] dc;

    static int size;

    static public int[] solution(int m, int n, int[][] picture) {
        // 맞았는데 전역변수를 solution 밖에 해주면 틀렸다고 뜸 ;;
        // https://school.programmers.co.kr/questions/12344
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        dr = new int[]{-1, 1, 0, 0};
        dc = new int[]{0, 0, 1, -1};
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    size = 0;
                    dfs(m, n, picture, i, j);
                }
            }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static void dfs(int m, int n, int[][] picture, int r, int c) {
        visited[r][c] = true;
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, ++size);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && picture[nr][nc] == picture[r][c] && !visited[nr][nc]) {
                dfs(m, n, picture, nr, nc);
            }
        }

    }
}
