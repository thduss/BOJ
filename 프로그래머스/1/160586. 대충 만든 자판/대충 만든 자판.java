import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int t=0; t<targets.length; t++){
            int cnt=0;
            String target = targets[t];
            boolean isAdd = true;
            
            for(int i=0; i<target.length(); i++){
                int min = Integer.MAX_VALUE;
                char c = target.charAt(i);
                boolean isContain = false;
                
                for(String key : keymap){
                    if(key.contains(c+"")){
                        int idx=0;
                        
                        while(true) {
                            if(key.charAt(idx)!=c) idx++;
                            else break;
                        }
                        
                        min = Math.min(min, idx+1);
                        isContain = true;
                    }
                }
                
                if(!isContain) isAdd = false;
                cnt += min;
            }
            
            if(isAdd) answer[t] = cnt;
            else answer[t] = -1;
        }
        
        return answer;
    }
}