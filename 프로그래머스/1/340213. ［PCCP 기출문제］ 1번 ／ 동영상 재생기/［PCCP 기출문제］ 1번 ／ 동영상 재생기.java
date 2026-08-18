// prev 10초 전, next 후, op_start<= <= op_end 오프닝 건너뛰기

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int[] start = trans(pos);
        int mm=start[0], ss=start[1];
        
        int[] end = trans(video_len);
        int[] op_s = trans(op_start);
        int[] op_e = trans(op_end);
        
        for(String cmd : commands){    
            if(mm>=op_s[0] && mm<=op_e[0]){
               if((mm==op_s[0] && ss<op_s[1]) || (mm==op_e[0] && ss>op_e[1])){
               } else {
                   mm = op_e[0];
                   ss = op_e[1];
               }
           }
            
            if(cmd.equals("next")){
                ss+=10;
                
                if(ss>=60){
                    mm+=1;
                    ss-=60;
                }
                
                if(mm>=end[0] && ss>=end[1]){
                    mm = end[0];
                    ss = end[1];
                }
                
            } else if (cmd.equals("prev")){
                ss-=10;
                
                if(ss<0){
                    mm-=1;
                    ss+=60;
                }
                
                if(mm<0){
                    mm = 0;
                    ss = 0;
                }
            }
            
            if(mm>=op_s[0] && mm<=op_e[0]){
               if((mm==op_s[0] && ss<op_s[1]) || (mm==op_e[0] && ss>op_e[1])){
               } else {
                   mm = op_e[0];
                   ss = op_e[1];
               }
           }
        }
    
        if(mm<10) answer += "0";
        answer += Integer.toString(mm);
        answer += ":";
        if(ss<10) answer += "0";
        answer+= Integer.toString(ss);
        
        return answer;
    }
    
    public int[] trans(String str){
        int arr[] = new int[2];
        String tmp[] = str.split(":");
        
        arr[0] = Integer.parseInt(tmp[0]);
        arr[1] = Integer.parseInt(tmp[1]);
        
        return arr;
    }
}