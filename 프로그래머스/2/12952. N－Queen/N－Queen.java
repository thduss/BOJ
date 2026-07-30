import java.util.*;

class Solution {
    public int cnt, N;
    
    public int solution(int n) {
        int answer = 0;
        cnt = 0;
        N = n;
        
        dfs(0, new int[n]);
        
        answer = cnt;
        return answer;
    }
    
    public void dfs(int n, int[] arr){
        if(n==N){
            cnt++;
            return;
        }
        
        for(int i=0; i<N; i++){
            arr[n] = i;
            
            if(Possible(n, arr)){
                dfs(n+1, arr);
            }
        }
        
        return;
    }
    
    public boolean Possible(int n, int[] arr){
        for(int i=0; i<n; i++){
            if(arr[n]==arr[i]) return false;
            if(Math.abs(n-i)==Math.abs(arr[n]-arr[i])) return false;
        }
        
        return true;
    
    }
}