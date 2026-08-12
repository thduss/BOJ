// 행 선택, 삭제, 복구
// U X칸 위에 있는 행 선택
// D X칸 아래에 있는 행 선택
// C 현재 선택된 행 삭제 후 바로 아래행 선택 (마지막일 떄는 바로 윗 행)
// Z 삭제 행 복구
import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] deleted = new boolean[n];
        for(int i=0; i<n; i++){
            prev[i] = i-1;
            next[i] = i+1;
        }
        
        Stack<Integer> remove = new Stack<>();
        
        int num = k;
        for(int i=0; i<cmd.length; i++){
            String c = cmd[i];
            String[] arr = c.split(" ");
            
            if(arr[0].equals("D")){
                int x = Integer.parseInt(arr[1]);
                while(x-- > 0) num = next[num];
            } else if (arr[0].equals("U")){
                int x = Integer.parseInt(arr[1]);
                while(x-- > 0) num = prev[num];
            } else if(arr[0].equals("C")) {
                deleted[num] = true;
                remove.push(num);
            
                int p = prev[num];
                int nx = next[num];
                
                if(nx >= n) num = p;
                else num = nx;
                
                if(p >= 0) next[p] = nx;
                if(nx < n) prev[nx] = p;
                
            } else {
                if(remove.isEmpty()) continue;
                
                int t = remove.pop();
                deleted[t] = false;
                
                int p = prev[t];
                int nx = next[t];
                
                if(p >= 0) next[p] = t;
                if(nx < n) prev[nx] = t;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(deleted[i]==true ? "X" : "O");
        }
        answer = sb.toString();
        
        return answer;
    }
}