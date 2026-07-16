import java.util.*;

class Solution {
    public class Node{
        int cnt;
        String str;
        
        public Node(int cnt, String str){
            this.cnt = cnt;
            this.str = str;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.add(new Node(0, begin));
        
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            if(cur.str.equals(target)){
                answer = cur.cnt;
                break;
            }
            
            for(int i=0; i<words.length; i++){
                if(visited[i]) continue;
                
                if(check(cur.str, words[i])){
                    visited[i] = true;
                    queue.add(new Node(cur.cnt+1, words[i]));
                }
            }
        }
        
        return answer;
    }
    
    public boolean check(String s1, String s2){
        int diff=0;
        
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)) diff++;
        }
        
        return diff==1 ? true : false;
    }
}