package d221204;
//상하좌우 연결된 동일색상 영역 체크, 0은 색칠 안함

public class 카카오프렌즈_컬러링북 {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        //프로그래머스에서 제시된 picture배열 손보면 에러남
        boolean[][] visited = new boolean[m][n];
        
        //방문한적 없을 때 계속해서 탐색하며 체크
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && picture[i][j] != 0) {
                    int cnt = DFS(i, j, picture, visited);
                    //한 영역의 크기 최대치로 갱신
                    if(maxSizeOfOneArea < cnt){
                        maxSizeOfOneArea = cnt;
                    }
                    //영역 갯수 세기
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    //DFS
    private int DFS(int x, int y, int[][] picture, boolean[][] visited) {
        visited[x][y] = true;
        int cnt = 1; //영역 무조건 1개 이상
        //사방탐색
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx >= 0 && nx < picture.length && ny >= 0 && ny < picture[0].length){
                if(visited[nx][ny])
                    continue;
                if(picture[nx][ny] == picture[x][y])
                    cnt += DFS(nx,ny,picture,visited);
            }
        }
        return cnt;
    }
}
