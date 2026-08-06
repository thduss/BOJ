// 곡괭이 5개 연속 사용 
// 최소 피로도: 다이아몬드 -> 철 -> 돌 순서

import java.util.*;

class Solution {
    
    public class Chunks implements Comparable<Chunks>{
        int dia=0, iron=0, stone=0, weight=0;
        
        @Override
        public int compareTo(Chunks o){
            return o.weight - this.weight;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        List<Chunks> list = new ArrayList<>();
        
        int totalPicks = picks[0] + picks[1] + picks[2];
        int maxMineralCount = Math.min(minerals.length, totalPicks * 5);
        
        for(int i=0; i<maxMineralCount; i+=5){
            int end = Math.min(maxMineralCount, i+5);
            
            Chunks nc = new Chunks();
            
            for(int j=i; j<end; j++){
                String m = minerals[j];
                
                if(m.equals("diamond")){
                    nc.dia++;
                    nc.weight+=25;
                } else if(m.equals("iron")){
                    nc.iron++;
                    nc.weight+=5;
                } else {
                    nc.stone++;
                    nc.weight+=1;
                }
            }
            
            list.add(nc);
        }
        
        Collections.sort(list);
        
        // 다이아부터
        for(int i=0; i<list.size(); i++){
            Chunks c = list.get(i);
            
            if(picks[0]>0){
                answer += (c.dia + c.iron + c.stone);
                picks[0]--; 
            } else if (picks[1]>0){
                answer += (c.dia*5 + c.iron + c.stone);
                picks[1]--; 
            } else if (picks[2]>0){
                answer += (c.dia*25 + c.iron*5 + c.stone);
                picks[2]--; 
            }
        }
        
        
        return answer;
    }
}