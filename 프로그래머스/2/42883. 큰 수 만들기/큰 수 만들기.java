import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";

        Stack<Character> st = new Stack<>();
        for(int i=0; i<number.length(); i++){
            char c = number.charAt(i);
            if(st.isEmpty()){
                st.add(c);
            } else {
                while(!st.isEmpty() && st.peek()<c && k>0){
                    k--;
                    st.pop();
                }
                st.add(c);
            }
        }
        
        while(k>0){
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        answer = sb.reverse().toString();
        return answer;
    }
}