import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();
        
        for(int[] command : commands){
            int start = command[0]-1;
            int end = command[1]-1;
            
            int[] arr = new int[end-start+1];
            int idx = 0;
            for(int i=start; i<=end; i++){
                arr[idx++] = array[i];
            }
            
            Arrays.sort(arr);
            list.add(arr[command[2]-1]);   
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}