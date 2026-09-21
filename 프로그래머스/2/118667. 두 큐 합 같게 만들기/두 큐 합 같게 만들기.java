import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        long sum1=0, sum2=0;
        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }
        
        for(int i=0; i<queue2.length; i++){
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        if((sum1+sum2)%2!=0) return -1;
        
        int cnt=0;
        while(cnt<(queue1.length+queue2.length)*2){
            if(sum1==sum2){
                answer = cnt;
                break;
            }
            
            if(sum1>sum2){
                int num = q1.poll();
                q2.add(num);
                
                sum1 -= num;
                sum2 += num;
            } else {
                int num = q2.poll();
                q1.add(num);
                
                sum2 -= num;
                sum1 += num;
            }
            cnt++;
        }
        
        return answer;
    }
}