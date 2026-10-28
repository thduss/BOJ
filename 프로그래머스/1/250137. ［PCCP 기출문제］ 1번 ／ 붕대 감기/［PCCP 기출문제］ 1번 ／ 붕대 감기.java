// t초동안 붕대 감으면서 1초에 x만큼 회복 (t초 안에 성공하면 +y)
// 최대 체력보다 커지는 것 불가능, 0이하면 죽음

// bandage: [시전 시간, 초당 회복량, 추가 회복량] 
// attacks[i]: [공격 시간, 피해량]
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        int t=0, h=health, idx=0, c=0;
        while(idx<attacks.length){
            if(t==attacks[idx][0]){
                h-=attacks[idx][1];
                if(h<=0) {
                    answer = -1;
                    return -1;
                }
                
                c=0;
                idx++;
                t++;
                continue;
            }
            
            h+=bandage[1];
            c++;
            if(c==bandage[0]){
                h+=bandage[2];
                c=0;
            }
            if(h>health) h = health;
            t++;
        }
        
        answer = h;
        return answer;
    }
}