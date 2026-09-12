import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        char pre = words[0].charAt(0);
        for(int i=0; i<words.length; i++){
            String word = words[i];
            
            if(set.contains(word) || word.length()<2 || word.charAt(0)!=pre){
                answer[0] = i%n+1;
                answer[0] = answer[0]==0 ? n : answer[0];
                answer[1] = (i+1)/n;
                answer[1] += ((i+1)%n==0) ? 0 : 1;
                
                return answer;
            } 
            
            pre = word.charAt(word.length()-1);
            set.add(word);
        }

        return answer;
    }
}