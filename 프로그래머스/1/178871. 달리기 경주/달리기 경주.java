import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};

        Map<String, Integer> imap = new HashMap<>();
        for(int i=0; i<players.length; i++){
            imap.put(players[i], i);
        }
        
        for(String call : callings){
            int i = imap.get(call);
            
            String tmp = players[i-1];
            players[i-1] = players[i];
            players[i] = tmp;
            
            imap.put(tmp, imap.getOrDefault(tmp, 0)+1);
            imap.put(call, i-1);
        }
        
        answer = players;
        
        return answer;
    }
}