import java.util.*;

class Solution {
    public int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        
        for(int[] c : costs){
            if(find(c[0])!=find(c[1])){
                union(c[0], c[1]);
                answer += c[2];
            }
        }
        
        return answer;
    }
    
    public void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a!=b) parent[a] = b;
    }
    
    public int find(int a){
        if(parent[a]==a) return a;
        
        return parent[a] = find(parent[a]);
    }
}