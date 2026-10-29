import java.util.*;

class Solution {  
    public Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int[][] land) {
        int answer = 0;
        
        int num = 10;
        int[][] landMap = new int[land.length][land[0].length];
        
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(land[i][j]==1 && landMap[i][j]<=0){
                    find(land, landMap, num++, i, j);
                }
            }
        }
        
        for(int i=0; i<land[0].length; i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<land.length; j++){
                if(landMap[j][i]>0) set.add(landMap[j][i]);
            }
            int sum=0;
            for(int n : set){
                sum += map.get(n);
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    
    public void find(int[][] land, int[][] landMap, int num, int sx, int sy){
        int N = landMap.length;
        int M = landMap[0].length;
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int cnt=1;
        
        queue.add(new int[]{sx, sy});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            landMap[cur[0]][cur[1]] = num;
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(landMap[nx][ny]>0 || land[nx][ny]==0) continue;
                
                cnt++;
                landMap[nx][ny]=num;
                queue.add(new int[]{nx, ny});
            }
        }
        
        map.put(num, cnt);
    }
}