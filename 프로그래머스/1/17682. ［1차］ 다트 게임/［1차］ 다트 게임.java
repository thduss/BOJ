// S: 1, D: 2, T: 3
// *: 2배, #: 마이너스

import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            
            if(Character.isDigit(c)){
                // 10인 경우
                if(i+1<dartResult.length()){
                    if(Character.isDigit(dartResult.charAt(i+1))) {
                        stack.add(10);
                        i++;
                        continue;
                    }
                }
                
                stack.add(c-'0');
            } else {
                if(c=='D'){
                    int num = multiple(stack.pop(), 2);
                    stack.add(num);
                } else if(c=='T'){
                    int num = multiple(stack.pop(), 3);
                    stack.add(num);
                } else if(c=='#'){
                    stack.add(stack.pop()*-1);
                } else if(c=='*'){
                    twice(stack);
                }
            }
        }
        
        while(!stack.isEmpty()){
            int num = stack.pop();
            answer += num;
        }
        
        return answer;
    }
    
    public int multiple(int num, int cnt){
        int answer = 1;
        
        for(int i=0; i<cnt; i++){
            answer*=num;
        }
        
        return answer;
    }

    public void twice(Stack<Integer> stack){
        Stack<Integer> tmp = new Stack<>();
        int cnt=0;
        while(!stack.isEmpty() && cnt<2){
            tmp.add(stack.pop()*2);
            cnt++;
        }
        
        while(!tmp.isEmpty()){
            stack.add(tmp.pop());
        }
    }
}