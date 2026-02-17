import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] strArr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            strArr[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strArr, (a,b) -> (b+a).compareTo(a+b));
        
        for(String str : strArr){
            answer += str;
        }
        
        if(answer.charAt(0)=='0'){
            answer = "0";
        }
        
        return answer;
    }   
}