import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        List<String> cache = new ArrayList<>();
        Set<String> set = new HashSet<>();
        
        if(cacheSize==0) return 5*cities.length;
        
        for(String city : cities){
            String c = city.toLowerCase();
            
            if(set.contains(c)){
                answer += 1;
                cache.remove(c);
                cache.add(0, c);
            } else {
                answer += 5;
                
                if(cache.size()>=cacheSize){
                    String remove = cache.get(cache.size()-1);
                    cache.remove(cache.size()-1);
                    set.remove(remove);
                }

                cache.add(0,c);
                set.add(c);
            }
        }
        
        
        return answer;
    }
}