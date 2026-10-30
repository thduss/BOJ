import java.util.*;

class Solution {
    public int[] dx = {0,0,-1,1};
    public int[] dy = {-1,1,0,0};
    
    public int solution(int[][] maze) {
        int answer = 0;

        int N = maze.length; 
        int M = maze[0].length;
        
        int[] start = new int[4];
        int[] end = new int[4];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(maze[i][j]==1){
                    start[0] = i;
                    start[1] = j;
                } else if(maze[i][j]==2){
                    start[2] = i;
                    start[3] = j;
                } else if(maze[i][j]==3){
                    end[0] = i;
                    end[1] = j;
                } else if(maze[i][j]==4){
                    end[2] = i;
                    end[3] = j;
                }
            }
        }
        
        answer = bfs(start, end, N, M, maze);
        
        return answer;
    }
    
    public int bfs(int[] start, int[] end, int N, int M, int[][] maze){
        Queue<int[]> queue = new ArrayDeque<>();
        
        int rMask  = 1 << (start[0] * M + start[1]);
        int bMask = 1 << (start[2] * M + start[3]);
        
        queue.add(new int[]{start[0], start[1], start[2], start[3], 0, rMask, bMask});
        int answer = 0;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            if(cur[0]==end[0] && cur[1]==end[1] && cur[2]==end[2] && cur[3]==end[3]){
                answer = cur[4];
                break;
            }
            
            if(cur[0]==end[0] && cur[1]==end[1]){
                // blue만 움직이기
                for(int i=0; i<4; i++){
                    int bx = cur[2] + dx[i];
                    int by = cur[3] + dy[i];
                    
                    if(bx<0 || bx>=N || by<0 || by>=M) continue;
                    if(maze[bx][by] == 5) continue;
                    if(bx==cur[0] && by==cur[1]) continue;
                    
                    // 방문체크
                    int bit = bx * M + by;
                    if ((cur[6] & (1 << bit)) != 0) continue;
                    
                    int newMask = cur[6] | (1 << bit);
                    queue.add(new int[]{cur[0], cur[1], bx, by, cur[4]+1, cur[5], newMask});
                }
            } else if(cur[2]==end[2] && cur[3]==end[3]){
                //red만 움직이기
                for(int i=0; i<4; i++){
                    int rx = cur[0] + dx[i];
                    int ry = cur[1] + dy[i];
                    
                    if(rx<0 || rx>=N || ry<0 || ry>=M) continue;
                    if(maze[rx][ry] == 5) continue;
                    if(rx==cur[2] && ry==cur[3]) continue;
                    
                    int bit = rx * M + ry;
                    if ((cur[5] & (1 << bit)) != 0) continue;

                    int newMask = cur[5] | (1 << bit);
                    queue.add(new int[]{rx, ry, cur[2], cur[3], cur[4]+1, newMask, cur[6]});
                }
            } else {
                for(int i=0; i<4; i++){
                    int rx = cur[0] + dx[i];
                    int ry = cur[1] + dy[i];
                    
                    if(rx<0 || rx>=N || ry<0 || ry>=M) continue;
                    if(maze[rx][ry] == 5) continue;
                    
                    int bit = rx * M + ry;
                    if ((cur[5] & (1 << bit)) != 0) continue;
                    
                    for(int j=0; j<4; j++){
                        int bx = cur[2] + dx[j];
                        int by = cur[3] + dy[j];
                        
                        if(bx<0 || bx>=N || by<0 || by>=M) continue;
                        if(rx==bx && ry==by) continue;
                        if(rx==cur[2] && ry==cur[3] && bx==cur[0] && by==cur[1]) continue;
                        if(maze[bx][by] == 5) continue;

                        int bbit = bx * M + by;
                        if ((cur[6] & (1 << bbit)) != 0) continue;
                        
                        int nrMask = cur[5] | (1 << bit);
                        int nbMask = cur[6] | (1 << bbit);
                        
                        queue.add(new int[]{rx, ry, bx, by, cur[4]+1, nrMask, nbMask});
                    }
                }
            }
        }
        return answer;
    }
}