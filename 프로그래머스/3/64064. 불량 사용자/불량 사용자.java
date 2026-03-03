import java.util.*;

class Solution {
    
    public static HashSet<String> resultSet = new HashSet<>();
    public static boolean[] visited;
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        visited = new boolean[user_id.length];
        
        dfs(0, user_id, banned_id, "");
        answer = resultSet.size();
        
        return answer;
    }
    
    private static void dfs(int index, String[] user_id, String[] banned_id, String currentSet){
        
        if(index == banned_id.length){
            String[] ids = currentSet.trim().split(" ");
            Arrays.sort(ids);
            resultSet.add(Arrays.toString(ids));
            return;
        }
        
        for(int i=0; i<user_id.length; i++){
            if(visited[i] || !isMatched(user_id[i], banned_id[index])){
                continue;
            }
                visited[i] = true;
                dfs(index+1, user_id, banned_id, currentSet + " " + i);
                visited[i] = false;
        }
    }
    
    private static boolean isMatched(String user, String bann) {
        if (user.length() != bann.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            if (bann.charAt(i) == '*') continue;
            if (user.charAt(i) != bann.charAt(i)) return false;
        }
        return true;
    }
}