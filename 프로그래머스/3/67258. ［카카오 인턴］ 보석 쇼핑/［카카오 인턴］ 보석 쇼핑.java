import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        for(String str : gems){
            set.add(str);
        }
        int cnt = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        int s = 0, minLen=gems.length;
        for(int e=0; e<gems.length; e++){
            map.put(gems[e], map.getOrDefault(gems[e], 0)+1);
            
            while(map.size() == cnt){
                if(e - s < minLen){
                    minLen = e - s;
                    answer[0] = s+1;
                    answer[1] = e+1;
                }
                
                map.put(gems[s], map.get(gems[s])-1);
                if(map.get(gems[s])==0) map.remove(gems[s]);
                s++;
            }
        }
        
        return answer;
    }
}