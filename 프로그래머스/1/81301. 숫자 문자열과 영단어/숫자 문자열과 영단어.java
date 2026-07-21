import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        StringBuilder find = new StringBuilder();
        StringBuilder num = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            
            if(Character.isDigit(s.charAt(i))){
                if(!map.getOrDefault(find.toString(), "false").equals("false")){
                    num.append(map.get(find.toString()));
                    find = new StringBuilder();
                } 
                
                num.append(s.charAt(i));
                continue;
            } else {
                if(!map.getOrDefault(find.toString(), "false").equals("false")){
                    num.append(map.get(find.toString()));
                    find = new StringBuilder();
                } 
                find.append(s.charAt(i));
            }
        }
        
        if(!map.getOrDefault(find.toString(), "false").equals("false")){
            num.append(map.get(find.toString()));
        } 
        
        answer = Integer.parseInt(num.toString());
        
        return answer;
    }
}