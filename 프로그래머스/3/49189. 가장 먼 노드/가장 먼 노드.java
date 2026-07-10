import java.util.*;

class Solution {

    public static ArrayList<ArrayList<Integer>> graph;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());   
        }
        
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int[] arr = dikstra(1, n);
        int max = -1;
        for(int i=1; i<arr.length; i++){
            if(max<arr[i]){
                max = arr[i];
                answer = 0;
            }
            
            if(max==arr[i]) answer++;
        }
        
        return answer;
    }
    
    public static int[] dikstra(int start, int N){
        int[] arr = new int[N+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[1] = 0;
        
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        
        while(!que.isEmpty()){
            int cur = que.poll();
            
            for(int next : graph.get(cur)){
                if(arr[next]>arr[cur]+1){
                    arr[next] = arr[cur]+1;
                    que.add(next);
                }
            }
        }
        
        return arr;
    }
}