import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map = new HashMap<>();
        int sum=0;
        for(int i=0; i<str1.length()-1; i++){
            if(!Character.isLetter(str1.charAt(i)) || !Character.isLetter(str1.charAt(i+1))) continue;
            
            sum++;
            String word = str1.charAt(i) + "" + str1.charAt(i+1);            
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        
        int cross=0;
        for(int i=0; i<str2.length()-1; i++){
            if(!Character.isLetter(str2.charAt(i)) || !Character.isLetter(str2.charAt(i+1))) continue;
            
            String word = str2.charAt(i) + "" + str2.charAt(i+1);
            if(map.getOrDefault(word, 0)<=0){
                sum++;
            } else {
                map.put(word, map.getOrDefault(word, 0)-1);
                cross++;
            }
        }
        
        double j = sum==0 ? 1 : cross/(double)sum;
        answer = (int)(65536 * j);
        
        return answer;
    }
}