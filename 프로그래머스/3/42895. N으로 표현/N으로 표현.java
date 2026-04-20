import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;

        if(N==number) return 1;
        
        List<Set<Integer>> dp = new ArrayList<>();
        for(int i=0; i<=8; i++){
            dp.add(new HashSet<>());
        }
        
        int baseNum = 0; 
        for(int i=1; i<=8; i++){
            baseNum = baseNum * 10 + N;
            dp.get(i).add(baseNum);
        }
        
        for(int i=1; i<9; i++){
            for(int j=1; j<i; j++){
                int k = i-j;
                
                for(int num1 : dp.get(j)){
                    for(int num2 : dp.get(k)){
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if(num2 != 0)
                            dp.get(i).add(num1 / num2);
                    }
                }
            }
            
            if(dp.get(i).contains(number)){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}