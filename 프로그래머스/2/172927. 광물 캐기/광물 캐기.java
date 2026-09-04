import java.util.*;

class Solution {
    public class Node{
        int dia, iron, stone;
        
        public Node(int dia, int iron, int stone){
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        // 광물은 순서대로 캠 -> 연속 5개
        int pcnt = picks[0] + picks[1] + picks[2];
        List<Node> list = new ArrayList<>();
        for(int i=0; i<Math.min(minerals.length, pcnt*5); i+=5){
            int dia=0, iron=0, stone=0;
            
            for(int j=i; j<i+5 && j<minerals.length; j++){
                if(minerals[j].equals("diamond")){
                    dia++;
                } else if (minerals[j].equals("iron")){
                    iron++;
                } else {
                    stone++;
                }
            }
            
            list.add(new Node(dia, iron, stone));
        }
        
        Collections.sort(list, (a,b)-> {
            if(a.dia!=b.dia) return b.dia - a.dia;
            if(a.iron!=b.iron) return b.iron - a.iron;
            return b.stone - a.stone;
        });
        
        int idx=0;
        for(int i=0; i<picks.length; i++){
            int cnt = picks[i];
            
            while(cnt-->0 && idx<list.size()){
                answer += get(i, list.get(idx++));
            }
        }
        
        return answer;
    }
    
    public int get(int i, Node n){
        int[][] minus = {{1,1,1},{5,1,1},{25,5,1}};
        int answer=0;
        
        answer += n.dia * minus[i][0];
        answer += n.iron * minus[i][1];
        answer += n.stone * minus[i][2];
        
        return answer;
    }
}