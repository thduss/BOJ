// 초 -> 노 -> 빨
// 모두 노란불이 되는 가장 빠른 초
// 만약 존재하지 않는다면 -1

import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int answer = -1;
        
        // 인덱스 위치 구할 mod 값
        List<Integer> mod = new ArrayList<>();
        boolean[][] isYellow = new boolean[signals.length][21];
        int maxTime = 1;
        
        for(int i=0; i<signals.length; i++){
            int[] signal = signals[i];
            int sum = 0;
            
            for(int n : signal) {
                sum+=n;
            }
            
            for(int s=signal[0]+1; s<=signal[0]+signal[1]; s++) isYellow[i][s] = true;
            
            maxTime *= sum;
            mod.add(sum);
        }
        
        int t=1;
        
        while(true){
            boolean isY = true;
            for(int i=0; i<mod.size(); i++){
                int m = mod.get(i);
                int idx = t%m;
                
                if(!isYellow[i][idx]){
                    isY = false;
                    continue;
                }
            }
            
            if(isY){
                answer = t;
                break;
            }
            
            t++;
            if(t>maxTime) break;
        }
        
        return answer;
    }
}