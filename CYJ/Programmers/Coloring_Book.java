import java.util.LinkedList;
import java.util.Queue;

public class Coloring_Book4 {
    // 사방탐색
    static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    // queue : bfs를 위한 큐
    static Queue<int[]> queue = new LinkedList<>();
    // visit : 방문여부 체크
    static boolean[][] visit;
    // size : 해당 영역의 칸 개수
    static int size = 0;
    
    public int[] solution(int m, int n, int[][] picture) {
        // numberOfArea : 영역 개수
        int numberOfArea = 0;
        // maxSizeOfOneArea : 가장 넓은 영역의 size
        int maxSizeOfOneArea = 0;
        // answer : 답 배열
        int[] answer = new int[2];
        // visit 초기화
        visit = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // 색칠되어 있고, 방문하지 않았다면
                if(picture[i][j] > 0 && !visit[i][j]) {
                    // size 1로 초기화
                    size = 1;
                    // bfs
                    bfs(picture, i, j, m, n);
                    // 영역 개수 +1
                    numberOfArea++;
                    // 현재 영역의 size가 maxSizeOfOneArea보다 크다면 갱신
                    if(maxSizeOfOneArea < size) {
                        maxSizeOfOneArea = size;
                    }
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    
    public static void bfs(int[][] map, int x, int y, int m, int n) {
        // 큐에 추가
        queue.add(new int[]{x, y});
        // 방문여부 true로 바꿈
        visit[x][y] = true;
        while(!queue.isEmpty()) {
            // tmp : 큐 poll
            int[] tmp = queue.poll();
            for(int i = 0; i < 4; i++) {
                // nr, nc : tmp 좌표에서 사방탐색
                int nr = tmp[0] + dir[i][0];
                int nc = tmp[1] + dir[i][1];
                // 범위 벗어나면 continue
                if(nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                // 같은 색깔이고, 방문여부가 false라면
                if(map[nr][nc] == map[x][y] && !visit[nr][nc]) {
                    // 큐에 새롭게 추가
                    queue.add(new int[]{nr, nc});
                    // 방문여부 true로 바꿈
                    visit[nr][nc] = true;
                    // size +1
                    size++;
                }
            }
        }
    }
}
