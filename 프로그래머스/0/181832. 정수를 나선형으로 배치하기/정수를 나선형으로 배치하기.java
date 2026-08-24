// 상하좌우 테두리 줄이기
class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int top = 0, left = 0, right = n-1, bottom = n-1;
        int num = 1;
        while(num<=n*n){
            for(int y = left; y<=right; y++) answer[top][y] = num++;
            top++;
            
            for(int x = top; x<=bottom; x++) answer[x][right] = num++;
            right--;
            
            for(int y = right; y>=left; y--) answer[bottom][y] = num++;
            bottom--;
            
            for(int x = bottom; x>=top; x--) answer[x][left] = num++;
            left++;
        }
        
        return answer;
    }
}