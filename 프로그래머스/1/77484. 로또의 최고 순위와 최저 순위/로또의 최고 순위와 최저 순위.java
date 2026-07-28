import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        
        boolean[] lotto = new boolean[46];
        for(int l : win_nums) lotto[l] = true;
        
        int correct = 0, remove = 0;
        for(int n : lottos){
            if(n<=0) {
                remove++;
            } else {
                if(lotto[n]){
                    System.out.println(n);
                    correct++;
                }
            }
        }
        
        System.out.println(correct + " " + remove);
        answer = new int[2];
        
        // 최대등수
        answer[0] = getGrade(correct + remove);
        answer[1] = getGrade(correct);
        
        return answer;
    }
    
    public int getGrade(int cnt){
        if(cnt==6){
            return 1;
        } else if (cnt==5){
            return 2;
        } else if (cnt==4){
            return 3;
        } else if (cnt==3){
            return 4;
        } else if (cnt==2){
            return 5;
        } else {
            return 6;
        }
    }
}