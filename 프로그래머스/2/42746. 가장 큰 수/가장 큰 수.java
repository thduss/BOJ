import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String[] strNumbers = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            strNumbers[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strNumbers, (a,b) -> (b+a).compareTo(a+b));
        
        
        for(int i=0; i<numbers.length; i++){
            answer += strNumbers[i];
        }
        
        if(answer.length()>=2 && answer.charAt(0)=='0') {
            answer = "0";
        }
        
        return answer;
    }
}