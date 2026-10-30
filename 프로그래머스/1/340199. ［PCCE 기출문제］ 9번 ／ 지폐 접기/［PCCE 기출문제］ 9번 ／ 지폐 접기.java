import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int wmin = Math.min(wallet[0],wallet[1]);
        int wmax = Math.max(wallet[0],wallet[1]);
        
        int bmin = Math.min(bill[0],bill[1]);
        int bmax = Math.max(bill[0],bill[1]);
        
        while(wmin<bmin || wmax<bmax){
            answer++;
            
            bmax/=2;
            int tmax = Math.max(bmin, bmax);
            
            bmin = Math.min(bmin, bmax);
            bmax = tmax;
        }
        
        return answer;
    }
}