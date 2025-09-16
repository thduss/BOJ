class Solution {
    static int[] sNumbers;
    static int sTarget;
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        sTarget = target;
        sNumbers = numbers;
        
        dfs(0, 0);
        
        return answer;
    }
    
    public void dfs(int sum, int idx){
        if(idx>=sNumbers.length){
            if(sum==sTarget) answer++;
            return;
        }
        
        dfs(sum+sNumbers[idx], idx+1);
        dfs(sum-sNumbers[idx], idx+1);
        
    }
}