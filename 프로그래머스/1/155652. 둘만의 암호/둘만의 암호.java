// index만큼 뒤의 알파벳으로 바꿈
// z -> a
// skip에 있는 알파벳 제외하고 건너뜀

import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<skip.length(); i++){
            set.add((int)skip.charAt(i));
        }
        
        int mod = 'a';
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            int c = s.charAt(i);
            
            int num = index;
            while(num>0){
                c+=1;
                if(c>'z') c='a';
                
                if(!set.contains(c)){
                    num--;
                }
            }
            char add = (char)c;
            sb.append(add);
        }
        
        answer = sb.toString();
        
        return answer;
    }
}