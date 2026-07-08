import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";

        Map<Integer, Integer> x = new HashMap<>();
        for(int i=0; i<X.length(); i++){
            int num = X.charAt(i) - '0';
            x.put(num, x.getOrDefault(num,0)+1);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<Y.length(); i++){
            int num = Y.charAt(i) - '0';
            
            if(x.getOrDefault(num,0)>0){
                list.add(num);
                x.put(num, x.getOrDefault(num,0)-1);
            }
        }
        
        if(list.size()<1){
            return "-1";
        }
        
        Collections.sort(list);
        
        if(list.get(list.size()-1)==0){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=list.size()-1; i>=0; i--){
            sb.append(list.get(i));
        }
        
        answer = sb.toString();
        return answer;
    }
}