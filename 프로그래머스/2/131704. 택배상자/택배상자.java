import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> backBelt = new Stack<>();
        for(int i=1; i<order[0]; i++) backBelt.add(i);
        answer=1;
        int beltIdx = order[0]+1;
        
        for(int i=1; i<order.length; i++){
            if(order[i]>beltIdx){
                for(int j=beltIdx; j<order[i]; j++) backBelt.add(j);
                beltIdx = order[i]+1;
                answer++;
            } else if(order[i]<beltIdx){
                if(backBelt.peek()==order[i]){
                     backBelt.pop();
                    answer++;
                }
                else if(backBelt.peek()!=order[i]){
                    return answer;
                }
            } else if(beltIdx==order[i]){
                beltIdx++;
                answer++;
            }
        }
        
        return answer;
    }
}