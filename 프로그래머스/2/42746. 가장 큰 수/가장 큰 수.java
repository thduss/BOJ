import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        List<String> list = new ArrayList<>();
        for(int n : numbers){
            list.add(Integer.toString(n));
        }
        
        Collections.sort(list, (a,b) -> (b+a).compareTo(a+b));
        
        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append(str);
        }
        
        answer = sb.toString();
        if(answer.charAt(0)=='0' && answer.length()>1) answer = "0";
        
        return answer;
    }
    

}