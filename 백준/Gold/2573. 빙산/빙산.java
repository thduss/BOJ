import java.io.*;
import java.util.*;

public class Main {
    public static int[][] iceMap;
    public static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        iceMap = new int[N][M];
        int maxHight=0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++){
                iceMap[i][j] = Integer.parseInt(st.nextToken());
                maxHight = Math.max(maxHight, iceMap[i][j]);
            }
        }

        int year = 0;
        while (true) {
            int count = iceCheck();

            if (count >= 2) {
                System.out.println(year);
                return;
            }

            if (count == 0) {
                System.out.println(0);
                return;
            }

            meltIce();
            year++;
        }
    }

    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    // 빙산 녹히기
    public static void meltIce() {
        int[][] meltAmount = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceMap[i][j] > 0) {
                    int seaCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M && iceMap[nx][ny] == 0) {
                            seaCount++;
                        }
                    }
                    meltAmount[i][j] = seaCount;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceMap[i][j] > 0) {
                    iceMap[i][j] -= meltAmount[i][j];
                    if (iceMap[i][j] < 0) iceMap[i][j] = 0;
                }
            }
        }
    }

    // 빙산 덩어리 확인
    public static int iceCheck(){
        int ice = 0;
        boolean[][] visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(iceMap[i][j]==0) continue;
                if(visited[i][j]) continue;
                
                ice++;
                bfs(i,j,visited);
            }
        }

        return ice;
    }

    // 한 덩어리 방문
    public static void bfs(int i, int j, boolean[][] visited){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        visited[i][j]=true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int idx=0; idx<4; idx++){
                int nx = cur[0]+dx[idx];
                int ny = cur[1]+dy[idx];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (iceMap[nx][ny] > 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

    }
}
