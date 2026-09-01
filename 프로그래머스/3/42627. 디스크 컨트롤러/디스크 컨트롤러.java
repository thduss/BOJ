/*
- 작업 번호, 요청 시각, 소요 시간
- 소요시간 짧 > 요청 시각 빠름 > 작업 번호 작음
- 반환 시간 = 끝남 - 요청
*/
import java.util.*;

class Solution {
    public class Node implements Comparable<Node> {
        int no, requestTime, serviceTime;
        
        public Node(int no, int requestTime, int serviceTime){
            this.no = no;
            this.requestTime = requestTime;
            this.serviceTime = serviceTime;
        }
        
        @Override
        public int compareTo(Node o){
            if(this.serviceTime != o.serviceTime){
                return this.serviceTime - o.serviceTime;
            }
            
            if(this.requestTime != o.requestTime){
                return this.requestTime - o.requestTime;
            }
            
            return this.no - o.no;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.sort(jobs, (a,b)-> a[0] - b[0]);
        
        int time = 0, idx=0;
        while(idx<jobs.length){
            while(idx<jobs.length && jobs[idx][0]<=time){
                pq.add(new Node(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if(!pq.isEmpty()){
                Node cur = pq.poll();
                time += cur.serviceTime;
                answer += (time - cur.requestTime);
            } else {
                time = jobs[idx][0];
            }
        }
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            time += cur.serviceTime;
            answer += (time - cur.requestTime);
        }
        
        answer /= jobs.length;
        
        return answer;
    }
}