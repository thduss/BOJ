import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        // 누적합
        int N = board.length, M = board[0].length;
        int[][] sum = new int[N+1][M+1];
        
        for(int[] s : skill){
            int r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4], degree = s[5];
            
            if(s[0]==1){
                // (-)
                sum[r1][c1] -= degree;
                sum[r1][c2+1] += degree;
                sum[r2+1][c1] += degree;
                sum[r2+1][c2+1] -= degree;
            } else {
                // (+)
                sum[r1][c1] += degree;
                sum[r1][c2+1] -= degree;
                sum[r2+1][c1] -= degree;
                sum[r2+1][c2+1] += degree;
            }
        }
        
        // 누적합 계산
        for(int i=0; i<sum.length; i++){
            for(int j=1; j<sum[0].length; j++){
                sum[i][j] += sum[i][j-1];
            }
        }
        for(int i=1; i<sum.length; i++){
            for(int j=0; j<sum[0].length; j++){
                sum[i][j] += sum[i-1][j];
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]+sum[i][j]>0){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}