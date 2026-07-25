import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;

        int rowLen = relation.length;
        int colLen = relation[0].length;
        List<Integer> candidateKey = new ArrayList<>();
        
        for(int subset = 1; subset < (1 << colLen); subset++){
            if(!checkMin(subset, candidateKey)) continue;
            
            if(checkUnique(subset, relation)){
                candidateKey.add(subset);
            }
        }
        
        answer = candidateKey.size();
        return answer;
    }
    
    public static boolean checkUnique(int subset, String[][] relation){
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<relation.length; i++){
            StringBuilder sb = new StringBuilder();
            
            for(int j=0; j<relation[0].length; j++){
                
                if((subset & (1<<j)) != 0){
                    sb.append(relation[i][j]);
                }
            }
            
            String str = sb.toString();
            if(set.contains(str)){
                return false;
            }
            
            set.add(str);
        }
        
        return true;
    }
    
    public static boolean checkMin(int subset, List<Integer> candidateKey){
        for(int key : candidateKey){
            if((key & subset)==key){
                return false;
            }
        }
        return true;
    }   
    
}