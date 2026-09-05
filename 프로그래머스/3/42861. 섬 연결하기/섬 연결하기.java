import java.util.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;

        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        answer = kruskal(costs);
        
        return answer;
    }
    
    public void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x!=y) parent[x] = y; 
    }
    
    public int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public int kruskal(int[][] costs){
        Arrays.sort(costs, (a,b) -> a[2]-b[2]);
        int answer=0;
        
        for(int[] e : costs){
            int u = e[0];
            int v = e[1];
            int c = e[2];
            
            if(find(u)!=find(v)) {
                union(u,v);
                answer += c;
            }
        }
        
        return answer;
    }
}