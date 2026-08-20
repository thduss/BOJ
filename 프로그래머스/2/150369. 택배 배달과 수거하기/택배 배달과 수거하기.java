
import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int go=n-1, back=n-1;
        
        while(go>=0 || back>=0){
            int d_cnt = 0;
            int d_max = -1; // 목적지
            while(d_max<0 && go >=0){
                if(deliveries[go]>0){
                    d_max = go;
                    break;
                } else {
                    go--;
                }
            }
            
            while(d_cnt<cap && go>=0){
                if(deliveries[go]+d_cnt<=cap){
                    d_cnt += deliveries[go];
                    deliveries[go--] = 0;
                } else {
                    deliveries[go] -= (cap-d_cnt);
                    d_cnt = cap;
                }
            }
            
            int p_cnt = 0;
            int p_max = -1; // 출발지
            while(p_max<0 && back >=0){
                if(pickups[back]>0){
                    p_max = back;
                    break;
                } else {
                    back--;
                }
            }
            
            while(p_cnt<cap && back>=0){
                if(pickups[back]+p_cnt<=cap){
                    p_cnt += pickups[back];
                    pickups[back--] = 0;
                } else {
                    pickups[back] -= (cap-p_cnt);
                    p_cnt = cap;
                }
            }
            
            answer += Math.max(d_max+1, p_max+1)*2;
        }
        
        return answer;
    }
}