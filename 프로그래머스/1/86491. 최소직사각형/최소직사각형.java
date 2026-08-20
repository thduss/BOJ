
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int w=0, h=0; // 무조건 작은거, 무조건 큰거
        for(int[] size : sizes){
            if((size[0]<=w && size[1]<=h) || (size[0]<=h && size[1]<=w)) continue;
            
            int min = Math.min(size[0], size[1]);
            int max = Math.max(size[0], size[1]);
            
            w = Math.max(min, w);
            h = Math.max(max, h);
        }
        
        answer = w*h;
        return answer;
    }
}