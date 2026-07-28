import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        
        if (n <= cores.length) {
            return n;
        }
        
        int maxC = -1;
        for(int c : cores) maxC = Math.max(c, maxC);

        long l = 1, r = (long)n*maxC;
        n -= cores.length;
        long target_time = 0;
        
        while(l<=r){
            long mid_time = (l+r)/2;
            
            long cnt=0;
            for(int c : cores) cnt += (mid_time/c);
            
            if (cnt >= n) {
                target_time = mid_time;
                r = mid_time - 1;
            } else {
                l = mid_time + 1;
            }
        }
        
        long cnt = 0;
        for (int c : cores) {
            cnt += (target_time - 1) / c;
        }

        for (int i = 0; i < cores.length; i++) {
            if (target_time % cores[i] == 0) {
                cnt++;
                if (cnt == n) {
                    return i + 1;
                }
            }
        }
        
        return answer;
    }
}