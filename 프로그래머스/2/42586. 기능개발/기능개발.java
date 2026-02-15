import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> list = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        int cnt=0, idx=0;
        
        while(idx<speeds.length){
            int workDay = (int) Math.ceil((100.0-progresses[idx])/speeds[idx]);
        
            cnt++;
            idx++;
            
            if(st.empty()){
                st.add(workDay);
                continue;
            }
                
            if(st.peek()<workDay){
                st.pop();
                list.add(cnt-1);
                cnt=1;
                st.add(workDay);
            }
        }
        
        if(!st.isEmpty()){
            list.add(cnt);
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}