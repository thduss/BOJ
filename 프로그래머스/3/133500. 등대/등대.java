import java.util.*;

class Solution {
    public List<List<Integer>> graph;
    public int cnt;
    
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;

        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int[] edge : lighthouse){
            int u = edge[0];
            int v = edge[1];
        
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // 켜 두어야 하는 등대 개수 최솟값
        dfs(1, 0);
        answer = cnt;
        
        return answer;
    }
    
    public int dfs(int node, int parent){
        if(graph.get(node).size()==1 && graph.get(node).get(0)==parent){
            // 리프노드
            return 1;
        }
        
        int next_cnt=0;
        
        for(int next : graph.get(node)){
            if(next==parent){
                continue;
            }
            next_cnt += dfs(next, node);
        }
        
        if(next_cnt==0){
            // 모든 자식들 등불 없음 (부모 등불 필요)
            return 1;
        } else {
            // 내가 켜야함
            cnt+=1;
        }
        
        return 0;
    }
}