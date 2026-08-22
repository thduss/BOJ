import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]!=0 && !visited[i][j]){
                    numberOfArea++;
                    
                    int size = bfs(i, j, picture, visited);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int bfs(int x, int y, int[][] picture, boolean[][] visited){
        int cnt=0;
        int N = picture.length;
        int M = picture[0].length;
        int area = picture[x][y];
        
        int[] dx = {0,0,1,-1};
        int[] dy = {-1,1,0,0};
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            cnt++;
            int[] cur = queue.poll();
            
            for(int i=0; i<4; i++){
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];
                
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(visited[nx][ny]) continue;
                if(picture[nx][ny] != area) continue;
                
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
        
        return cnt;
    }
}