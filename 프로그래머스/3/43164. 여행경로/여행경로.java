import java.util.*;

class Solution {
    List<String> list;
    boolean[] visited;
    boolean found = false;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        list = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a,b) -> {
            if(!a[0].equals(b[0])) {
                return a[0].compareTo(b[0]);
            }
            return a[1].compareTo(b[1]);
        });
        
        list.add("ICN");
        find("ICN", 0, tickets);
        
        answer = new String[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public void find(String city, int cnt, String[][] tickets){
        if(cnt==tickets.length) {
            found = true;
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(visited[i]) continue;
            if(tickets[i][0].equals(city)){
                visited[i] = true;
                list.add(tickets[i][1]);
                find(tickets[i][1], cnt+1, tickets);
                
                if(found) return;
                
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}