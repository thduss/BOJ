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

        int shortestPath = Math.abs(r-x) + Math.abs(c-y);
        if (shortestPath > k || (k - shortestPath) % 2 != 0) {
            return "impossible";
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, y, new StringBuilder()));
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        String[] cmd = {"d", "u", "r", "l"};
        boolean[][][] visited = new boolean[n + 1][m + 1][k + 1];
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int len = cur.sb.length();
            
            if((cur.x == r) && (cur.y == c) && (cur.sb.length()==k)){
                answer = cur.sb.toString();
                break;
            }
            if(visited[cur.x][cur.y][len]) continue;
            visited[cur.x][cur.y][len] = true;
        
            if(len>=k) continue;
            
            for(int i=0; i<4; i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                
                if(nx<1 || nx>n || ny<1 || ny>m) continue;
                
                StringBuilder nsb = new StringBuilder(cur.sb).append(cmd[i]);
                
                pq.add(new Node(nx, ny, nsb));
            }
        }
        
        return answer;
    }
}