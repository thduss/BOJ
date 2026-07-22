import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        
        Map<String, String> parent = new HashMap<>();
        for(int i=0; i<enroll.length; i++){
            parent.put(enroll[i], referral[i]);
        }
        
        // 10% 부모에게 배분 + 90% 본인
        Map<String, Integer> sell = new HashMap<>();
        
        for(int i=0; i<seller.length; i++){
            Queue<String> queue = new LinkedList<>();
            queue.add(seller[i]);
            int money = amount[i]*100;
            
            while(!queue.isEmpty()){
                String cur = queue.poll();
                
                if(cur.equals("-") || money == 0){
                    break;
                }
                
                int give = money / 10;
                int mine = money - give;
                
                sell.put(cur, sell.getOrDefault(cur, 0)+mine);
                money = give;
                
                queue.add(parent.get(cur));
            }
        }
        
        answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++){
            answer[i] = sell.getOrDefault(enroll[i],0);
        }
        
        return answer;
    }
}