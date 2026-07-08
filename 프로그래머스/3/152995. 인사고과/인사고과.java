import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        
        int w1 = scores[0][0];
        int w2 = scores[0][1];
        int wsum = w1 + w2;
        
        // 근무태도(내림차순), 동료평가(오름차순)
        Arrays.sort(scores, (a,b) -> {
            if(a[0]==b[0]){
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
        });
        
        int maxS2 = 0; // 나보다 근무 태도 높은 사람들의 가장 높은 동료 평가 점수
        int rank = 1;
        
        for(int[] s : scores){
            if(s[1]<maxS2){
                if(s[0]==w1 && s[1]==w2) return -1;
            } else {
                maxS2 = Math.max(maxS2, s[1]);
                
                if(s[0]+s[1]>wsum){
                    rank++;
                }
            }
        }
        
        answer = rank;
        
        return answer;
    }
}