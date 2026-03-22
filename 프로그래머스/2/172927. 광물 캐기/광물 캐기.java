import java.util.*;

class Solution {
    
    static class MineralChunk implements Comparable<MineralChunk>{
        int diaCount = 0;
        int ironCount = 0;
        int stoneCount = 0;
        int weight =0;
        
        @Override
        public int compareTo(MineralChunk o){
            return o.weight - this.weight;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int totalPicks = picks[0] + picks[1] + picks[2];
        if(totalPicks==0) return 0;
        
        int maxMinerals = Math.min(totalPicks*5, minerals.length);
        
        List<MineralChunk> chunks = new ArrayList<>();
        
        for(int i=0; i<maxMinerals; i+=5){
            MineralChunk chunk = new MineralChunk();
            int end = Math.min(maxMinerals,  i+5);
            
            for(int j=i; j<end; j++){
                if(minerals[j].equals("diamond")){
                    chunk.diaCount++;
                    chunk.weight += 25;
                } else if (minerals[j].equals("iron")){
                    chunk.ironCount++;
                    chunk.weight += 5;
                } else {
                    chunk.stoneCount++;
                    chunk.weight += 1;
                }
            }
            
            chunks.add(chunk);
        }
        
        Collections.sort(chunks);
        
        for(MineralChunk chunk : chunks){
            if(picks[0]>0){
                answer += chunk.diaCount + chunk.ironCount + chunk.stoneCount;
                picks[0]--;
            } else if (picks[1]>0){
                answer += chunk.diaCount*5 + chunk.ironCount + chunk.stoneCount;
                picks[1]--;
            } else if (picks[2]>0){
                answer += chunk.diaCount * 25 + chunk.ironCount * 5 + chunk.stoneCount;
                picks[2]--;
            }
        }
        
        return answer;
    }
}