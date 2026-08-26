import java.util.*;

class Solution {
    public List<Integer> list;
    
    public int solution(int[] nums) {
        int answer = 0;

        list = new ArrayList<>();
        comb(0, 0, 0, nums);

        for(int n : list){
            if(check(n)) answer++;
        }
        return answer;
    }
    
    public void comb(int idx, int cnt, int sum, int[] nums){
        if(cnt==3){
            list.add(sum);
            return;
        }
        
        if(idx>=nums.length) return;
        
        comb(idx+1, cnt, sum, nums);
        comb(idx+1, cnt+1, sum+nums[idx], nums);
    }
    
    public boolean check(int num){
        if(num<=1) return false;
        
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }
        
        return true;
    }
}