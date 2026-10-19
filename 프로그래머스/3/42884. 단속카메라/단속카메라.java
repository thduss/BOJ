import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (a,b)-> {
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        
        int s=routes[0][0], e=routes[0][1];
        for(int i=1; i<routes.length; i++){
            if(e<routes[i][0]){
                answer++;
                s=routes[i][0];
                e=routes[i][1];
            } else {
                s = Math.max(s, routes[i][0]);
                e = Math.min(e, routes[i][1]);
            }
        }
        
        return answer;
    }
}