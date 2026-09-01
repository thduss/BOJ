/*
- 뜯어낸 스티커에 적힌 숫자 합이 최대
- 뜯은 스티커의 인접 스티커 사용 X
*/
import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int len = sticker.length;
        if (len == 1) return sticker[0];
        if (len == 2) return Math.max(sticker[0], sticker[1]);
        
        int[] dp = new int[sticker.length];
        dp[0] = sticker[0];
        dp[1] = Math.max(dp[0], sticker[1]);
        answer = Math.max(answer, dp[1]);
        
        for(int i=2; i<sticker.length-1; i++){
            dp[i] = Math.max(sticker[i] + dp[i-2], dp[i-1]);
            answer = Math.max(answer, dp[i]);
        }

    
        dp = new int[sticker.length];
        dp[0] = sticker[1];
        dp[1] = Math.max(dp[0], sticker[2]);            
        answer = Math.max(answer, dp[1]);

        for(int i=2; i<sticker.length-1; i++){
            dp[i] = Math.max(sticker[i+1] + dp[i-2], dp[i-1]);
            answer = Math.max(answer, dp[i]);            
        }
        
        return answer;
    }
}