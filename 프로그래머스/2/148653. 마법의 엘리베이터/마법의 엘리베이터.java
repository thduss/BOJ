import java.util.*;

class Solution {
    public static int minCnt = Integer.MAX_VALUE;
    
    public int solution(int storey) {
        int answer = 0;

        dfs(storey, 0);
        answer = minCnt;
        
        return answer;
    }
    
    public void dfs(int num, int cnt){
        if(num==0){
            minCnt = Math.min(cnt, minCnt);
            return;
        }
        
        if(cnt>minCnt) return;
        
        String str = Integer.toString(num);
        int idx = 0;
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i)!='0'){
                idx = i;
                break;
            }
        }
        
        int iNum = str.charAt(idx) - '0';
        int power = str.length() - 1 - idx;
        
        dfs(num - (iNum*(int)Math.pow(10,power)), cnt+iNum);
        dfs(num + ((10-iNum)*(int)Math.pow(10,power)), cnt+(10-iNum));
        
    }
}