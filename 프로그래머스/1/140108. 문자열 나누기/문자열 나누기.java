// 첫글자 : x
// x와 같은 수 == 아닌 수 이 시점에 분리

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        int c1=0, c2=0;
        char c = 'a';
        for(int i=0; i<s.length(); i++){
            if(c1==0){
                c=s.charAt(i);
                c1=1;
                continue;
            }
            
            if(c==s.charAt(i)){
                c1++;
            } else {
                c2++;
            }
            
            if(c1==c2){
                answer++;
                c1=0;
                c2=0;
            }
        }
        
        if(c1!=0) answer++;
        
        return answer;
    }
}