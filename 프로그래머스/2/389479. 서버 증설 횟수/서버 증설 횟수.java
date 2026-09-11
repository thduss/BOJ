import java.util.*;

class Solution {
    public class Node implements Comparable<Node> {
        int finishTime, cnt;
        
        public Node(int f, int cnt){
            finishTime = f;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Node o){
            return this.finishTime - o.finishTime;
        }
    }
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        PriorityQueue<Node> finServer = new PriorityQueue<>(); // 끝나는 시각 저장
        int server = 0; // k시간 유지
        
        for(int t=0; t<players.length; t++){
            int need = players[t] / m;
            
            while(!finServer.isEmpty() && finServer.peek().finishTime<=t){
                Node cur = finServer.poll();
                server -= cur.cnt;
            }
            
            if(server<need){
                int add = need - server;
                server = need;
                answer += add;
                
                finServer.add(new Node(t+k, add));
            }
        }
        
        return answer;
    }
}