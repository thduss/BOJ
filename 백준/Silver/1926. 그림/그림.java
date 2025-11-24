import java.util.*;
import java.io.*;

public class Main {
    public static boolean[][] map;
    public static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = (num == 1) ? true : false;
            }
        }

        int maxWidth = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j]) {
                    cnt++;
                    maxWidth = Math.max(maxWidth, bfs(i, j));
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxWidth);
    }

    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static int bfs(int start, int end) {
        int cnt = 0;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { start, end });

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (!map[cur[0]][cur[1]])
                continue;
            cnt++;
            map[cur[0]][cur[1]] = false;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if (map[nx][ny])
                    que.add(new int[] { nx, ny });
            }
        }

        return cnt;
    }
}
