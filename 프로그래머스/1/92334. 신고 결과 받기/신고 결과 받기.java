import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // id = 이름
        Map<String, Integer> ids = new HashMap<>();
        for(int i=0; i<id_list.length; i++){
            ids.put(id_list[i], i);
        }
        
        // 신고 횟수
        Map<String, Set<String>> map = new HashMap<>();
        for(String s : report){
            String[] str = s.split(" ");
            
            if(!map.containsKey(str[1])){
                map.put(str[1], new HashSet<>());
            }
            map.get(str[1]).add(str[0]);
        }
        
        for(int i=0; i<id_list.length; i++){
            Set<String> check = map.getOrDefault(id_list[i], new HashSet<>());
            
            if(check.size()<k) continue;
            
            for(String c : check){
                int idx = ids.get(c);
                answer[idx] += 1;
            }
        }
        
        return answer;
    }
}