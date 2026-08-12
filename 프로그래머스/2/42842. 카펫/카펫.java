// 가로>세로
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        for(int i=1; i<=2500; i++){
            for(int j=1; j<=i; j++){
                int cnt = i*2 + j*2 - 4;
                
                if(cnt==brown){
                    if(yellow==(i-2)*(j-2)){
                        answer = new int[2];
                        answer[0] = i;
                        answer[1] = j;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}