import java.util.*;

class Solution {
    
    public static int count=0;
    public static int[] arr;
    
    public int solution(int n) {
        int answer = 0;
        
        arr = new int[n];
        
        nQueen(0, n);
        answer = count;
        
        return answer;
    }
    
    public static void nQueen(int depth, int N){
        
        if(depth == N) {
            count++;
            return;
        }
        
        for(int i=0; i<N; i++){
            arr[depth] = i;
            
            if(Possibility(depth)){
                nQueen(depth+1, N);
            }
        }
    }
    
    public static boolean Possibility(int col){
        for(int i=0; i<col; i++){
            if(arr[col]==arr[i]){
                return false;
            }
            else if (Math.abs(col-i)==Math.abs(arr[col]-arr[i])){
                return false;
            }
        }
        
        return true;
    }
}