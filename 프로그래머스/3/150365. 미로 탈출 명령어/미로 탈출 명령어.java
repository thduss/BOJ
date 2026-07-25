import java.util.*;

class Solution {
    public static class Node implements Comparable<Node> {
        int x, y;
        StringBuilder sb;
        
        public Node(int x, int y, StringBuilder sb){
            this.x = x;
            this.y = y;
            this.sb = sb;
        }
        
        @Override
        public int compareTo(Node o){
            return this.sb.toString().compareTo(o.sb.toString());
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "impossible";

        int minDist = Math.abs(x-r) + Math.abs(y-c);
        if(minDist>k || (k-minDist)%2!=0) {
            return "impossible";
        }
        
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        String[] cmd = {"l", "r", "u", "d"};
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x,y,new StringBuilder()));
        boolean[][][] visited = new boolean[n+1][m+1][k+1];
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int len = cur.sb.length();
            visited[cur.x][cur.y][len] = true;
            
            if(len==k && cur.x==r && cur.y==c){
                answer = cur.sb.toString();
                break;
            }
            
            if(len>=k) continue;
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx<=0 || nx>n || ny<=0 || ny>m){
                    continue;
                }
                
                if(visited[nx][ny][len+1]) continue;
                
                StringBuilder sb = new StringBuilder(cur.sb).append(cmd[i]);
                
                pq.add(new Node(nx, ny, sb));
            }
            
        }
        
        return answer;
    }
    
    
}