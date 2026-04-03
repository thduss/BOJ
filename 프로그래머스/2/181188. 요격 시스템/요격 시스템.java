import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // 종료 시점 기준 오름차순 정렬
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        int lastShoot = -1;
        
        for(int[] target : targets){
            int start = target[0];
            int end = target[1];
            
            if(lastShoot <= start){
                lastShoot = end;
                answer++;
            }
        }
        
        return answer;
    }
}