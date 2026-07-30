// 선물을 더 많이 준 사람이 받음
// 기록이 없거나 받은 수가 똑같다면 -> 선물 지수가 더 큰 사람이 받음
// 선물지수 = (준 선물 수) - (받은 선물 수)
// 선물지수도 같으면 주고받지 않음
// 출력값 = 가장 많이 받을 친구의 선물 수

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = -1;
        int n = friends.length;
        
        Map<String, Integer> name = new HashMap<>();
        for(int i=0; i<n; i++){
            name.put(friends[i], i);
        }
        
        int[][] present = new int[n][n];
        
        for(String g : gifts){
            String[] gift = g.split(" ");
            
            int a = name.get(gift[0]);
            int b = name.get(gift[1]);
            
            present[a][b]+=1;
        }
        
        int[] score = new int[n];
        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=i+1; j<n; j++){
                // 선물을 더 많이 준 사람이 받음
                if(present[i][j]!=present[j][i]){
                    if(present[i][j]>present[j][i]){
                        score[i]++;
                    } else {
                        score[j]++;
                    }
                    continue;
                }
                
                // 선물 지수가 더 큰 사람
                int a = getScore(i, present);
                int b = getScore(j, present);
                
                if(a==b) continue;
                
                if(a>b) score[i]++;
                if(a<b) score[j]++;
            }
        }
        
        for(int s : score) answer = Math.max(s, answer);
        
        return answer;
    }
    
    public int getScore(int num, int[][] present){
        int give=0, take=0;
        
        for(int i=0; i<present.length; i++){
            give += present[num][i];
            take += present[i][num];
        }
        
        return give - take;
    }
}