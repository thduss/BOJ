import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (a,b) -> a[0] - b[0]);
        
        int idx=0;
        while(idx<routes.length){
            int s = routes[idx][0];
            int e = routes[idx][1];
            
            int next = idx + 1;
            while(next<routes.length){
                if(routes[next][0]>e) break;
                
                s = Math.max(s, routes[next][0]);
                e = Math.min(e, routes[next][1]);
                
                next++;
            }
            
            idx = next;
            answer++;
        }
        
        return answer;
    }
}