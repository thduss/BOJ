// O또는 X가 가로 세로 대각선으로 3개가 같은 표시 -> 승리 없으면 무승부
// 규칙 지킴? 1 : 0

import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = 1;

        boolean win1 = find(board, 'O');
        boolean win2 = find(board, 'X');
        
        int cnt1 = count(board, 'O');
        int cnt2 = count(board, 'X');
        
        if(win1 && cnt1<=cnt2){
            answer = 0;
        }
        
        if(win2 && cnt1>cnt2){
            answer = 0;
        }
        
        if (cnt1-cnt2<0 || cnt1-cnt2>1) {
            answer = 0;
        }
        
        return answer;
    }
    
    public boolean find(String[] board, char c){
        boolean isFind = false;
        
        for(int i=0; i<board.length; i++){
            // 가로
            if(board[i].charAt(0)==c && board[i].charAt(1)==c && board[i].charAt(2)==c){
                isFind = true;
                break;
            }
            
            // 세로
            if(board[0].charAt(i)==c && board[1].charAt(i)==c && board[2].charAt(i)==c){
                isFind = true;
                break;
            }
        }
        
        // 대각선
        if(board[0].charAt(0)==c && board[1].charAt(1)==c && board[2].charAt(2)==c){
            isFind = true;
        }
        if(board[0].charAt(2)==c && board[1].charAt(1)==c && board[2].charAt(0)==c){
            isFind = true;
        }
        
        return isFind;
    }
    
    public int count(String[] board, char c){
        int cnt = 0;
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                if(board[i].charAt(j)==c) cnt++;
            }
        }
        
        return cnt;
    }
    
}