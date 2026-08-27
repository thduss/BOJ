import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ans = new ArrayList<>();
        
        for(int i=0; i<orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            orders[i] = str;
        }
        
        for(int i=0; i<course.length; i++){
            find(orders, course[i]);
        }
        
        answer = new String[ans.size()];
        Collections.sort(ans);
        for(int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
    
    public Map<String, Integer> map;
    List<String> ans;
    
    public void find(String[] orders, int len){
        map = new HashMap<>();
        
        for(String order : orders){
            comb(0, "", order, len);
        }
        
        int max = 0;
        List<String> maxList = new ArrayList<>();
        for(String key : map.keySet()){
            if(max<map.get(key)){
                max = map.get(key);
                maxList = new ArrayList<>();
                maxList.add(key);
            } else if (max==map.get(key)){
                maxList.add(key);
            }
        }
        
        if(max<2) return;
        for(String str : maxList){
            ans.add(str);
        }
    }
    
    public void comb(int idx, String str, String word, int len){
        if(str.length()==len){
            map.put(str, map.getOrDefault(str, 0)+1);
            return;
        }
        
        if(str.length()>=len) return;
        if(idx>=word.length()) return;
        
        comb(idx+1, str+word.charAt(idx), word, len);  
        comb(idx+1, str, word, len);
    }
}