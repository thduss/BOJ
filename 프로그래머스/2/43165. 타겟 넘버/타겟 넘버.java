import java.util.*;

class Solution {
    public static int cnt;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        cnt = 0;
        dfs(0, 0, numbers, target);
        answer = cnt;
        
        return answer;
    }
    
    public void dfs(int idx, int num, int[] numbers, int target){
        if(idx>=numbers.length){
            if(target==num){
                cnt++;
            }
            return;
        }
        
        dfs(idx+1, num+numbers[idx], numbers, target);
        dfs(idx+1, num-numbers[idx], numbers, target);
    }
}