import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, pick;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        pick = new int[M];
        visited = new boolean[N];

        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) sb.append(pick[i]).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            pick[depth] = arr[i];
            dfs(depth + 1);
            visited[i] = false;   // 백트래킹
        }
    }
}
