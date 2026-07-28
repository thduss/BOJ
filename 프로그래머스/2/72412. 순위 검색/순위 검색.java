import java.util.*;

class Solution {

    Map<String, ArrayList<Integer>> map;
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        // 조합
        map = new HashMap<>();
        for(String str : info){
            String[] p = str.split(" ");
            make_comb(p, "", 0);
        }
        
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }
        
        for(int i=0; i<query.length; i++){
            query[i] = query[i].replace("and ", "");
            String[] q = query[i].split(" ");
            
            String key = q[0] + q[1] + q[2] + q[3];
            int score = Integer.parseInt(q[4]);
            
            if(map.containsKey(key)){
                ArrayList<Integer> scores = map.get(key);
                
                // 이분탐색
                answer[i] = binarySearch(scores, score);
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    public void make_comb(String[] info, String str, int depth){
        if(depth==4){
            int score = Integer.parseInt(info[4]);
            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(score);
            return;
        }
        
        make_comb(info, str + info[depth], depth+1);
        make_comb(info, str + "-", depth+1);
    }
    
    public int binarySearch(ArrayList<Integer> arr, int score){
        int l=0, r=arr.size();
        
        while(l<r){
            int mid = (l+r)/2;
            
            if(score<=arr.get(mid)){
                r = mid;
            } else {
                l = mid+1;
            }
        }
        
        return arr.size()-l;
    }
}