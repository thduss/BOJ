import java.util.*;

class Solution {
    List<Map<String, Integer>> dangerous;
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        int maxTime = 20001;
        dangerous = new ArrayList<>();
        for (int i = 0; i < maxTime; i++) {
            dangerous.add(new HashMap<>());
        }
        
        for(int i=0; i<routes.length; i++){
            int[] r = routes[i];
            int[] start = points[r[0]-1];
            int time = 0;
            
            mark(start[0], start[1], 0);
            
            for(int j=1; j<r.length; j++){
                int[] end = points[r[j]-1];
                time = route(start, end, i, time);
                start = end;
            }
        }
        
        for(Map<String, Integer> map : dangerous){
            for(Integer cnt : map.values()){
                if(cnt>=2) answer++;
            }
        }
        
        return answer;
    }
    
    public int route(int[] start, int[] end, int num, int t){
        int time=t;
        
        int s = start[0];
        
        while(s!=end[0]){
            s += (s > end[0]) ? -1 : 1;
            time++;
            mark(s, start[1], time);
        }
        
        int e = start[1];
        while(e!=end[1]){
            e += (e > end[1]) ? -1 : 1;
            time++;
            mark(end[0], e, time);
        }
        
        return time;
    } 
    
    public void mark(int r, int c, int t){
        String key = r + "," + c;
        dangerous.get(t).put(key, dangerous.get(t).getOrDefault(key, 0)+1);
    }
}