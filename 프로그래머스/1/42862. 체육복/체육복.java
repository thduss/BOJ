import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Set<Integer> set = new HashSet<>();
        for(int i : reserve) set.add(i);
        
        Arrays.sort(lost);
        
        // 자기 자신
        for(int i=0; i<lost.length; i++){
            int num = lost[i];
            
            if(set.contains(num)){
                answer++; 
                set.remove(num);
                lost[i]=-1;
            }
        }
        
        // 앞 사람 먼저 빌려주기
        for(int i : lost){
            if(i==-1) continue;
            
            if(set.contains(i-1)){
                answer++; 
                set.remove(i-1);
            } else if(set.contains(i+1)){
                answer++;
                set.remove(i+1);
            }
        }
        
        return answer;
    }
}