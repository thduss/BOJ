import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) pq.add(s);
        
        while(pq.size()>=2){
            int first = pq.poll();
            if(first>=K) {
                pq.add(first);
                return answer;
            }
            int second = pq.poll();
            
            int mix = first + second*2;
            pq.add(mix);
            answer++;
        }
        
        if(!pq.isEmpty()){
            int cur = pq.poll();
            if(cur>=K) return answer;
        }
        
        return -1;
    }
}