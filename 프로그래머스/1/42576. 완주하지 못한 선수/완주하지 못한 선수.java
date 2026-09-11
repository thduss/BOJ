import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for(String c : completion){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        for(String p : participant){
            int cnt = map.getOrDefault(p,0);
            if(cnt>0){
                map.put(p, cnt-1);
            } else {
                answer = p;
                break;
            }
        }
        
        return answer;
    }
}