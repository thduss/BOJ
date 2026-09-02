import java.util.*;

class Solution {
    public int N, minCost=Integer.MAX_VALUE;
    public int[][] cost, hint;
    
    public int solution(int[][] cost, int[][] hint) {
        int answer = 0;
        N = cost.length;
        this.cost = cost;
        this.hint = hint;
        
        dfs(0,0, new int[N]);
        answer = minCost;
        
        return answer;
    }
    
    public void dfs(int stage, int sum, int[] getHint){
        if(stage>=N-1){
            sum += cost[stage][getHint[stage]];
            minCost = Math.min(minCost, sum);
            return;
        }
        
        // 안삼
        int hcnt = getHint[stage];
        dfs(stage+1, sum+cost[stage][hcnt], getHint);
        
        // 삼
        int[] isPlus = new int[N];
        for(int i=1; i<hint[stage].length; i++){
            int nstage = hint[stage][i] - 1;
            if(getHint[nstage] >= N-1) continue;
            isPlus[nstage]++;
            getHint[nstage]++;
        }
        dfs(stage+1, sum+cost[stage][hcnt]+hint[stage][0], getHint);
        for(int i=0; i<N; i++){
            if (isPlus[i] > 0) {
                getHint[i] -= isPlus[i];
            }
        }   
    }
}