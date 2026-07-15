import java.util.*;

class Solution {
    public class Node implements Comparable<Node>{
        int t1, t2, t3;
        
        public Node(int t1, int t2, int t3){
            this.t1 = t1;
            this.t2 = t2;
            this.t3 = t3;
        }
        
        // 큐 순서 : 소요시간 짧은것 > 요청시각 빠른것 > 작업 번호 작은것
        @Override
        public int compareTo(Node o){
            if(t1==o.t1){
                if(t2==o.t2){
                    return t3 - o.t3;
                }
                return t2 - o.t2;
            }
            return t1 - o.t1;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int time=0;
        int idx=0;
        
        Arrays.sort(jobs, (a,b)-> a[0]-b[0]);
        
        while(idx<jobs.length || !pq.isEmpty()){
            
            while(idx<jobs.length && jobs[idx][0]<=time){
                pq.add(new Node(jobs[idx][1], jobs[idx][0], idx));
                idx++;
            }
            
            if(!pq.isEmpty()){
                Node cur = pq.poll();
                time += cur.t1;
                answer += (time-cur.t2);
            } else {
                time = jobs[idx][0];
            }
        }
            
        return answer/jobs.length;
    }
}