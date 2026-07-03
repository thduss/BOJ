import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works){
            pq.add(w);
        }
        
        while(n>0 && !pq.isEmpty()){
            int remain = pq.poll() - 1;
            if(remain>0){
                pq.add(remain);
            }
            n--;
        }
        
        while(!pq.isEmpty()){
            int w = pq.poll();
            answer += (w*w);
        }
        
        return answer;
    }
}