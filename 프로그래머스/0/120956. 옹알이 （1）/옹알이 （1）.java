import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String b : babbling){
            b = b.replaceAll("aya|ye|woo|ma", "");
            if(b.length()==0) answer++;
        }
        
        return answer;
    }
}