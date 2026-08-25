import java.util.*;

class Solution {
    public int[] info;
    public int maxDiff;
    public long bestKey = -1;
    public int[] arr;
    
    public int[] solution(int n, int[] info) {
        int[] answer = new int[info.length];
        arr = new int[info.length];
        this.info = info;
        int[] lion = new int[info.length];
        
        dfs(0, n, lion);
        if(maxDiff==0) answer = new int[]{-1};
        else answer = arr;
        
        return answer;
    }
    
    public void dfs(int idx, int cnt, int[] lion){
        if(idx>=lion.length || cnt<=0){
            count(lion, cnt);
            return;
        }
        
        dfs(idx+1, cnt, lion);
        
        if(cnt >= info[idx]+1){
            lion[idx] = info[idx]+1;
            dfs(idx+1, cnt-(info[idx]+1), lion);
            lion[idx] = 0;
        }
    }
    
    public void count(int[] lion, int cnt){
        int a=0, b=0;
        
        for(int i=0; i<lion.length; i++){
            if(lion[i]==0 && info[i]==0) continue;
            
            if(lion[i]<=info[i]) a+=(10-i);
            else b+=(10-i);
        }
        
        int diff = b - a;
        if(diff<=0) return;
        
        long key = 0;
        for(int i = lion.length - 1; i >= 0; i--){
            key = key * 11 + lion[i];
        }

        if(diff > maxDiff || (diff == maxDiff && key > bestKey)){
            maxDiff = diff;
            bestKey = key;

            int[] result = lion.clone();
            result[result.length - 1] += cnt; 
            arr = result;
        }
    }
}