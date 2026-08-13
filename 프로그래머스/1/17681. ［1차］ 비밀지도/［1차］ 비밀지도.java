// 암호 해독 
// 벽#, 공백 
// 두 지도 겹쳐서 하나라도 벽이면 벽

import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<n; i++){
            String str1 = Integer.toBinaryString(arr1[i]);
            String str2 = Integer.toBinaryString(arr2[i]);
            
            while (str1.length() < n) str1 = "0" + str1;
            while (str2.length() < n) str2 = "0" + str2;
            
            StringBuilder sb = new StringBuilder();
            
            for(int j=0; j<n; j++){
                char c1 = str1.charAt(j);
                char c2 = str2.charAt(j);
                
                if(c1=='1' || c2=='1'){
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}