// 1~n 순서대로 전달
// 보조 컨테이너에 보관 (stack)
import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        int belt=1;
        Stack<Integer> keep = new Stack<>();
        
        for(int box : order){
            while(belt<box){
                keep.add(belt++);
            }    
            
            if(belt==box){
                answer++;
                belt++;
            } else if(keep.peek()==box){
                keep.pop();
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}