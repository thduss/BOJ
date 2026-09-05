import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int move = name.length()-1;
        for(int i=0; i<name.length(); i++){
            int f = name.charAt(i) - 'A';
            int b = 'Z' - name.charAt(i) + 1;
            answer += Math.min(f,b);
            
            // 연속'A' 개수
            int idx = i+1;
            while(idx<name.length() && name.charAt(idx)=='A') idx++;
            
            int fmove = 2*i + (name.length()-idx); 
            int bmove = (name.length()-idx)*2 + i;
            move = Math.min(move, Math.min(fmove,bmove));
        }
        
        answer+=move;
        
        return answer;
    }
}