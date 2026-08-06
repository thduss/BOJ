import java.util.*;

class Solution {
    public class Node{
        String word;
        int cnt;
        
        public Node(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visited = new boolean[words.length];
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(begin, 0));
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            if(cur.word.equals(target)){
                answer = cur.cnt;
                break;
            }
            
            for(int i=0; i<words.length; i++){
                if(!visited[i] && check(words[i], cur.word)){
                    visited[i] = true;
                    queue.add(new Node(words[i], cur.cnt+1));
                }
            }
            
        }
        
        return answer;
    }
    
    public boolean check(String str1, String str2){
        int diff = 0;
        
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i)!=str2.charAt(i)) diff++;
        }
        
        return diff==1 ? true : false;
    }
}