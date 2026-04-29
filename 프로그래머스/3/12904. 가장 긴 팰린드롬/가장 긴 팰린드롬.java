import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(palindrome(i, j, s)){
                    answer = Math.max(answer, j-i+1);
                }
            }
        }        

        return answer;
    }
    
    public static boolean palindrome(int f, int e, String s){
        
        while(f<=e){
            if(s.charAt(f)!=s.charAt(e)){
                return false;
            }
            
            f++;
            e--;
        }
        
        return true;
    }
}