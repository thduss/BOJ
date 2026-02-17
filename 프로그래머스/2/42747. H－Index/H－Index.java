import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        
        Arrays.sort(citations);
        
        for(int h=n; h>=0; h--){
            int cnt=0;
            for(int i=0; i<n; i++){                
                if(citations[i]>=h){
                    cnt++;
                }
            }
            
            if(cnt>=h){
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}