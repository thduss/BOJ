class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long low=0L, high= 0L;        
        for (int t : times) {
            if (t > high) high = t;
        }
        high *= (long) n;
        
        while(low < high){
            long mid = (low+high)/2;
            
            long people=0;
            for(int time : times){
                people += (mid/time);
                
                if (people >= n) break; 
            }
            
            if(people>=n){
                high = mid;
            }else {
                low = mid+1;
            }
        }
        
        answer = low;
        
        return answer;
    }
}