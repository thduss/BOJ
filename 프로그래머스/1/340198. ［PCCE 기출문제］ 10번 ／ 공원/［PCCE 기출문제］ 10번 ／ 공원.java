import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;

        int[][] dp = new int[park.length][park[0].length];
        int size = 0;
        
        for(int i=0; i<park.length; i++){
            if(park[i][0].equals("-1")) {
                dp[i][0] = 1;
                size = 1;
            }
        }
        
        for(int i=0; i<park[0].length; i++){
            if(park[0][i].equals("-1")) {
                dp[0][i] = 1;
                size = 1;
            }
        }
        
        for(int i=1; i<park.length; i++){
            for(int j=1; j<park[0].length; j++){
                if(park[i][j].equals("-1")){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    size = Math.max(size, dp[i][j]);
                }
            }
        }
        
        Arrays.sort(mats);
        for(int i=mats.length-1; i>=0; i--){
            if(size>=mats[i]){
                answer = Math.min(size, mats[i]);
                break;
            }
            if(i==0) answer = -1;
        }
        return answer;
    }
}