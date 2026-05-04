import java.util.*;

class Solution {
    static Set<Integer> set;
    static boolean[] visited;
    static int[] number;
    
    public int solution(String numbers) {
        int answer = 0;
        
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        number = new int[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++){
            number[i] = numbers.charAt(i) - '0';
        }
        
        dfs("");
        
        for(int num : set){
            if(isPrime(num)){
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(String num){
        if(num!=""){
            set.add(Integer.parseInt(num));
        }
        
        if(num.length()==number.length){
            return;
        }
        
        for(int i=0; i<number.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(num+number[i]);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int num){
        if(num<2){
            return false;
        }
        
        for(int i=2; i<num; i++){
            if(num%i==0){
                return false;
            }
        }
        
        return true;
    }
}