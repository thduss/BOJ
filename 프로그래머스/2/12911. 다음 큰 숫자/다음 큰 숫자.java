import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;

        int ncnt = count(n);
        
        answer = n+1;
        while(true){
            if(ncnt==count(answer)) break;
            answer++;
        }
        
        return answer;
    }
    
    public int count(int n){
        String binary = Integer.toBinaryString(n);
        int cnt=0;
        
        for(int i=0; i<binary.length(); i++){
            if(binary.charAt(i)=='1') cnt++;
        }
        
        return cnt;
    }
}