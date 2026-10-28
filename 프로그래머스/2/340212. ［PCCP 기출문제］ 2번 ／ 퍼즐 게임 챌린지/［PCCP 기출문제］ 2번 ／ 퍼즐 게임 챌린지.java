// n개의 퍼즐을 제한 시간 내에 풀어야 함
// 난이도: diff, 소요 시간: time_cur, 이전 퍼즐 소요시간: time_prev, 숙련도: level
// diff <= level -> time_cur만큼 시간 사용해 해결
// diff > level -> diff-level번 틀림(틀릴 때마다 time_cur+time_prev 추가 소요)

import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;

        int l=1, r=Integer.MIN_VALUE;
        for(int d : diffs){
            r = Math.max(r, d);
        }
        
        while(l<=r){
            int mid = (l+r)/2;
            
            long sum=0, time_prev=0;
            for(int i=0; i<diffs.length; i++){
                if(diffs[i]<=mid){
                    sum+=times[i];
                } else {
                    int cnt = diffs[i] - mid;
                    sum+=(time_prev+times[i])*cnt+times[i];
                }
                time_prev=times[i];
                
                if(sum>limit){
                    break;
                }
            }
            
            if(sum<=limit){
                answer = Math.min(answer, mid);
            }
            
            if(sum<limit){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return answer;
    }
}