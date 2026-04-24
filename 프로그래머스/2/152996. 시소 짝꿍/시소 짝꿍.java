import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        long[] weight = new long[1001];
        
        for(int w : weights){
            weight[w]++;
        }
        
        for(int i=100; i<1001; i++){
            if(weight[i]==0) continue;
            
            // nC2
            answer += (weight[i]*(weight[i]-1))/2;
            
            // 1 : 2
            if(i*2<1001){
                answer += weight[i] * weight[i*2];
            }
            
            // 2 : 3
            if (i*3%2==0 && (i*3/2)<1001) {
                answer += weight[i] * weight[i*3/2];
            }
            
            // 3 : 4
            if(i*4%3==0 && i*4/3<1001){
                answer += weight[i] * weight[i*4/3];
            }
        }
        
        return answer;
    }
}