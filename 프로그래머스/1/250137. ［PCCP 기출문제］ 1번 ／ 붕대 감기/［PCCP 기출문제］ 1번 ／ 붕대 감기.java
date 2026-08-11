// t초 붕대 감기, 1초에 x만큼 체력 회복
// t초 연속 붕대 감는다면 y만큼 추가 회복
// 최대 체력보다 커지면 안됨

// bandage - [시전 시간, 초당 회복량, 추가 회복량] 
// attacks[i] - [공격 시간, 피해량]

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int t=0, h=health;
        for(int[] attack : attacks){
            // 1. 체력 회복
            int ct = attack[0] - t - 1;
            h += (ct*bandage[1]);
            
            if(ct>=bandage[0]){
                h+=(ct / bandage[0])*bandage[2];
            }
            
            h = Math.min(h, health);
            
            // 2. 공격 
            if(h > attack[1]){
                h -= attack[1];
            } else {
                answer = -1;
                break;
            }
            
            // 3. 업데이트
            t = attack[0];
        }
        
        if(answer != -1) answer = h;
        
        return answer;
    }
}