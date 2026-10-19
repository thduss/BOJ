import java.util.*;

class Solution {
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    
    public class Node implements Comparable<Node> {
        int x, y, cnt;
        
        Node(int x, int y, int cnt){
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }
        
        @Override
        public int compareTo(Node o){
            return this.cnt - o.cnt;
        }
    }
    
    public int solution(String[] board) {
        int answer = -1;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        int N = board.length;
        int M = board[0].length();
        boolean[][] visited = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i].charAt(j)=='R'){
                    visited[i][j] = true;
                    pq.add(new Node(i,j,0));
                    break;
                }
            }
        }
        
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            visited[cur.x][cur.y] = true;
            
            if(board[cur.x].charAt(cur.y)=='G'){
                return cur.cnt;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur.x;
                int ny = cur.y;
                int cnt = 0;
                
                while(nx>=0 && ny>=0 && nx<N && ny<M && board[nx].charAt(ny)!='D'){
                    nx += dx[i];
                    ny += dy[i];
                }
                
                nx -= dx[i];
                ny -= dy[i];
                
                if(!visited[nx][ny]) pq.add(new Node(nx, ny, cur.cnt+1));
            }
        }
        
        
        return answer;
    }
}