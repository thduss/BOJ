import java.util.*;

class Solution {
    public int cnt;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;

        dfs(0,0,numbers, target);
        answer = cnt;
        
        return answer;
    }
    
    public void dfs(int idx, int sum, int[] numbers, int target){
        if(idx>=numbers.length){
            if(sum==target){
                cnt++;
            }
            
            return;
        }
        
        dfs(idx+1, sum+numbers[idx], numbers, target);
        dfs(idx+1, sum-numbers[idx], numbers, target);
    }
}