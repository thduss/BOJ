import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        long factorial = 1;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            factorial *= i;
            list.add(i);
        }
        
        k--;
        for(int i=0; i<n; i++){
            int num = n - i;
            factorial/=num;
            
            int idx = (int) (k/factorial);
            answer[i] = list.get(idx);
            list.remove(idx);
            k %= factorial;
        }
        
        return answer;
    }
}