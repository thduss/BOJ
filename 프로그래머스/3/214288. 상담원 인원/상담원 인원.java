// 멘토 n명, 1~k번 상담 유형 (각 멘토당 하나의 유형)
// 상담 유형을 담당하는 멘토 중 상담 중이 아닌 멘토와 시작
// 대기 시간 = 시작 시각 - 요청 시각
// 최소 대기 시간

import java.util.*;

class Solution {
    public int[][] wait;
    public int k, n, answer=Integer.MAX_VALUE;
    
    public int solution(int k, int n, int[][] reqs) {
        this.k = k;
        this.n = n;
        wait = new int[k+1][n+1];
        
        for(int type=1; type<=k; type++){
            for(int m=1; m<=n-k+1; m++){
                wait[type][m] = waitTime(type, m, reqs);
            }
        }
        
        dfs(1, n, 0);
        return answer;
    }
    
    public void dfs(int type, int remain, int sum){
        if(sum>=answer) return;
        if(type==k){
            answer = Math.min(answer, sum+wait[type][remain]);
            return;
        }
        
        for(int i=1; i<=remain-(k-type); i++){
            dfs(type+1, remain-i, sum+wait[type][i]);
        }
    }

    // 대기 시간
    public int waitTime(int type, int n, int[][] reqs){
        List<int[]> list = new ArrayList<>();
        for(int[] req : reqs) {
            if(req[2]==type) list.add(new int[]{req[0], req[1]});
        }
        
        int time = 0;
        PriorityQueue<Integer> ing = new PriorityQueue<>(); // 상담 종료시각
        for(int[] req : list){
            if(ing.size()<n){
                ing.add(req[0]+req[1]);
            } else{
                int fin = ing.poll();
                
                if(fin<=req[0]){
                    ing.add(req[0]+req[1]);
                } else {
                    time += fin - req[0];
                    ing.add(fin+req[1]);
                }
            }
        }
        
        return time;
    }
}