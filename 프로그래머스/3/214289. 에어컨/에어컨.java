// 실내공조 제어 시스템 : t1 ~ t2 유지 & 에어컨 전력 최소화
// 에어컨 O : 실내온도 != 희망온도 -> 1분 뒤 같아지는 방향으로 (+)/(-)
// 에어컨 X : 실외온도와 같아지는 방향으로 (+)/(-)
// 에어컨 소비 전력은 실내!=희망: a, 실내==희망: b

import java.util.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int answer = 0;
        
        int MAX_TEMP = 50; 
        int OFFSET = 10;
        int outTemp = temperature+OFFSET;
        int targetMin = Math.min(t1, t2) + OFFSET;
        int targetMax = Math.max(t1, t2) + OFFSET;
        
        // dp[시간][온도]
        int[][] dp = new int[onboard.length][MAX_TEMP+1];
        int INF = 100000 * 100;
        
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], INF);
        }
        
        dp[0][outTemp] = 0;
        
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<=MAX_TEMP; j++){
                
                // 사람 탑승 중 & 온도 벗어남
                if(onboard[i]==1 && (j<targetMin || j>targetMax)){
                    continue;
                }
                
                int minCost = INF;
                
                // 1. 1도 상승
                if(j-1 >= 0){
                    minCost = Math.min(minCost, dp[i-1][j-1] + a); // 에어컨 켜기
                    if(j-1<outTemp){
                        minCost = Math.min(minCost, dp[i-1][j-1]); // 에어컨 끄기
                    }
                }
                
                // 2. 1도 하강
                if(j+1 <= MAX_TEMP){
                    minCost = Math.min(minCost, dp[i-1][j+1] + a); // 에어컨 켜기
                    if(j+1>outTemp){
                        minCost = Math.min(minCost, dp[i-1][j+1]); // 에어컨 끄기
                    }
                }
                
                // 3. 유지
                minCost = Math.min(minCost, dp[i-1][j]+b);
                if(j==outTemp){
                    minCost = Math.min(minCost, dp[i-1][j]);
                }
                
                dp[i][j] = minCost;
            }
        }
        
        answer = INF;
        for(int i=0; i<=MAX_TEMP; i++){
            answer = Math.min(answer, dp[dp.length-1][i]);
        }
        
        
        return answer;
    }
}