import java.util.*;

class Solution {
    public int[] answer;
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        int N = arr.length;
        
        split(arr, 0,0, N);
        
        return answer;
    }
    
    public void split(int[][]arr, int x, int y, int size){
        if(isSame(arr, x,y,size)){
            answer[arr[x][y]]++;
            return;
        }
        
        int half = size/2;
        split(arr, x, y, half);
        split(arr, x+half, y, half);
        split(arr, x, y+half, half);
        split(arr, x+half, y+half, half);
    }
    
    public boolean isSame(int[][] arr, int sx, int sy, int n){
        for(int i=sx; i<sx+n; i++){
            for(int j=sy; j<sy+n; j++){
                if(arr[i][j]!=arr[sx][sy]) return false;
            }
        }
        return true;
    }
}