package 이공이삼삼월.d230308;
//BFS
import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
	    static int[] dr = {-1,0,0,1};
	    static int[] dc = {0,-1,1,0};
	    static int n, m;
	    static boolean[][] visited;
	    
	    static class Node{
	        int x;
	        int y;
	        int move; // 거리 뱉어야함
	        
	        public Node(int x, int y, int move){
	            this.x = x;
	            this.y = y;
	            this.move = move;
	        }
	    }
	    
	    public int solution(int[][] maps) {
	        n = maps.length;
	        m = maps[0].length;
	        visited = new boolean[n][m];
	        
	        return BFS(0, 0, maps);
	    }
	    
	    int BFS(int r, int c, int[][] maps){
	        Queue<Node> q = new LinkedList<>();
	        q.offer(new Node(r,c,1));
	        visited[r][c] = true;
	        
	        while(!q.isEmpty()){
	            Node node = q.poll();
	            if(node.x == n-1 && node.y == m-1){
	                return node.move;
	            }
	            
	            for(int i=0; i<4; i++){
	                int nr = node.x + dr[i];
	                int nc = node.y + dc[i];
	                
	                if(nr>=0 && nc>=0 && nr<n && nc<m){
	                    if(maps[nr][nc] == 1 && !visited[nr][nc]){
	                        visited[nr][nc] = true;
	                        q.offer(new Node(nr, nc, node.move+1));
	                    }
	                }
	            }
	        }
	        return -1;
	    }
	
}
