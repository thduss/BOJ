import java.util.*;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        long need = 0;
        for(int i=1; i<=count; i++){
            need += price*i;
        }
        
        if(money<need){
            answer = need - money;
        }
        
        return answer;
    }
}