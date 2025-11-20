import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder out = new StringBuilder();

        if (N >= K) {
            out.append(N - K).append("\n");
            for (int i = N; i >= K; i--)
                out.append(i).append(" ");

            System.out.println(out.toString());
            return;
        } else {
            int[] path = bfs(N, K);
            out.append(path.length - 1).append("\n");
            for (int num : path)
                out.append(num).append(" ");

            System.out.println(out.toString());
        }

    }

    public static int[] bfs(int N, int K) {
        // time[x] -> x 위치일 때 최소시간
        int[] time = new int[100001];
        int[] parent = new int[100001];

        Arrays.fill(time, -1);
        Arrays.fill(parent, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(N);
        time[N] = 0;
        parent[N] = -1;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == K)
                break;

            int[] next = { x - 1, x + 1, x * 2 };
            int nextTime = time[x] + 1;

            for (int nextX : next) {
                if (nextX < 0 || nextX > 100000)
                    continue;

                // 처음 방문
                if (time[nextX] == -1) {
                    parent[nextX] = x;
                    time[nextX] = nextTime;
                    q.add(nextX);
                }
            }

        }

        int len = time[K] + 1;
        int[] path = new int[len];
        int cur = K;
        for (int i = len - 1; i >= 0; i--) {
            path[i] = cur;
            cur = parent[cur];
        }
        return path;

    }
}