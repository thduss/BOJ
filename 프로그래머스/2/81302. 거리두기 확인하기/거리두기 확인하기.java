/*
- |r1 - r2| + |c1 - c2| <= 2
- 파티션 있으면 허용

*/
import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0; i<places.length; i++){
            boolean isOk = true;
            String[] arr = places[i];
            
            for(int j=0; j<arr.length; j++){
                for(int c=0; c<5; c++){
                    if(arr[j].charAt(c)=='P'){
                        
                        boolean isTrue = find(j, c, arr);
                        
                        if(!isTrue) {
                            isOk = false;
                            break;
                        }
                    }
                }
            }
            
            answer[i] = isOk ? 1 : 0;
        }
        
        return answer;
    }
    
    public class Node{
        int x, y;
        
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public boolean find(int x, int y, String[] map){
        int[] dx = {0,0,1,-1};
        int[] dy = {-1,1,0,0};
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x,y));
        boolean[][] visited = new boolean[5][5];
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx<0 || nx>=5 || ny<0 || ny>=5) continue;
                if(visited[nx][ny] || map[nx].charAt(ny)=='X') continue;

                int dist = Math.abs(nx - x) + Math.abs(ny - y);
                if(dist>2) continue;
                
                if(map[nx].charAt(ny)=='P'){
                    return false;
                }
                
                visited[nx][ny] = true;
                queue.add(new Node(nx, ny));
            }
        }
        return true;
    }
}