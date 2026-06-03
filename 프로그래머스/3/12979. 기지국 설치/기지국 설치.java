import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int front = 1;
        for(int i=0; i<stations.length; i++){
            if(stations[i]-w-1>=front){
                answer += addStations(front, stations[i]-w-1, w);
            }
            
            front = stations[i]+w+1;
        }
        
        if(front<=n){
            answer += addStations(front, n, w);
        }

        return answer;
    }
    
    private static int addStations(int start, int end, int w){
        int cnt=0;
        if((end-start+1)>(2*w+1)){
            if((end-start+1)%(2*w+1)==0){
                cnt = (end-start+1)/(2*w+1);
            } else {
                cnt = ((end-start+1)/(2*w+1))+1;
            }
        } else {
            cnt = 1;
        }
        
        return cnt;
    }
}