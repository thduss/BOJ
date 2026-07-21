import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<survey.length; i++){
            
            if(choices[i]>4){
                // 뒤
                String str = survey[i].split("")[1] + "";
                int score = Math.abs(4 - choices[i]);
                
                map.put(str, map.getOrDefault(str, 0) + score);
            } else if(choices[i]<4){
                // 앞
                String str = survey[i].split("")[0] + "";
                int score = Math.abs(4 - choices[i]);
                
                map.put(str, map.getOrDefault(str, 0) + score);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        // RT
        if(map.getOrDefault("R", 0)>=map.getOrDefault("T",0)){
            sb.append("R");
        } else {
            sb.append("T");
        }
        // CF
        if(map.getOrDefault("C", 0)>=map.getOrDefault("F",0)){
            sb.append("C");
        } else {
            sb.append("F");
        }
        // JM
        if(map.getOrDefault("J", 0)>=map.getOrDefault("M",0)){
            sb.append("J");
        } else {
            sb.append("M");
        }
        // AN
        if(map.getOrDefault("A", 0)>=map.getOrDefault("N",0)){
            sb.append("A");
        } else {
            sb.append("N");
        }
        
        answer = sb.toString();
        return answer;
    }
}