import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Set<String>> repo = new HashMap<>();
        
        for(String rep : report){
            String[] arr = rep.split(" ");
            
            map.putIfAbsent(arr[1], new HashSet<>());
            map.get(arr[1]).add(arr[0]);
            
            repo.putIfAbsent(arr[0], new HashSet<>());
            repo.get(arr[0]).add(arr[1]);
        }
        
        Map<String, Boolean> stop = new HashMap<>();
        for(int i=0; i<id_list.length; i++){
            String name = id_list[i];
            
            int size = map.getOrDefault(name, new HashSet<>()).size();
            if(size/k>0){
                stop.put(name, true);
            } else {
                stop.put(name, false);
            }
        }
        
        for(int i=0; i<id_list.length; i++){
            String name = id_list[i];
            Set<String> set = repo.getOrDefault(name, new HashSet<>());
            if(set.size()==0) continue;
            
            for(String n : set){
                if(stop.getOrDefault(n, false)){
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}