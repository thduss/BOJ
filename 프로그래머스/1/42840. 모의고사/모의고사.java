import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] correct = new int[3];
        for(int i=0; i<answers.length; i++){
            int idx = i%5;
            if(arr1[idx]==answers[i]) correct[0]++;
            
            
            idx = i%8;
            if(arr2[idx]==answers[i]) correct[1]++;
            
            
            idx = i%10;
            if(arr3[idx]==answers[i]) correct[2]++;
        }
        
        int maxNum=0;
        for(int i=0; i<3; i++){
            maxNum = Math.max(maxNum, correct[i]);
        }
        
        List<Integer> list = new LinkedList<>();
        for(int i=0; i<3; i++){
            if(maxNum==correct[i]){
                list.add(i+1);
            }
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}