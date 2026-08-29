import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            long n = numbers[i];
            
            if(n == 0) {
                answer[i] = 1;
                continue;
            }
            
            if(n % 2 == 0) {
                answer[i] = n | 1;
            } else {
                int j = 0;
                while(((n >> j) & 1) == 1) {
                    j++;
                }
                answer[i] = (n | (1L << j)) & ~(1L << (j-1));
            }
        }
        
        return answer;
    }
}