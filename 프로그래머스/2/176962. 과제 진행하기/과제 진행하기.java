import java.util.*;

class Solution {
    public class Node{
        int time;
        String name;
        
        Node(int time, String name){
            this.time = time;
            this.name = name;
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        List<String> ans = new ArrayList<>();
        
        Arrays.sort(plans, (a,b) -> a[1].compareTo(b[1]));
        
        Stack<Node> st = new Stack<>();        
        for(int i=0; i<plans.length; i++){
            if(i==plans.length-1) {
                ans.add(plans[i][0]);
                continue;
            }
            String[] tmp = plans[i][1].split(":");
            int h = Integer.parseInt(tmp[0]);
            int m = Integer.parseInt(tmp[1]);
            int play = Integer.parseInt(plans[i][2]);
            
            tmp = plans[i+1][1].split(":");
            int nh = Integer.parseInt(tmp[0]);
            int nm = Integer.parseInt(tmp[1]);
            
            int time = (nh*60+nm) - (h*60+m+play);
            
            if(time>=0){
                ans.add(plans[i][0]);
                
                while(time>0 && !st.isEmpty()){
                    Node cur = st.pop();
                    
                    if(cur.time>time){
                        st.add(new Node(cur.time-time, cur.name));
                        time = 0;
                    } else {
                        time-=cur.time;
                        ans.add(cur.name);
                    }
                }
                
            } else {
                st.add(new Node(-time, plans[i][0]));
            }
        }
        
        while(!st.isEmpty()){
            Node cur = st.pop();
            ans.add(cur.name);
        }
        
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}