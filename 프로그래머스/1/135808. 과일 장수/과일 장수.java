// 1~k점
// p * m (p: 가장 낮은 점수)
// 최대 이익

import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        
        for(int i=score.length-1; i>=m-1; i-=m){
            int p = k;
            for(int j=i; j>i-m; j--){
                p = Math.min(p, score[j]);
            }
            
            answer += p*m;
        }
        return answer;
    }
}