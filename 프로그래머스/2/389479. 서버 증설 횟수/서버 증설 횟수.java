// m명 늘어날 때마다 1대 추가
// n*m <= x < (n+1)*m : n대
// 한 번 증설 서버 : k시간 운영/그후 반납
// 최소 몇 번 증설?

import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        int[] add = new int[players.length];            
        int server = players[0]/m;
        add[0] = server;
        answer += server;
        
        for(int i=1; i<players.length; i++){
            int need = players[i]/m;
            if(i-k>=0) server -= add[i-k];
            
            if(need>server){
                answer += (need-server);
                add[i] += (need-server);
                server += add[i];
            }
        }
        
        return answer;
    }
}