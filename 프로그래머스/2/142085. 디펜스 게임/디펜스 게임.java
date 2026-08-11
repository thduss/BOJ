import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<enemy.length; i++){
            int e = enemy[i];
            if(n>=e){
                pq.add(e);
                n-=e;
                answer++;
            } else {
                if(k>0){
                    if(!pq.isEmpty()){
                        if(pq.peek()>e){
                            int cur = pq.poll();
                            n+=cur;
                            n-=e;
                            pq.add(e);
                        }
                    }
                    k--;
                    answer++;
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}