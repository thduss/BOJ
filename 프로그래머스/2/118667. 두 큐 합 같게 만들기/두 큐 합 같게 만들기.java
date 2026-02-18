import java.util.*;

class Solution {
    public static int n1, n2;
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long sum1 = 0, sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int n : queue1){
            q1.add(n);
            sum1+=n;
        }
        for(int n : queue2){
            q2.add(n);
            sum2+=n;
        }
        
        long totalSum = sum1 + sum2;
        if(totalSum % 2 != 0) return -1;
        
        long target = totalSum/2;
        int p1=0, p2=0;
        int limit = (queue1.length+queue2.length)*2;
        
        while(answer<=limit){
            if(sum1==target){
                return answer;
            }
            
            if(sum1 > target){
                int val = q1.poll();
                sum1-=val;
                sum2+=val;
                q2.add(val);
            } else {
                int val = q2.poll();
                sum1+=val;
                sum2-=val;
                q1.add(val);
            }
            answer++;
        }
        
        return -1;
    }
}