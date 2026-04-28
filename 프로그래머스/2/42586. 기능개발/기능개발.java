import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int cnt=0;
        for(int i=0; i<progresses.length; i++){
            int day = (100-progresses[i])/speeds[i];
            if(((100-progresses[i])%speeds[i])!=0) day+=1;
            
            cnt++;
            if(stack.empty()){
                stack.push(day);
                continue;
            }
            
            if(stack.peek()<day){
                stack.pop();
                list.add(cnt-1);
                cnt=1;
                stack.add(day);
            }
            
        }
        
        if(!stack.isEmpty()){
            list.add(cnt);
        }

        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}