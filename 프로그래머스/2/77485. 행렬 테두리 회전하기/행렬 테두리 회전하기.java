import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];
        
        int num = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                board[r][c] = num++;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            int r1 = queries[i][0] - 1;
            int c1 = queries[i][1] - 1;
            int r2 = queries[i][2] - 1;
            int c2 = queries[i][3] - 1;
            
            answer[i] = rotate(board, r1, c1, r2, c2);
        }
        
        return answer;
    }
    
    public int rotate(int[][] board, int r1, int c1, int r2, int c2) {
        int temp = board[r1][c1];
        int minVal = temp; 
        
        // 1. 좌측 변 (아래에서 위로 끌어올림)
        for (int r = r1; r < r2; r++) {
            board[r][c1] = board[r + 1][c1];
            minVal = Math.min(minVal, board[r][c1]);
        }
        
        // 2. 하단 변 (오른쪽에서 왼쪽으로 끌어옴)
        for (int c = c1; c < c2; c++) {
            board[r2][c] = board[r2][c + 1];
            minVal = Math.min(minVal, board[r2][c]);
        }
        
        // 3. 우측 변 (위에서 아래로 끌어내림)
        for (int r = r2; r > r1; r--) {
            board[r][c2] = board[r - 1][c2];
            minVal = Math.min(minVal, board[r][c2]);
        }
        
        // 4. 상단 변 (왼쪽에서 오른쪽으로 끌어옴)
        for (int c = c2; c > c1; c--) {
            board[r1][c] = board[r1][c - 1];
            minVal = Math.min(minVal, board[r1][c]);
        }
        
        // 5. 처음에 임시 저장했던 값을 마지막 빈 칸(오른쪽으로 한 칸 간 위치)에 삽입
        board[r1][c1 + 1] = temp;
        
        return minVal;
    }
}