import java.util.*;

class Solution {
    int[] root;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        root = new int[n];
        for(int i=0; i<n; i++) root[i] = i;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                
                if(computers[i][j]==1){
                    union(i, j);
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            if(i == root[i]) answer++;
        }
        
        return answer;
    }
    
    public void union(int a, int b){
        int x = find(a);
        int y = find(b);
        
        if(x!=y) root[x] = y;
    }
    
    public int find(int x){
        if(root[x]==x) return x;
        
        return root[x] = find(root[x]);
    }
}