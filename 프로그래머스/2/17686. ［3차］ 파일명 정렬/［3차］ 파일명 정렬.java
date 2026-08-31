import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        String[][] split = new String[files.length][3];
        for(int i=0; i<files.length; i++){
            split[i] = StrSplit(files[i]);
        }
        
        Arrays.sort(split, (a, b) -> {
            if(a[0].compareToIgnoreCase(b[0])!=0){
                return a[0].compareToIgnoreCase(b[0]);
            }
            
            int n1 = Integer.parseInt(a[1]);
            int n2 = Integer.parseInt(b[1]);
            return Integer.compare(n1, n2);
        });
        
        for(int i=0; i<files.length; i++){
            answer[i] = split[i][0] + split[i][1] + split[i][2];
        }
        
        return answer;
    }
    
    public String[] StrSplit(String str){
        String[] split = new String[3];
        
        String head="", number="", tail="";
        int i=0;
        
        while(i<str.length() && !Character.isDigit(str.charAt(i))){
            head += str.charAt(i++);
        }
        
        while(i<str.length() && Character.isDigit(str.charAt(i))){
            number += str.charAt(i++);
        }
        
        while(i<str.length()){
            tail += str.charAt(i++);
        }
        
        split[0] = head;
        split[1] = number;
        split[2] = tail;
        
        return split;
    }
}