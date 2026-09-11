import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        new_id = new_id.toLowerCase();
        new_id = removeUnique(new_id);
        new_id = oneComma(new_id);
        new_id = sComma(new_id);
        new_id = eComma(new_id);
        
        if(new_id.length()<=0) new_id="a";
        if(new_id.length()>=16){
            new_id = new_id.substring(0,15);
            new_id = eComma(new_id);
        }
        
        if(new_id.length()<=2) {
            char c = new_id.charAt(new_id.length()-1);
            
            while(new_id.length()<3) new_id += c;
        }
        
        answer = new_id;
        
        return answer;
    }
    
    public String sComma(String str){
        StringBuilder sb = new StringBuilder(str);
        while(sb.length()>0 && sb.charAt(0)=='.') sb.delete(0,1);
        return sb.toString();
    }
    
    public String eComma(String str){
        StringBuilder sb = new StringBuilder(str);
        while(sb.length()>0 && sb.charAt(sb.length()-1)=='.') sb.delete(sb.length()-1,sb.length());
        return sb.toString();
    }
    
    public String removeUnique(String str){
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            
            if(!Character.isDigit(c) && !Character.isLetter(c) && c!='.' && c!='-' && c!='_') continue;
            
            sb.append(c);
        }
        
        return sb.toString();
    }
    
    public String oneComma(String str){
        StringBuilder sb = new StringBuilder();
        boolean isComma = false;
        
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            
            if(c=='.'){
                if(!isComma){
                    isComma = true;
                    sb.append(c);
                } 
            } else {
                isComma = false;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}