import java.util.*;

class Solution {
    public class Node implements Comparable<Node>{
        int x, y, cost, dir;
        
        Node(int x, int y, int cost, int dir){
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
        
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        
        int N = board.length;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        
        // 직선도로 100, 코너 500
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<4; i++) pq.add(new Node(0,0,0,i));
        int[][][] dist = new int[N][N][4];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.x==N-1 && cur.y==N-1){
                answer = cur.cost;
                break;
            }
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                if(board[nx][ny]==1) continue;
                
                int cost = cur.dir==i ? 100 : 600;
                if(dist[nx][ny][i]>cur.cost+cost){
                    dist[nx][ny][i] = cur.cost+cost;
                    pq.add(new Node(nx, ny, cur.cost+cost, i));
                }
            }
        }
        
        return answer;
    }
}