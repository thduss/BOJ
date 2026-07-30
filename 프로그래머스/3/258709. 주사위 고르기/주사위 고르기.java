import java.util.*;

class Solution {
    public int N, MAX_WIN;
    public int[][] dices;
    List<Integer> list;
    
    public int[] solution(int[][] dice) {
        N = dice.length;
        dices = dice;
        int[] answer = new int[N/2];
        MAX_WIN = Integer.MIN_VALUE;
        list = new ArrayList<>();
        
        // 주사위 2/n개 조합
        comb(0, 0, new HashSet<>());
        
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i)+1;
        }
        
        return answer;
    }
    
    public void comb(int start, int depth, Set<Integer> set){
        if(depth==N/2){
            int nwin = find(set);
                
            if(nwin>MAX_WIN){
                MAX_WIN = nwin;
                list = new ArrayList<>();
                for(int num : set) list.add(num);
            }
            return;
        }
        
        for(int i=start; i<N; i++){
            set.add(i);
            comb(i+1, depth+1, set);
            set.remove(i);
        }
    }
    
    public int find(Set<Integer> set){
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            if(set.contains(i)){
                a.add(i);
            } else {
                b.add(i);
            }
        }
        
        List<Integer> aSums = new ArrayList<>();
        List<Integer> bSums = new ArrayList<>();
        
        makeSums(a, 0, 0, aSums);
        makeSums(b, 0, 0, bSums);
        
        Collections.sort(bSums);
        
        int winCount = 0;
        for (int aSum : aSums) {
            winCount += countSmaller(bSums, aSum);
        }
        
        return winCount;
    }
    
    public void makeSums(List<Integer> targetDices, int depth, int currentSum, List<Integer> sumList) {
        if (depth == N/2) {
            sumList.add(currentSum);
            return;
        }

        int diceIndex = targetDices.get(depth);
        for (int i= 0; i < 6; i++) {
            makeSums(targetDices, depth + 1, currentSum + dices[diceIndex][i], sumList);
        }
    }
    
    public int countSmaller(List<Integer> bSums, int target) {
        int left = 0;
        int right = bSums.size(); 

        while (left < right) {
            int mid = (left + right) / 2;

            if (bSums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}