// col번째 오름차순, 첫번째 내림차순 정렬
// S_i % i번째 행 합
// S_i XOR bitwise
// 중복 제거

import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        List<int[]> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(int[] d : data){
            if(set.contains(d[0])) continue;
            
            list.add(d);
            set.add(d[0]);
        }
        
        Collections.sort(list, (a,b) -> {
            if(a[col-1] == b[col-1]){
                return b[0] - a[0];
            }
            return a[col-1] - b[col-1];
        });
        
        for(int i=row_begin-1; i<row_end; i++){
            int s = 0;
            
            int[] arr = list.get(i);
            for(int n : arr){
                s += (n%(i+1));
            }
            
            answer ^= s;
        }
        
        return answer;
    }
}