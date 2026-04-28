import java.util.*;

class Solution {
    
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = new HashSet<>();
        
        for(String num : phone_book){
            set.add(num);
        }
        
        for(int i=0; i<phone_book.length; i++){
            String number = phone_book[i];
            
            for(int j=1; j<number.length(); j++){
                if(set.contains(number.substring(0,j))){
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }
}