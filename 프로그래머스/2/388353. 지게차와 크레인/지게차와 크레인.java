import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = storage.length * storage[0].length();
        
        boolean[][] visited = new boolean[storage.length][storage[0].length()];
        
        for(String request : requests){
            int cnt=0;
            if(request.length()>=2) {
                cnt = crain(request, storage, visited);
            } else {
                cnt = find(request, storage, visited);
            }
            
            answer -= cnt;
        }
        
        return answer;
    }
    
    // 안까지
    public int crain(String request, String[] storage, boolean[][] visited){
        int cnt = 0;
        char req = request.charAt(0);
        
        for(int i=0; i<storage.length; i++){
            for(int j=0; j<storage[0].length(); j++){
                if(!visited[i][j] && storage[i].charAt(j)==req){
                    cnt++;
                    visited[i][j] = true;
                }
            }
        }
        
        return cnt;
    }
    
    // 겉에만
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,-1,1};
    
    public int find(String request, String[] storage, boolean[][] visited){
        int cnt = 0;
        char req = request.charAt(0);
        int n = storage.length; 
        int m = storage[0].length();
        
        boolean[][] bfsVisited = new boolean[n+2][m+2];
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{0,0});
        bfsVisited[0][0] = true;
        
        List<int[]> remove = new ArrayList<>();
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx<0 || nx>=n+2 || ny<0 || ny>=m+2) continue;
                
                if(!bfsVisited[nx][ny]) {
                    bfsVisited[nx][ny] = true;
                    
                    if(nx==0 || nx==n+1 || ny==0 || ny==m+1) {
                        queue.add(new int[]{nx, ny});
                    } else {
                        int x = nx-1;
                        int y = ny-1;
                        
                        if(visited[x][y]){
                            queue.add(new int[]{nx,ny});
                        } else {
                            if(storage[x].charAt(y)==req){
                                remove.add(new int[]{x,y});
                            }
                        }
                    }
                }
            }
        }
        
        for(int[] arr : remove){
            int x = arr[0];
            int y = arr[1];
            
            if(!visited[x][y]){
                visited[x][y] = true;
                cnt++;
            }
        }
        
        return cnt;
    }
}