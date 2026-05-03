import java.util.*;

class Solution {
    public class Task implements Comparable<Task> {
        String subject;
        int h, m, time;
        
        public Task(String subject, int h, int m, int time){
            this.subject = subject;
            this.h = h;
            this.m = m;
            this.time = time;
        } 
        
        @Override
        public int compareTo(Task o){
            if(this.h==o.h){
                return this.m - o.m;
            } else {
                return this.h - o.h;
            }
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = {};

        List<Task> list = new ArrayList<>();
        
        for(String[] plan : plans){
            String[] tmp = plan[1].split(":");
            int h = Integer.parseInt(tmp[0]);
            int m = Integer.parseInt(tmp[1]);
            
            list.add(new Task(plan[0], h, m, Integer.parseInt(plan[2])));
        }
        
        Collections.sort(list);
        
        List<String> ans = new ArrayList<>();
        int hour=list.get(0).h, min=list.get(0).m;
        Stack<Task> st = new Stack<>();
        
        for(int i=0; i<list.size(); i++){
            Task cur = list.get(i);
            min += cur.time;
            if(min>=60){
                hour+=(min/60);
                min%=60;
            }
            
            if(i==list.size()-1){
                ans.add(cur.subject);
                continue;
            }
            
            // 다음 과제 이전에 끝나?
            Task next = list.get(i+1);
            
            if(next.h>hour || (next.h==hour && next.m>=min)){
                ans.add(cur.subject);
                
                // 대기 중인 과제는 다음 과제 이전에 끝나?
                while(!st.isEmpty()){
                    Task ref = st.peek();
                    int rm = min + ref.time;
                    int rh = hour;
                    if(rm>=60){
                        rh+=(rm/60);
                        rm%=60;
                    }
                    
                    if(next.h>rh || (next.h==rh && next.m>=rm)){
                        hour = rh;
                        min = rm;
                        
                        st.pop();
                        ans.add(ref.subject);
                    } else {
                        int diff = (next.h - hour) * 60 + next.m - min;
                        Task r = st.pop();
                        r.time -= diff;
                        st.add(r);
                        hour = next.h;
                        min = next.m;
                        
                        break;
                    }
                }
                
                if(st.isEmpty()){
                    hour = next.h;
                    min = next.m;
                }
                
            } else {
                int diff = (next.h - cur.h) * 60 + next.m - cur.m;
                cur.time -= diff;
                st.add(cur);
                hour = next.h;
                min = next.m;
            }
            
        }
        
        // 남은 과제 하나씩 해결
        while(!st.isEmpty()){
            Task cur = st.pop();
            ans.add(cur.subject);
        }
        
        return ans.toArray(new String[ans.size()]);
    }
}