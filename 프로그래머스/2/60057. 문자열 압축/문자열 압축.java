import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        int len = s.length();
        
        for(int i=1; i<len; i++){
            int cnt = compare(s, i);
            answer = Math.min(cnt, answer);
        }
        
        return answer;
    }
    
    public int compare(String str, int cnt){
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<str.length(); i+=cnt){
            int end = Math.min(i+cnt, str.length());
            list.add(str.substring(i, end));
        }
        
        int idx=0;
        int len=0;
        while(idx<list.size()){
            String word = list.get(idx);
            int c = 0;
            
            while(idx<list.size() && list.get(idx).equals(word)){
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