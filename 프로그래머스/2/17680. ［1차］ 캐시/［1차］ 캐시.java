import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> queue = new ArrayDeque<>();
        Set<String> cache = new HashSet<>();
        
        if(cacheSize==0) return 5*cities.length;
        
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toLowerCase();
            
            if(queue.size()<cacheSize){
                if(cache.contains(city)){
                    queue.remove(city);
                    queue.add(city);
                    answer+=1;
                } else {
                    queue.add(city);
                    cache.add(city);
                    answer+=5;
                }
                continue;
            } 
            
            if(cache.contains(city)){
                queue.remove(city);
                queue.add(city);
                answer+=1;
            } else {
                String str = queue.poll();
                cache.remove(str);
                queue.add(city);
                cache.add(city);
                answer+=5;
            }
        }
        
        
        return answer;
    }
}