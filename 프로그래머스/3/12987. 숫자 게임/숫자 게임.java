import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a=0, b=0;
        while(b < B.length){
            // 이기는 경우
            if(B[b]>A[a]){
                a++;
                answer++;
            }
            
            b++;
        }
        
        return answer;
    }
}