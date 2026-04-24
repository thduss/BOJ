import java.util.*;

class Solution { 
    public static Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();
   
        
        for(int i=0; i<course.length; i++){
            map = new HashMap<>(); 
            
            for(String order : orders){
                char[] charArray = order.toCharArray();
                Arrays.sort(charArray);
                String sortedOrder = new String(charArray);
                
                if (sortedOrder.length() >= course[i]) {
                    comb(0, sortedOrder, new StringBuilder(), course[i]);
                }
            }
            
            if (!map.isEmpty()) {
                int max = Collections.max(map.values());
                if (max >= 2) {
                    for (String key : map.keySet()) {
                        if (map.get(key) == max) answerList.add(key);
                    }
                }
            }
        }
    
        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }
    
    public void comb(int start, String order, StringBuilder sb, int r) {
        if (r == 0) {
            String res = sb.toString();
            map.put(res, map.getOrDefault(res, 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            comb(i + 1, order, sb, r - 1);
            sb.setLength(sb.length() - 1);
        }
    }
}