import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String oper : operations){
            String[] arr = oper.split(" ");
            
            if(arr[0].equals("I")){
                minHeap.add(Integer.parseInt(arr[1]));
                maxHeap.add(Integer.parseInt(arr[1]));
            } else if (arr[0].equals("D") && arr[1].equals("1")){
                if(maxHeap.isEmpty()) continue;
                int max = maxHeap.remove();
                minHeap.remove(max);
            } else {
                if(minHeap.isEmpty()) continue;
                int min = minHeap.remove();
                maxHeap.remove(min);
            }
        }

        if(!maxHeap.isEmpty()){
            answer[0] = maxHeap.peek();
            answer[1] = minHeap.peek();
        }
        
        return answer;
    }
}