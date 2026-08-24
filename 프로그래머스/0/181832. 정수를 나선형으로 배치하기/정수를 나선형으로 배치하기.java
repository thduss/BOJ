class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int num=1, cnt=n;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        
        int x=0, y=0;
        while(num<=n*n){
            // ->
            for(int i=0; i<cnt && num<=n*n; i++){
                if(x==0 && y==0 && i==0) {
                    answer[x][y] = num++;
                    continue;
                }
                x += dx[0];
                y += dy[0];
                answer[x][y] = num++;
            }
            cnt--;
            
            // v
            for(int i=0; i<cnt && num<=n*n; i++){
                x += dx[1];
                y += dy[1];
                answer[x][y] = num++;
            }
            
            // <-
            for(int i=0; i<cnt && num<=n*n; i++){
                x += dx[2];
                y += dy[2];
                answer[x][y] = num++;
            }
            cnt--;
            
            // ^
            for(int i=0; i<cnt && num<=n*n; i++){
                x += dx[3];
                y += dy[3];
                answer[x][y] = num++;
            }
        }
        
        return answer;
    }
}