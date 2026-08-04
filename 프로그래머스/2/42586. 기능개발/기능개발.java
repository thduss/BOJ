import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Stack<Integer> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        int pre = 0;
        
        for(int i=0; i<progresses.length; i++){
            int day = (100-progresses[i])/speeds[i];
            
            if((100-progresses[i])%speeds[i]!=0) day++;
            
            if(stack.isEmpty() || pre>=day){
                pre = Math.max(pre, day);
                stack.add(day);
            } else {
                
                int cnt=0;
                
                while(!stack.isEmpty()){
                    stack.pop();
                    cnt++;
                }
                
                ans.add(cnt);
                
                pre = Math.max(pre, day);
                stack.add(day);
            }
        }
        
        int cnt=0;
        
        while(!stack.isEmpty()){
            stack.pop();
            cnt++;
        }
        
        if(cnt>0) ans.add(cnt);
        
        answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) answer[i] = ans.get(i);
        
        return answer;
    }
}