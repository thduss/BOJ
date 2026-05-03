import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        
        Arrays.sort(citations);
        
        for(int h=citations[n-1]; h>=0; h--){
            int cnt=0;
            for(int i=n-1; i>=0; i--){
                if(citations[i]>=h){
                    cnt++;
                } else {
                    break;
                }
            }
            
            if(cnt>=h){
                return h;
            }
        }
        
        return answer;
    }
}