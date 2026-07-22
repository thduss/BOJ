import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        
        boolean isPlus = true;
        int index = 0;
        int check = 0;
        for(int i=1; i<=n; i++){
            list.get(index).add(i);
            
            if(i==num){
                check=index;
            }
            
            if(i%w==0){
                isPlus = !isPlus;
                continue;
            }
            
            if(isPlus){
                index++;
            } else {
                index--;
            }
        }
        
        isPlus=false;
        for(int c : list.get(check)){
            if(c==num){
                isPlus = true;
            }
            
            if(isPlus){
                answer++;
            }
        }
        
        return answer;
    }
}