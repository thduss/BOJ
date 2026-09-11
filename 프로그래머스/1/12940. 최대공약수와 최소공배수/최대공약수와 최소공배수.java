import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int max = Math.max(n, m);
        int min = Math.min(n, m);
        
        answer[0] = gcd(max, min);
        answer[1] = lcm(max, min);
        
        return answer;
    }
    
    public int gcd(int a, int b){
        if(a%b==0){
            return b;
        }
        
        return gcd(b, a%b);
    }
    
    public int lcm(int a, int b){
        int g = gcd(a,b);
        
        return a*b/g;
    }
}