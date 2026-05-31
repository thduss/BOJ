import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(long i=0; i<=d; i+=k){
            long maxY2 = (long)d*d - i*i;
            long maxY = (long)Math.sqrt(maxY2);
            
            answer += (maxY/k) + 1;
        }
        
        return answer;
    }
}