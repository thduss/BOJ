import java.util.*;

class Solution {
    HashMap<Long, Long> map;
    
    public long find(long a){
        if(!map.containsKey(a)) {
            map.put(a, a+1);
            return a;
        }
        
        long next = find(map.get(a));
        map.put(a, next);
        return next;
    }
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        map = new HashMap<>();
        
        for(int i=0; i<room_number.length; i++){
            long num = find(room_number[i]);
            answer[i] = num;
        }
        
        return answer;
    }
}