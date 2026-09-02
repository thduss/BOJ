import java.util.*;

class Solution {
    public class Node implements Comparable<Node> {
        int x, y;
        String str;
        
        Node(int x, int y, String str){
            this.x = x;
            this.y = y;
            this.str = str;
        }
        
        @Override
        public int compareTo(Node o){
            return this.str.compareTo(o.str);
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        String[] cmd = {"l", "r", "u", "d"};

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, y, ""));
        boolean[][][] visited = new boolean[n+1][m+1][k+1];
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            visited[cur.x][cur.y][cur.str.length()] = true;
                            
            if(cur.x==r && cur.y==c && cur.str.length()==k){
                answer = cur.str;
                break;
            }
            
            if(cur.str.length()>=k) continue;
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx<=0 || nx>n || ny<=0 || ny>m) continue;
                
                if(visited[nx][ny][cur.str.length()+1]) continue;
                pq.add(new Node(nx, ny, cur.str + cmd[i]));
            }
        }
        
        answer = answer.equals("") ? "impossible" : answer;
        return answer;
    }
}