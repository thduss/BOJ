import java.util.*;

class Solution {
    public static List<List<Integer>> list;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int[] wire : wires){
            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }
        
        for(int[] w : wires){
            list.get(w[0]).remove(Integer.valueOf(w[1]));
            list.get(w[1]).remove(Integer.valueOf(w[0]));
            
            int num = find(1);                
            answer = Math.min(answer, Math.abs(num-(n-num)));
            
            list.get(w[0]).add(w[1]);
            list.get(w[1]).add(w[0]);
        }
        
        return answer;
    }
    
    public int find(int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[list.size()];
        
        visited[start] = true;
        queue.add(start);
        int cnt=0;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            cnt++;
            
            for(int i : list.get(cur)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        
        return cnt;
    }
}