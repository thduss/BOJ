import java.util.*;

class Solution {
    int colLen, rowLen;
    boolean[] visited;
    List<String> candidateKeys = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int answer = 0;

        colLen = relation[0].length;
        rowLen = relation.length;
        visited = new boolean[colLen];
        
        for(int i=1; i<=colLen; i++){
            comb(0,0,i,relation);
        }
        
        return candidateKeys.size();
    }
    
    public void comb(int start, int depth, int targetCnt, String[][] relation){
        if(depth == targetCnt){
            checkKey(relation);
            return;
        }
        
        for(int i=start; i<colLen; i++){
            visited[i] = true;
            comb(i+1, depth + 1, targetCnt, relation);
            visited[i] = false;
        }
    }
    
    public void checkKey(String[][] relation){
        
        StringBuilder currentKeyBuilder = new StringBuilder();
        for (int i = 0; i < colLen; i++) {
            if (visited[i]) {
                currentKeyBuilder.append(i);
            }
        }
        String currentKey = currentKeyBuilder.toString();
        
        // 최소성
        for (String key : candidateKeys) {
            int matchCount = 0;
            for (char c : key.toCharArray()) {
                if (currentKey.indexOf(c) != -1) matchCount++;
            }
            if (matchCount == key.length()) return; 
        }
        
        // 유일성
        HashSet<String> tupleSet = new HashSet<>();
        for (int i = 0; i < rowLen; i++) {
            StringBuilder tuple = new StringBuilder();
            for (int j = 0; j < colLen; j++) {
                if (visited[j]) {
                    tuple.append(relation[i][j]).append(","); 
                }
            }
            tupleSet.add(tuple.toString());
        }
        
        if (tupleSet.size() == rowLen) {
            candidateKeys.add(currentKey);
        }
    }
}