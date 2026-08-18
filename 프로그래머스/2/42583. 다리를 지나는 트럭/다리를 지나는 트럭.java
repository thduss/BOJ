// 일차선 다리, 정해진 순서
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<bridge_length; i++) queue.add(0);
        
        int sum=0, idx=0, time=0; 
        
        while(idx<truck_weights.length){
            int cur = queue.poll();
            sum -= cur;
            int w = truck_weights[idx];
            
            if(sum+w<=weight){
                queue.add(w);
                sum+=w;
                idx++;
            } else {
                queue.add(0);
            }
            time++;
        }
        
        while(!queue.isEmpty()){
            time++;
            queue.poll();
        }
        answer = time;
        
        return answer;
    }
}