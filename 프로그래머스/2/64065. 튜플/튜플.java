import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};

        String[] str = s.replace("{", "").replace("}}", "},").split("},");
        Arrays.sort(str, (a,b) -> a.length() - b.length());
        
        answer = new int[str.length];
        Set<Integer> set = new HashSet<>();
        int idx = 0;
        for(String ss : str){
            String[] tmp = ss.split(",");
            
            for(String a : tmp){
                if(!set.contains(Integer.parseInt(a))){
                    set.add(Integer.parseInt(a));
                    answer[idx++] = Integer.parseInt(a);
                }
            }
        }
        
        return answer;
    }
}