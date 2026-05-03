import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] c : clothes){
            map.put(c[1], map.getOrDefault(c[1], 1)+1);
        }
        
        for(String item : map.keySet()){
            answer *= map.get(item);
            
        }
        answer-=1;
        
        return answer;
    }
}