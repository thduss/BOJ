import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxdiff = -1;
        
        m = Normalize(m);
        
        for(String mu : musicinfos){
            String[] arr = mu.split(",");
            int start = transTime(Normalize(arr[0]));
            int end = transTime(Normalize(arr[1]));
            int diff = end - start;
            
            arr[3] = Normalize(arr[3]);
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<diff; i++){
                sb.append(arr[3].charAt(i % arr[3].length()));
            }
            
            if(contain(m, sb.toString()) && maxdiff<diff){
                answer = arr[2];
                maxdiff = diff;
            }
        }
        
        return answer.equals("") ? "(None)" : answer;
    }
    
    public String Normalize(String s){
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            if(i+1<s.length() && s.charAt(i+1)=='#'){
                sb.append(Character.toLowerCase(s.charAt(i)));
            } else if (s.charAt(i)=='#'){
                continue;
            } else {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
    
    public int transTime(String s){
        String[] tmp = s.split(":");
        int[] arr = new int[2];
        
        arr[0] = Integer.parseInt(tmp[0]);
        arr[1] = Integer.parseInt(tmp[1]);
        
        return arr[0]*60+arr[1];
    }
    
    public boolean contain(String m, String str){
        if(m.length()>str.length()) return false;
        
        return str.contains(m);
    }
}