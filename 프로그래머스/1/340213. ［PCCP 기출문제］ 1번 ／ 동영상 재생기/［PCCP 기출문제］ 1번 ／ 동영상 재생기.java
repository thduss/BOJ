// 오프닝 건너뛰기 (op_start <= 재생 위치 <= op_end인 경우, op_end로)
// 10초 전: prev (10초 미만일 시, 0분 0초)
// 10초 후: next (남은 시간이 10초 미만일때 동영상의 길이로)

import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int[] now = timeSplit(pos);
        
        int[] op_s = timeSplit(op_start);
        int[] op_e = timeSplit(op_end);
        
        int[] finish = timeSplit(video_len);
        
        for(String cmd : commands){
            // op_start <= 재생 위치 <= op_end
            int n = now[1]+now[0]*60;
            if((op_s[1]+op_s[0]*60)<=n && (op_e[1]+op_e[0]*60)>=n){
                now[0] = op_e[0];
                now[1] = op_e[1];
            }
            
            if(cmd.equals("prev")){
                now[1] -=10;
                
                if(now[1]<0){
                    now[1]+=60;
                    now[0]-=1;
                    
                    if(now[0]<0){
                        now[0] = 0;
                        now[1] = 0;
                    }
                }
            } else if (cmd.equals("next")){                
                int remain = (finish[0]*60+finish[1]) - (now[0]*60+now[1]);
                if(remain<10) {
                    now[0] = finish[0];
                    now[1] = finish[1];
                } else {
                    now[1] += 10;
                    
                    if(now[1]>=60){
                        now[1]%=60;
                        now[0]+=1;
                    }
                }
            }
            
            // op_start <= 재생 위치 <= op_end
            n = now[1]+now[0]*60;
            if((op_s[1]+op_s[0]*60)<=n && (op_e[1]+op_e[0]*60)>=n){
                now[0] = op_e[0];
                now[1] = op_e[1];
            }
        }
        
        String h = now[0]==0 ? "00" : now[0]<10 ? "0"+Integer.toString(now[0]) : Integer.toString(now[0]);
        String m = now[1]==0 ? "00" : now[1]<10 ? "0"+Integer.toString(now[1]) : Integer.toString(now[1]);
        
        answer = h + ":" + m;
        
        return answer;
    }
    
    public int[] timeSplit(String str){
        int[] arr = new int[2];
        arr[0] = Integer.parseInt(str.split(":")[0]);
        arr[1] = Integer.parseInt(str.split(":")[1]);
        
        return arr;
    }
}