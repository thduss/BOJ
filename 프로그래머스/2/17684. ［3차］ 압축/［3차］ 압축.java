import java.util.*;

// LZW 알고리즘 
// 가장 긴 문자열 w -> w에 해당하는 색인 번호 찾아 w 대체  

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};

        String alpa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] arr = alpa.split("");
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], i+1);
        }
        
        int num = arr.length + 1;
        int i=0;
        List<Integer> list = new ArrayList<>();
        
        while(i<msg.length()){
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(i));
            int j = i+1;
            
            while(j<=msg.length()){
                String w = sb.toString();
                
                if(j==msg.length()){
                    list.add(map.get(w));
                    break;
                }
                
                sb.append(msg.charAt(j));
                String c = sb.toString();
                
                if(map.getOrDefault(c,-1)==-1){
                    map.put(c, num++);
                    list.add(map.get(w));
                    break;
                }
                j++;
            }
            
            i = j;
        }
        
        answer = new int[list.size()];
        for(int id=0; id<list.size(); id++){
            answer[id] = list.get(id);
        }
        
        return answer;
    }
}