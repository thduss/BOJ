import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";

        Stack<Integer> stack = new Stack<>();
        int[] numbers = new int[number.length()];
        for(int i=0; i<number.length(); i++){
            numbers[i] = number.charAt(i) - '0';
        }
        
        for(int i=0; i<numbers.length; i++){
            if(k==0) {
                stack.add(numbers[i]);
                continue;
            }
            
            if(stack.isEmpty()){
                stack.add(numbers[i]);
                continue;
            }
            
            while(!stack.isEmpty() && stack.peek()<numbers[i] && k>0){
                k--;
                stack.pop();
            }
            
            stack.add(numbers[i]);
            
        }
        
        while(k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        answer = sb.reverse().toString();
        
        return answer;
    }
}