import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;

        // 중요 단어 만들기
        Map<String, Integer> important = new HashMap<>();
        Set<Integer> processed = new HashSet<>(); // 시작 인덱스 (중복 방지)
        for(int[] spoiler : spoiler_ranges){
            
            // 단어 시작점 찾기
            int s = spoiler[0];
            while(s>=0){
                if(message.charAt(s)==' ') break;
                s--;
            }
            
            // 단어 끝점 찾기
            int e = spoiler[1];
            while(e<message.length()){
                if(message.charAt(e)==' ') break;
                e++;
            }
            
            StringBuilder sb = new StringBuilder();
            int wordStart = s+1;
            for(int i=s+1; i<e; i++){
                if(message.charAt(i)==' '){
                    String str = sb.toString().trim();
                    
                    if(!str.isEmpty() && !processed.contains(wordStart)) {
                        important.put(str, important.getOrDefault(str,0)+1);
                        processed.add(wordStart);
                    }
                    
                    sb = new StringBuilder();
                    wordStart = i + 1;
                    continue;
                }
                sb.append(message.charAt(i));
            }
            
            String str = sb.toString().trim();
            if(!str.isEmpty() && !processed.contains(wordStart)) {
                important.put(str, important.getOrDefault(str,0)+1);
                processed.add(wordStart);
            }
        }
        
        // 중요 단어 아닌거 지우기
        String[] arr = message.split(" ");
        Map<String, Integer> check = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            check.put(arr[i], check.getOrDefault(arr[i],0)+1);
        }
        
        for(String key : important.keySet()){
            if(important.get(key).equals(check.get(key))){
                answer++;
            }
        }
        
        return answer;
    }
}