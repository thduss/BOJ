import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};

        int total = 0;
        for(int i=1; i<=n; i++) total+=i;
        answer = new int[total];
        
        int size = n;
        int num = 1, idx=-1, row=-1;
        while(num <= total){
            // 아래로 등차수열 증가
            for(int i=0; i<size && num<=total; i++){
                row++;
                idx = (idx == -1) ? 0 : idx + row;
                answer[idx] = num++;
            }
            size--;
            
            // +1씩 증가
            for(int i=0; i<size && num<=total; i++){
                idx++;
                answer[idx] = num++;
            }
            size--;
            
            // 위로 등차수열 감소
            for(int i=0; i<size && num<=total; i++){
                idx -= (row+1);
                row--;
                answer[idx] = num++;
            }
            size--;
        }
        
        return answer;
    }
}