import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        
        if(cacheSize==0) return 5*cities.length;
        
        for(String c : cities){
            String city = c.toLowerCase();
            
            if(set.contains(city)){
                queue.remove(city);
                queue.add(city);
                answer+=1;
            } else {
                if(queue.size()<cacheSize){
                    queue.add(city);
                    set.add(city);
                } else {
                    String delete = queue.poll();
                    set.remove(delete);
                    
                    queue.add(city);
                    set.add(city);
                }
                answer+=5;
            }
        }
        
        return answer;
    }
}