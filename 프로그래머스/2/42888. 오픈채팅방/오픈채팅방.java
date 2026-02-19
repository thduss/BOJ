import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> map = new HashMap<>();
        for(String str : record){
            String[] splitStr = str.split(" ");
            
            if(splitStr[0].equals("Enter") || splitStr[0].equals("Change")){
                if(map.containsKey(splitStr[1])){
                    map.replace(splitStr[1], splitStr[2]);
                } else {
                    map.put(splitStr[1], splitStr[2]);
                }
            }
        }

        List<String> list = new ArrayList<>();
        for(String str : record){
            String[] splitStr = str.split(" ");
            if(splitStr[0].equals("Enter")){
                String name = map.get(splitStr[1]);
                list.add(name+"님이 들어왔습니다.");
            } else if(splitStr[0].equals("Leave")) {
                String name = map.get(splitStr[1]);
                list.add(name+"님이 나갔습니다.");
            } else {
                continue;
            }
        }
        
        String[] answer = list.toArray(String[]::new);
        
        return answer;
    }
}