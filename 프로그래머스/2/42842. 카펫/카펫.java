import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        if(yellow==1){
            answer[0]=3;
            answer[1]=3;
        } else if (yellow==2){
            answer[0]=4;
            answer[1]=3;
        }
        
        for(int y = 3; y <= sum / y; y++){
            if (sum % y == 0) {
                int x = sum / y;
                if(x*y==sum && isPossible(x,y,yellow)){
                    answer[0]=x;
                    answer[1]=y;
                }
            }
        }
        
        return answer;
    }
    
    public static boolean isPossible(int x, int y, int yellow){
        if((x-2)*(y-2)==yellow){
            return true;
        }
        return false;
    }
}