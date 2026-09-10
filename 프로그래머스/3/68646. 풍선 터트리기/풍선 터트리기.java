import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        if(a.length==1) return 1;
        
        boolean[] ok = new boolean[a.length];
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<a.length; i++){
            if(a[i]<min) {
                ok[i] = true;
                min = a[i];
            }
        }
        
        min = Integer.MAX_VALUE;
        for(int i=a.length-1; i>=0; i--){
            if(a[i]<min){
                ok[i] = true;
                min = a[i];
            }
        }
        
        for(int i=0; i<a.length; i++) if(ok[i]) answer++;
        
        return answer;
    }
}