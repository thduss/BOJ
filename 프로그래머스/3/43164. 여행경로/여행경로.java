import java.util.*;

class Solution {
    public static boolean[] visited;
    public static ArrayList<String> ans = new ArrayList<>();
    public static boolean found = false;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        Arrays.sort(tickets, (a,b) -> {
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            } else {
                return a[0].compareTo(b[0]);
            }
        });
        
        visited = new boolean[tickets.length];
        ans.add("ICN");
        dfs("ICN", tickets, 0);
        
        answer = new String[ans.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    public static void dfs(String start, String[][] tickets, int count){
        if(count == tickets.length){
            found = true;
            return;    
        }
        
        for(int i=0; i<tickets.length; i++){
            if(visited[i]) continue;
            if(tickets[i][0].equals(start)){
                visited[i] = true;
                ans.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, count+1);
                
                if(found) return;
                
                visited[i] = false;
                ans.remove(ans.size()-1);
            }
        }
        
        return;
    }
}