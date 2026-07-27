import java.util.*;

// 크루스칼 알고리즘 사용해서 MST 찾기
class Solution {
    public static int[] parent;
    
    // 부모 찾기
    public int find(int a){
        if(parent[a]==a) return a;
        
        return parent[a] = find(parent[a]);
    }
    
     // a와 b 같은 그룹?
    public boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false; // 사이클 발생
        
        if(aRoot>bRoot) parent[bRoot] = aRoot;
        else parent[aRoot] = bRoot;
        
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        // cost 기준으로 오름차순 정렬
        Arrays.sort(costs, (a,b) -> Integer.compare(a[2], b[2]));
        
        for(int[] e : costs){
            int a = e[0];
            int b = e[1];
            int w = e[2];
            
            if(union(a,b)){
                answer+=w;
            }
        }
        
        return answer;
    }
}