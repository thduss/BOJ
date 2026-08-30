import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        
        Arrays.sort(targets, (a, b) -> b[1] - a[1]);
        
        int s = targets[0][0], e = targets[0][1];
        for(int[] t : targets){
            if(t[1]<=s){
                s = t[0];
                e = t[1];
                answer++;
                continue;
            }
            
            s = Math.max(s, t[0]);
            e = Math.min(e, t[1]);
        }
        
        return answer;
    }
}