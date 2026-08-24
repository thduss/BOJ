import java.util.*;

class Solution {
    public class Node{
        int x, y, type;
        
        public Node(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    List<List<Node>> graph;
    List<List<Node>> type;
    int maxCnt = 0;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        int answer = 0;

        graph = new ArrayList<>();
        type = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
            type.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(new Node(edge[0], edge[1], edge[2]));
            graph.get(edge[1]).add(new Node(edge[1], edge[0], edge[2]));
            
            type.get(edge[2]).add(new Node(edge[0], edge[1]));
        }
        
        boolean[] infect = new boolean[n+1];
        infect[infection] = true;
        
        dfs(infect, k, 1, n);
        answer = maxCnt;
        
        return answer;
    }
    
    public void dfs(boolean[] infect, int k, int cnt, int n){
        maxCnt = Math.max(maxCnt, cnt);
        if(k==0){
            return;
        }
        
        for(int i=0; i<=n; i++){
            List<Node> t = type.get(i);
            
            if(t.size()<=0) continue;
            
            int c = 0;
            List<Integer> check = new ArrayList<>();
            boolean change = true;
            while(change){
                change = false;
                for(Node nxt : t){
                    if(infect[nxt.x] || infect[nxt.y]){
                        if(infect[nxt.x] && infect[nxt.y]) continue;

                        if(!infect[nxt.x]) {
                            check.add(nxt.x);
                            infect[nxt.x] = true;
                            change = true;
                        }

                        if(!infect[nxt.y]){
                            check.add(nxt.y);
                            infect[nxt.y] = true;
                            change = true;
                        } 

                        c++;
                    }
                }
            }
            
            
            if(c!=0) dfs(infect, k-1, cnt+c, n);
            
            for(int ch : check){
                infect[ch] = false;
            }
        }
    }
}