import java.util.*;

class Solution {
    public static Map<String, List<Integer>> people;
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        people = new HashMap<>();
        
        for(int i=0; i<info.length; i++){
            String[] arr = info[i].split(" ");
            
            dfs(0, "", arr);
        }
        
        for(String key : people.keySet()){
            Collections.sort(people.get(key));
        }
        
        for(int i=0; i<query.length; i++){
            String q = query[i];
            String[] arr = q.split(" ");
            int score = Integer.parseInt(arr[7]);
            
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<arr.length-1; j++){
                if(arr[j].equals("and")) continue;
                sb.append(arr[j]);
            }
            
            if(!people.containsKey(sb.toString())) {
                answer[i] = 0;
            } else {
                answer[i] = binarySearch(people.get(sb.toString()), score);
            }
        }
        
        return answer;
    }
    
    public static void dfs(int idx, String str, String[] arr){
        if(idx>=arr.length){
            people.putIfAbsent(str.split(" ")[0], new ArrayList<>());
            int score = Integer.parseInt(str.split(" ")[1]);
            people.get(str.split(" ")[0]).add(score);
            return;
        }
        
        if(idx==arr.length-1) {
            dfs(idx+1, str + " " + arr[idx], arr);
            return;
        }
        
        dfs(idx+1, str + "-", arr);
        dfs(idx+1, str + arr[idx], arr);
    }
    
    public int binarySearch(List<Integer> list, int score){
        int s=0, e=list.size();
        
        while(s<e){
            int mid = (s+e)/2;
            
            if(list.get(mid)<score){
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        
        return list.size() - s;
    }
}