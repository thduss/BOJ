class Solution {
    public static boolean[] visited;
    public static int maxCnt = -1;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visited = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons);
        answer = maxCnt;
        
        return answer;
    }
    
    public void dfs(int nk, int cnt, int[][] dungeons){
        maxCnt = Math.max(maxCnt, cnt);
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && nk>=dungeons[i][0]){
                visited[i] = true;
                dfs(nk-dungeons[i][1], cnt+1, dungeons);
                visited[i] = false;
            }
        }
    }
    
}