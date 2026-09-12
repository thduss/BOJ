import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(int i=1; i<numbers.length; i++){
            while(!st.isEmpty() && numbers[st.peek()]<numbers[i]){
                answer[st.peek()] = numbers[i];
                st.pop();
            }
            
            st.push(i);
        }
        
        while(!st.empty()){
            answer[st.peek()] = -1;
            st.pop();
        }
        return answer;
    }
}