import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";

        Stack<Character> st = new Stack<>();
        for(int i=0; i<number.length(); i++){
            if(st.isEmpty() || k<=0) {
                st.add(number.charAt(i));
                continue;
            }
            
            while(!st.isEmpty() && k>0 && st.peek()<number.charAt(i)){
                st.pop();
                k--;
            }
            st.add(number.charAt(i));
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