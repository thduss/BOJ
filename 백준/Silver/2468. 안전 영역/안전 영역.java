import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[n][n];
        int height = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, map[i][j]);
            }
        }

        int max=0;
        for(int h=0; h<height+1; h++){
            checked = new boolean[n][n];

            int cnt=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!checked[i][j] && map[i][j]>h){
                        cnt+=dfs(i,j,h);
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);

    }

    // 안전 영역
    static int[] dx = {0,0,1,-1};
    static int[] dy = {-1,1,0,0};
    public static int dfs(int x, int y, int high){
        checked[x][y] = true;

        for(int  i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>n-1 || ny>n-1) continue;
            if(checked[nx][ny]) continue;
            if(map[nx][ny]>high){
                dfs(nx, ny, high);
            }
        }
        return 1;
    }
}
