import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 나가는 기준 오름차순
        Arrays.sort(routes, (o1,o2) -> o1[1] - o2[1]);
        
        int lastCameraPos = -30001;
        
        for(int[] route : routes){
            if(lastCameraPos<route[0]){
                answer++;
                lastCameraPos = route[1];
            }
        }
        
        return answer;
    }
}