import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for(String com : completion){
            map.put(com, map.getOrDefault(com,0)+1);
        }
        
        for(String par : participant){
            if(map.getOrDefault(par,0)>0){
                map.put(par, map.getOrDefault(par, 0)-1);
            } else {
                answer = par;
                break;
            }
            
        }
        
        return answer;
    }
}