import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        
        Set<String> g_size = new HashSet<>();
        for(String g : gems) g_size.add(g);
        int size = g_size.size();

        Map<String, Integer> map = new HashMap<>();
        
        int s = 0;
        int minLen = gems.length;
        answer = new int[2];
        for(int e=0; e<gems.length; e++){
            map.put(gems[e], map.getOrDefault(gems[e],0)+1);
            
            // start 위치 조정
            while(map.size()==size){
                if(e-s<minLen){
                    minLen = e-s;
                    answer[0] = s+1;
                    answer[1] = e+1;
                }
                
                map.put(gems[s], map.get(gems[s])-1); 
                if(map.get(gems[s])==0){
                    map.remove(gems[s]);
                }
                s++;
            }
            
        }
        
        return answer;
    }
}