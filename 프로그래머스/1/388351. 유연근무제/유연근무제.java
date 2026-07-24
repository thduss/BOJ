import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for(int i=0; i<schedules.length; i++){
            int h = schedules[i] / 100;
            int m = schedules[i] % 100 + 10;
            
            if(m >= 60){
                h+=1;
                m%=60;
            }
            
            int day = startday;
            boolean canGet = true;
            
            for(int j=0; j<7; j++){
                if(day==6){
                    day++;
                    continue;
                } else if (day==7){
                    day = 1;
                    continue;
                }
                
                int comeH = timelogs[i][j] / 100;
                int comeM = timelogs[i][j] % 100;
                
                if(comeH>h || (comeH==h && comeM>m)) {
                    canGet = false;
                    break;
                }
                
                day++;
            }
            if(canGet) answer++;
        }
        
        return answer;
    }
}