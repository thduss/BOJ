import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for(int i=1; i<=s.length(); i++){            
            int len = compress(s, i);
            answer = Math.min(answer, len);    
        }
        
        return answer;
    }
    
    public int compress(String str, int cnt){
        
        List<String> list = new ArrayList<>();
        for(int i=0; i<str.length(); i+=cnt){
            int end = Math.min(i+cnt, str.length());
            String word = str.substring(i, end);
            list.add(word);
        }
        
        int idx=0;
        String word = "";
        int len = 0;
        while(idx<list.size()){
            word = list.get(idx);
            
            int c = 0;
            while(idx<list.size() && word.equals(list.get(idx))){
                c++;
                idx++;
            }
            
            if(c==1) len += word.length();
            else {
                len += word.length();
                len += Integer.toString(c).length();
            }
        }
        
        return len;
    }
}