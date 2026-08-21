// (스테이지에 도달 & 아직 클리어 X) / (스테이지에 도달)

import java.util.*;

class Solution {
    public class Node implements Comparable<Node>{
        int num;
        float fail;
        
        Node(int num, float fail){
            this.num = num;
            this.fail = fail;
        }
        
        @Override
        public int compareTo(Node o){
            if(this.fail < o.fail) return 1;
            else if (this.fail > o.fail) return -1;
            else return 0;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        List<Node> fail = new ArrayList<>();
        Arrays.sort(stages);
        
        int total = stages.length, idx=0;
        
        for(int i=1; i<=N; i++){
            int cnt = 0;
            while(idx<stages.length && stages[idx]<=i){
                idx++;  
                cnt++;
            }
            
            float f = total==0 ? 0 : (float)cnt / total;
            fail.add(new Node(i, f));
            total-=cnt;
        }
        
        Collections.sort(fail);
        for(int i=0; i<N; i++){
            answer[i] = fail.get(i).num;
        }
        
        return answer;
    }
}