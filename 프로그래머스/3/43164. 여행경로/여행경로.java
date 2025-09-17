import java.util.*;

class Solution {
    static String[] answer;
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        answer = null;
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (o1,o2)-> {
            if(o1[0].equals(o2[0])){
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });
        
        List<String> list = new ArrayList<>();
        list.add("ICN");
        dfs("ICN", list, tickets);
        
        return answer;
    }
    
    public void dfs(String start, List<String> list, String[][] tickets){
        if(list.size()==tickets.length+1){
            if(answer==null)
                answer = list.toArray(new String[0]);
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                list.add(tickets[i][1]);
                
                dfs(tickets[i][1], list, tickets);
                
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}