import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.add(s);
        }
        
        while(true){
            int f = pq.poll();
            
            if(f >= K){
                break;
            }
            
            if(pq.isEmpty()){
                answer = -1;
                break;
            }
            
            int e = pq.poll();
            pq.add(f + (e * 2));
            answer++;
        }
        
        return answer;
    }
}