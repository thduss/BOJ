import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings);
        Arrays.sort(strings, (a,b) -> {
            return Character.compare(a.charAt(n), b.charAt(n));
        });
        
        return strings;
    }
}