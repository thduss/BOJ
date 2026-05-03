import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        
        HashSet<Integer> set = new HashSet<>();
        for(int i : reserve){
            set.add(i);
        }
        
        Arrays.sort(lost);
        
        for(int i=0; i<lost.length; i++){
            if(set.contains(lost[i])){
                answer++;
                set.remove(lost[i]);
                lost[i] = -1;
            }
        }
        
        for(int i=0; i<lost.length; i++){
            if(lost[i]==-1) continue;
            
            if(set.contains(lost[i]-1)){
                answer++;
                set.remove(lost[i]-1);
            } else if (set.contains(lost[i]+1)){
                answer++;
                set.remove(lost[i]+1);
            }
        }
        
        return answer;
    }
}