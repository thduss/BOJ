import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, output;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        output = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        backtrack(0);
        System.out.print(sb);
    }

    static void backtrack(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && arr[i] != prev) {
                visited[i] = true;
                output[depth] = arr[i];
                prev = arr[i];
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
}