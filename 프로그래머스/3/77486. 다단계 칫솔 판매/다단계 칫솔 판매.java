import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};

        Map<String, Integer> money = new HashMap<>();
            
        Map<String, String> parents = new HashMap<>();
        for(int i=0; i<enroll.length; i++){
            parents.put(enroll[i], referral[i]);
        }
        
        for(int i=0; i<seller.length; i++){
            
            String person = seller[i];
            int currentMoney = amount[i] * 100;
            
            while(!person.equals("-")){
                // 부모에게 줄 돈
                int give = currentMoney/10;
                
                int mine = currentMoney - give;
                money.put(person, money.getOrDefault(person, 0)+mine);
                
                if(give==0) break;
                
                person = parents.get(person);
                currentMoney = give;
            }
        }
        
        answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++){
            answer[i] = money.getOrDefault(enroll[i],0);
        }
        
        
        return answer;
    }
}