import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        if(sequence.length==1) return Math.max(sequence[0], sequence[0]*-1);
        // [-1,1]
        long[] odd = new long[sequence.length];
        odd[0] = sequence[0]*-1;
        // [1,-1]
        long[] even = new long[sequence.length];
        even[0] = sequence[0];
        
        for(int i=1; i<sequence.length; i++){
            if(i%2==1){
                odd[i] = Math.max(odd[i-1]+sequence[i], sequence[i]);
                even[i] = Math.max(even[i-1]+sequence[i]*-1, sequence[i]*-1);
            } else {
                odd[i] = Math.max(odd[i-1]+sequence[i]*-1, sequence[i]*-1);
                even[i] = Math.max(even[i-1]+sequence[i], sequence[i]);
            }
        }
        
        Arrays.sort(odd);
        Arrays.sort(even);
        
        answer = Math.max(odd[sequence.length-1], even[sequence.length-1]);
        return answer;
    }
}